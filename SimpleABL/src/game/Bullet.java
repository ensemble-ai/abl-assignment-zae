package game;

import java.awt.Point;

import game.GameEngine.bulletorigin;
/**
 * Records the location and trajectory of a bullet.
 * 
 * @author Ben Weber 3-7-11
 */
public class Bullet {

	/** position of the bullet */
	double x;
	double y;

	/** trajectory of the bullet */
	double dx;
	double dy;
	
	/** is the bullet motionless? */
	boolean idle = false;

	/** bullet speed */
	public static final double BulletSpeed = 10.0;
	
	// who's the bullet from? 
	public bulletorigin origin;
	
	/**
	 * Creates a bullet that will move towards the target location. 
	 */
	public Bullet(Point source, Point target, bulletorigin origin) {
		x = source.x;
		y = source.y;
		this.origin = origin;
		
		dx = target.x - source.x;
		dy = target.y - source.y;
		double magnitude = Math.sqrt(dx*dx + dy*dy);
		
		if (magnitude > 0) {
			dx = BulletSpeed*dx/magnitude;
			dy = BulletSpeed*dy/magnitude;
		}
		else {
			idle = true;
		}
	}

	/**
	 * Updates the position of the bullet;
	 */
	public void update() {
		x += dx;
		y += dy;
	}
	
	/**
	 * Is the bullet motionless?
	 */
	public boolean isIdle() {
		return idle;
	}
	
	/**
	 * Returns the x location of the bullet (in pixels).
	 */
	public int getX() {
		return (int)x;
	}
	
	/**
	 * Returns the y location of the bullet (in pixels).
	 */
	public int getY() {
		return (int)y;
	}
	
	public int getdX() {
		return (int)dx;
	}
	
	public int getdY() {
		return (int)dy;
	}
}
