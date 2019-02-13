package abl.wmes;

import java.awt.Color;
import java.awt.Point;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

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

	public Boolean isBotCollision(int id, Point trajectory, int dist) {
		Point location = (Point)(bots.get(id));
		Point newLocation = new Point(location.x + trajectory.x, location.y + trajectory.y);
		int oldDist, newDist;

		
		//check for collision with bots
	    Iterator<Map.Entry<Integer, Point>> entries = bots.entrySet().iterator();
	    while (entries.hasNext()) {
	        Map.Entry entry = (Map.Entry)entries.next();	
	    	if((int)entry.getKey() == id) {
	    		continue;
	    	}
    
	    	Point point = (Point)entry.getValue();
	    	oldDist = calcDistance(location.x, location.y, point.x, point.y);
	    	newDist = calcDistance(newLocation.x, newLocation.y, point.x, point.y);
	    	
	    	if(oldDist > dist && newDist <= dist) {
	    		return true;
	    	}//will be a collision if we move
	    }
		
		return false;
	}
	
	public int calcDistance(int playerX, int playerY, int botX, int botY) {
		int diffX, diffY;
		
		diffX = playerX - botX;
		diffY = playerY - botY;
	
		diffX = diffX*diffX;
		diffY = diffY*diffY;
	
		return (int)Math.sqrt(diffX + diffY); 
	}	
	
	
}
