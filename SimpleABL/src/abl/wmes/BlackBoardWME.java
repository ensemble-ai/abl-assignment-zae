package abl.wmes;

import java.awt.Color;
import java.awt.Point;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import game.Bot;
import game.GameEngine;
import game.Wall;
import game.Bullet;
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
		int size = Bot.Size;
		
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
	    
		for(Wall w : GameEngine.getInstance().getWalls()) {
	    	if(newLocation.x < w.getX() + w.getWidth() &&
	    			newLocation.x + size > w.getX()&&
	    			newLocation.y < w.getY() + w.getHeight() &&
	    			newLocation.y + size > w.getY()) {
	    		return true;
	    	}//collision	
		}
	
		return false;
	}
	
	public Boolean isBulletCollision(int id) {
		//where bot was
		Point location = (Point)(bots.get(id));
		//bot size
		int size = Bot.Size;
		// when in new spot, is hit by bullet
		
		for(Bullet b : GameEngine.getInstance().getBullets()) {
			if(location.x < b.getX() + 4 &&	//bullet size is 4 - I'll remove this hardcoded thing in a bit
	    			location.x + size > b.getX()&&
	    			location.y < b.getY() + 4 &&
	    			location.y + size > b.getY()) {
				System.out.print("collide\n" + Integer.toString(id));
				int targetbulletindex = (GameEngine.getInstance().getBullets()).indexOf(b);
				GameEngine.getInstance().removeBullet(targetbulletindex);
	    		return true;
			}
		}
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
