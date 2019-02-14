package abl.wmes;

import java.awt.Color;
import java.awt.Point;

import game.GameEngine;
import wm.WME;
/**
 * Stores information about the bot.
 * 
 * @author Ben Weber 3-7-11
 * @author Josh McCoy 1-23-2019
 */
public class BotWME extends WME {

	/** Location of the bot */
	private Point location;
	
	/** Trajectory of the bot */
	private Point trajectory;
	
	/** Target destination of the bot */
	private Point destination;
	
	/** ID of the bot */
	private int id;
	
	/** Color of the bot */
	private Color color;
	
	/** Has this bot moved this round? */
	private Boolean moved;
	
	/** Has this bot fired this round? */
	private Boolean fired;
	
	
	/**
	 * Instantiates a working memory element for tracking a bot.
	 */
	public BotWME(Point location, Point trajectory, int id, Color color, Boolean moved, Boolean fired) {
		this.location = location;
		this.trajectory = trajectory;
		this.id = id;
		this.color = color;
		this.moved = moved;
		this.fired = fired;
	}

	public boolean check() {
		return true;
	}

	public Point calcTrajectory(int targetX, int targetY) { 
		Point point = location; 
		int dirx = 0;
		int diry = 0;
		int speed = GameEngine.BotSpeed;
		
		if(point.getX() - targetX > speed) {	
			dirx = -speed;
		}else if(point.getX() - targetX < -speed) {
			dirx = speed;			
		}
		if(point.getY() - targetY  > speed) {	
			diry = -speed;
		}else if(point.getY() - targetY < -speed) {
			diry = speed;			
		}
		
		return new Point(dirx, diry);
	}
	
	
	/**
	 * Returns the x location of the bot. 
	 */
	public int getLocationX() {
		return location.x;
	}
	
	/**
	 * Returns the y location of the bot. 
	 */
	public int getLocationY() {
		return location.y;
	}
	
	/**
	 * Returns the x direction of the bot. 
	 */
	public int getTrajectoryX() {
		return trajectory.x;
	}
	
	/**
	 * Returns the y direction of the bot. 
	 */
	public int getTrajectoryY() {
		return trajectory.y;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Boolean getMoved() {
		return moved;
	}
	
	public void setMoved(Boolean moved) {
		this.moved = moved;
	}

	public Boolean getFired() {
		return fired;
	}

	public void setFired(Boolean fired) {
		this.fired = fired;
	}
	

}
