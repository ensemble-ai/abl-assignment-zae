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
	
	/** Has the bot moved this round? */
	private boolean moved;
	
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

	public int getTrust() {
		return trust;
	}
	
	public void setTrust(int newtrust) {
		this.trust = newtrust;
		getNewColor(newtrust);
	}
	
	public Color getNewColor(int trustvalue) {
		if(trustvalue > 0) {
			// trust
			int degree = (100 - trustvalue)/100;
			int red = 0 + basecolor.getRed()*degree;
			int green = 255 - basecolor.getGreen()*degree;
			int blue = 0 + basecolor.getBlue()*degree;
			this.setColor(new Color(red, green, blue));
		} else if (trustvalue < 0) {
			//distrust
			int degree = (100 - (trustvalue*-1))/100;
			int red = 255 - basecolor.getRed()*degree;
			int green = 0 + basecolor.getGreen()*degree;
			int blue = 0 + basecolor.getBlue()*degree;
			this.setColor(new Color(red, green, blue));
			
		} else {
			this.setColor(basecolor);
		}
		return new Color(50,50,50);
	}
	
}
