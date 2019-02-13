package abl.wmes;

import java.awt.Color;
import java.awt.Point;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

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
	
		//check for collision with bots
	    Iterator it = bots.entrySet().iterator();
	    while (it.hasNext()) {
	    	//if
	    	
	    	
	    }
		
		
		return false;
	}
	
	
	
}
