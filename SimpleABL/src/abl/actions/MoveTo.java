package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Point;
import java.util.ArrayList;

import abl.runtime.BehavingEntity;
/**
 * Sets the trajectory of the chaser. 
 * 
 */
public class MoveTo extends BaseAction {

	/**
	 * Sets the trajectory to move to given location.
	 * 
	 * 	Args:
	 *  - 0: target x position
	 *  - 1: target y position
	 *  - 2: id of bot
	 */
	public void execute(Object[] args) {
		int dirx = 0;
		int diry = 0;
		int speed = GameEngine.BotSpeed;
		
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == (Integer)args[2]) {
				Point point = b.getLocation();
				
				if(point.getX() - (Integer)args[0] > speed) {	
					dirx = -speed;
				}else if(point.getX() - (Integer) args[0] < -speed) {
					dirx = speed;			
				}
				if(point.getY() - (Integer)args[1] > speed) {	
					diry = -speed;
				}else if(point.getY() - (Integer)args[1] < -speed) {
					diry = speed;			
				}
				b.setTrajectory(new Point(dirx, diry));
				b.setMoved(true);
			}
		}
	}
}
