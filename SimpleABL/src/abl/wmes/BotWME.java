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
	
	private int formPos;
	
	private int trust;
	
	private Boolean hasFired;

	/** Has this bot moved this round? */
	private Boolean moved;

	//private Boolean shouldTrustChange;
	
	private Boolean trustUpdated;
	
	private Boolean shot;
	
	
	/**
	 * Instantiates a working memory element for tracking a bot.
	 */

	public BotWME(Point location, Point trajectory, int id, 
				  Color color, int formPos, int trust, Boolean moved, 
				  Boolean hasFired, Boolean trustUpdated, Boolean shot) {
		this.location = location;
		this.trajectory = trajectory;
		this.id = id;
		this.color = color;
		this.formPos = formPos;
		this.trust = trust;
		this.hasFired = hasFired;
		this.moved = moved;
		this.shot = shot;
		this.trustUpdated = trustUpdated;
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

	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getFormPos() {
		return formPos;
	}
	
	public void setFormPos(int formPos) {
		this.formPos = formPos;
	}
	
	public int getTrust() {
		return this.trust;
	}
	public void setTrust(int trust) {
		this.trust = trust;
	}
	public Boolean getHasFired() {
		return hasFired;
	}

	public void setHasFired(Boolean hasFired) {
		this.hasFired = hasFired;
	}

	public Boolean getMoved() {
		return moved;
	}
	
	public void setMoved(Boolean moved) {
		this.moved = moved;
	}

	/**
	 * @return the trustUpdated
	 */
	public Boolean getTrustUpdated() {
		return trustUpdated;
	}

	/**
	 * @param trustUpdated the trustUpdated to set
	 */
	public void setTrustUpdated(Boolean trustUpdated) {
		this.trustUpdated = trustUpdated;
	}

	/**
	 * @return the shot
	 */
	public Boolean getShot() {
		return shot;
	}

	/**
	 * @param shot the shot to set
	 */
	public void setShot(Boolean shot) {
		this.shot = shot;
	}
	



}
