package abl.wmes;

import java.awt.Color;
import java.awt.Point;

import game.Bot;
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
	
	/** possible trajectory of the bot */
	private int potentialX;
	private int potentialY;
	
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

	private Boolean wandering;

	private Point wanderingTarget;
	
	/**
	 * Instantiates a working memory element for tracking a bot.
	 */
	public BotWME(Point location, Point trajectory, int id, 
				  Color color, int formPos, int trust, Boolean moved, 
				  Boolean hasFired, Boolean trustUpdated, Boolean shot, 
				  Boolean wandering, Point wanderingTarget) {
		this.location = location;
		this.trajectory = trajectory;
		this.id = id;
		this.color = color;
		this.formPos = formPos;
		this.trust = trust;
		this.hasFired = hasFired;
		this.moved = moved;
		this.potentialX = 0;
		this.potentialY = 0;
		this.shot = shot;
		this.trustUpdated = trustUpdated;
		this.wandering = wandering;
		this.wanderingTarget = wanderingTarget;
	}

	public boolean check() {
		return true;
	}

	public boolean setPotentialTrajectory(int dirx, int diry) {
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == id) {
				b.setPotentialTrajectory(new Point(dirx, diry));
				return true;
			}
		}
		
		System.out.println("HELP! I can't find that bot!");
		return false;
	}
		
	public boolean calcPotentialTrajectory(int targetX, int targetY) {
		final double sqrt2 = 1.41421356237;
		int dirx = 0;
		int diry = 0;
		int x = (int)location.getX();
		int y = (int)location.getY();
		
		int speed = GameEngine.BotSpeed;
		
		//System.out.println("Calculating trajectory!");
		
		if(x - targetX >= speed) {	
			dirx = -speed;
		}else if(x - targetX <= -speed) {
			dirx = speed;			
		}
		if(y - targetY  >= speed) {	
			diry = -speed;
		}else if(y - targetY <= -speed) {
			diry = speed;			
		}

		
		if(dirx != 0 && diry != 0) { 
			//TODO: check, how do ints get truncated when negative?
			dirx = (int)((double)dirx * sqrt2); 
			diry = (int)((double)diry * sqrt2); 
		}//bot is heading diagonal, so mod the speed
	
		potentialX = dirx;
		potentialY = diry;
		return setPotentialTrajectory(dirx, diry);
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
	 * @return the potentialX
	 */
	public int getPotentialX() {
		return potentialX;
	}

	/**
	 * @param potentialX the potentialX to set
	 */
	public void setPotentialX(int potentialX) {
		this.potentialX = potentialX;
	}

	/**
	 * @return the potentialY
	 */
	public int getPotentialY() {
		return potentialY;
	}

	/**
	 * @param potentialY the potentialY to set
	 */
	public void setPotentialY(int potentialY) {
		this.potentialY = potentialY;
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

	/**
	 * @return the wandering
	 */
	public Boolean getWandering() {
		return wandering;
	}

	/**
	 * @param wandering the wandering to set
	 */
	public void setWandering(Boolean wandering) {
		this.wandering = wandering;
	}

	public int getWanderingX() {
		if(wanderingTarget != null) {
			return wanderingTarget.x;
		}
		return 0;
	}

	public int getWanderingY() {
		if(wanderingTarget != null) {
			return wanderingTarget.y;
		}
		return 0;
	}
}
