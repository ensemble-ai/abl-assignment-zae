package abl.wmes;

import java.awt.Color;
import java.awt.Point;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import game.Bot;
import game.GameEngine;
import wm.WME;
/**
 * Stores information that will be accessible to all bots 
 * 
 */
public class BlackBoardWME extends WME {

	Map bots; //key-value pairs: bot id - bot location 
	Point playerLocation;
	
	/**
	 * Instantiates a working memory element that is shared among all bots
	 */
	public BlackBoardWME(Map bots, Point playerLocation) {
		this.bots = bots;
		this.playerLocation = playerLocation;
	}

	/**
	 * 		
	 * @param id
	 * @param dist
	 * @param pDist
	 * @return
	 */
	public Boolean isBotCollision(int id, int distance, int pDist) {
		Point location = (Point)(bots.get(id));
		Point trajectory = calcTrajectory(location.x, location.y, playerLocation.x, playerLocation.y);
		Point newLocation = new Point(location.x + trajectory.x, location.y + trajectory.y);
		int dist = distance + Bot.Size;
		
		if(pDist > calcDistance(location.x, location.y, playerLocation.x, playerLocation.y)) {
			return true;
		}//check for collisions with the player
		
	    Iterator<Map.Entry<Integer, Point>> entries = bots.entrySet().iterator();
	    while (entries.hasNext()) {
	        Map.Entry entry = (Map.Entry)entries.next();	
	    	Point point = (Point)entry.getValue();
	    
	    	if((int)entry.getKey() == id) {
	    		continue;
	    	}

	    	if(newLocation.x < point.getX() + dist &&
	    			newLocation.x + dist > point.getX()&&
	    			newLocation.y < point.getY() + dist &&
	    			newLocation.y + dist > point.getY()) {
	    		return true;
	    	}//collision
	    }//check for collision with bots
	
		return false;
	}
	
	public Point calcTrajectory(int x, int y, int targetX, int targetY) {
		final double sqrt2 = 1.41421356237;
		int dirx = 0;
		int diry = 0;
		int speed = GameEngine.BotSpeed;
		
		if(x - targetX > speed) {	
			dirx = -speed;
		}else if(x - targetX < -speed) {
			dirx = speed;			
		}
		if(y - targetY  > speed) {	
			diry = -speed;
		}else if(y - targetY < -speed) {
			diry = speed;			
		}
	
		if(dirx != 0 && diry != 0) { 
			//TODO: check, how do ints get truncated when negative?
			dirx = (int)((double)dirx * sqrt2); 
			diry = (int)((double)diry * sqrt2); 
		}//bot is heading diagonal, so mod the speed
		
		return new Point(dirx, diry);
	}
	
	public int calcDistance(int playerX, int playerY, int botX, int botY) {
		int diffX, diffY;
		
		diffX = playerX - botX;
		diffY = playerY - botY;
	
		diffX = diffX*diffX;
		diffY = diffY*diffY;
	
		return (int)Math.ceil(Math.sqrt(diffX + diffY)); 
	}	
	
	
}
