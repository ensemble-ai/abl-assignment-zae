package abl.wmes;

import java.awt.Color;
import java.awt.Point;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import game.Bot;
import game.GameEngine;
import game.GameEngine.bulletorigin;
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
	public Boolean isBotCollision(int id, int distance, int pDist, int trajectoryX, int trajectoryY) {
		Point location = (Point)(bots.get(id));
		//Point trajectory = calcTrajectory(location.x, location.y, playerLocation.x, playerLocation.y);
		/*
		 * for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == id) {
				trajectory = b.getPotentialTrajectory();
			}
		}
		*/
		if(location == null) {
			return true;
		}
		
		Point newLocation = new Point(location.x + trajectoryX, location.y + trajectoryY);
		int dist = distance + Bot.Size;
		//int dist = distance + Bot.Size + 4;
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

	public Boolean isPermanentBotCollision(int id, int padding) {
		int dist = padding + Bot.Size - GameEngine.BotSpeed;
		int size = Bot.Size;
		Point location = (Point)(bots.get(id));
	
		if(location == null) {
			return false;
		}
		
	    Iterator<Map.Entry<Integer, Point>> entries = bots.entrySet().iterator();
	    while (entries.hasNext()) {
	        Map.Entry entry = (Map.Entry)entries.next();	
	    	Point point = (Point)entry.getValue();

	    	if((int)entry.getKey() == id) {
	    		continue;
	    	}

	    	if(location.x < point.getX() + dist &&
	    			location.x + dist > point.getX()&&
	    			location.y < point.getY() + dist &&
	    			location.y + dist > point.getY()) {
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
			if(b.origin!=bulletorigin.FACTION1 && location.x < b.getX() + 4 &&	//bullet size is 4 - I'll remove this hardcoded thing in a bit
	    			location.x + size > b.getX()&&
	    			location.y < b.getY() + 4 &&
	    			location.y + size > b.getY()) {
				int targetbulletindex = (GameEngine.getInstance().getBullets()).indexOf(b);
				GameEngine.getInstance().removeBullet(targetbulletindex);
	    		return true;
			}
		}
		return false;
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
