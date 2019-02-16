package game;

import java.awt.Color;
import java.awt.Point;

public class Bot {
	
	public static final int Size = 10;
	
	static int IdCount = 0;
	
	/** Location of the bot */
	private Point location;
	
	/** Trajectory of the bot */
	private Point trajectory;
	
	/** Indicates whether this bot has been shot */
	private boolean shot;
	
	/** Has the bot moved this round? */
	private boolean moved;
	
	/** Has the bot updated its trust level this round? */
	private boolean trustUpdated;
	
	/** unique bot ID */
	private int id;

	private Color color;
	
	private Color basecolor = new Color(255,165,0);
	
	private int size = Size;

	private int formPos;
	
	private Boolean hasFired;
	
	private int trust; 
	
	public Bot() {
		this.location = new Point(0,0);
		this.trajectory = new Point(0,0);
		this.id = IdCount++;
		this.basecolor = new Color(255,165,0);
		this.color = new Color(255,165,0);
		this.hasFired = false;
		this.trustUpdated = false;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public Point getTrajectory() {
		return trajectory;
	}

	public void setTrajectory(Point trajectory) {
		this.trajectory = trajectory;
	}


	public int getX( ) {
		return this.location.x;
	}
	
	public int getY( ) {
		return this.location.y;
	}
	
	public int getId() {
		return id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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

	public Boolean firedCheck() {
		return hasFired;
	}
	
	public void setFiredCheck(Boolean hasFired) {
		this.hasFired = hasFired;
	}

	public Boolean isMoved() {
		return moved;
	}
	
	public void setMoved(Boolean moved) {
		this.moved = moved;
	}
	
	/*
	 * public Boolean shouldTrustChange() {
		return shouldTrustChange;
	}
	public void setTrustChange(Boolean shouldTrustChange) {
		this.shouldTrustChange = shouldTrustChange;
	}
	*/

	public int getTrust() {
		return trust;
	}
	
	public void setTrust(int newtrust) {
		this.trust = newtrust;
		setNewColor(newtrust);
	}
	
	public void setNewColor(int trustvalue) {
		int basered = basecolor.getRed();
		int basegreen = basecolor.getGreen();
		int baseblue = basecolor.getBlue();
		if(trustvalue > 0) {
			// trust
			float degree = 1- (float)(100 - trustvalue)/100;
			int red =  Math.round((0 - basered)*degree + basered);
			int green = Math.round((255 - basegreen)*degree + basegreen);
			int blue = Math.round((0 - baseblue)*degree + baseblue);
			this.setColor(new Color(red, green, blue));
		} else if (trustvalue < 0) {
			//distrust
			float degree = 1- (float)(100 + trustvalue)/100;
			int red =  Math.round((255 - basered)*degree + basered);
			int green = Math.round((0 - basegreen)*degree + basegreen);
			int blue = Math.round((0 - baseblue)*degree + baseblue);
			this.setColor(new Color(red, green, blue));
		} else {
			this.setColor(basecolor);
		}
	}

	/**
	 * @return the shouldTrustChange
	 */
	/*public boolean isShouldTrustChange() {
		return shouldTrustChange;
	}
*/
	/**
	 * @param shouldTrustChange the shouldTrustChange to set
	 */
	/*public void setShouldTrustChange(boolean shouldTrustChange) {
		this.shouldTrustChange = shouldTrustChange;
	}
	*/
	

	/**
	 * @return the shot
	 */
	public boolean isShot() {
		return shot;
	}

	/**
	 * @param shot the shot to set
	 */
	public void setShot(boolean shot) {
		this.shot = shot;
	}

	/**
	 * @return the trustUpdated
	 */
	public boolean isTrustUpdated() {
		return trustUpdated;
	}

	/**
	 * @param trustUpdated the trustUpdated to set
	 */
	public void setTrustUpdated(boolean trustUpdated) {
		this.trustUpdated = trustUpdated;
	}

	
}
