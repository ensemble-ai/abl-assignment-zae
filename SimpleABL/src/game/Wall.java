package game;

import java.awt.Point;
/**
 * Walls (or other obstacles) to be placed on the map
 * 
 * @author Ben Weber 3-7-11
 */
public class Wall {

	/** Location of the wall */
	private Point location;
	private int height;
	private int width;
	
	/** Creates a wall */
	public Wall(Point location, int width, int height) {
		this.location = location;
		this.width = width;
		this.height = height;
	}

	public Point getLocation() {
		return location;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	public int getX() {
		return this.location.x;
	}
	
	public int getY() {
		return this.location.y;
	}
}
