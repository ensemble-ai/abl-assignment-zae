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
public class SetTrajectory extends BaseAction {

	/**
	 * Sets the trajectory to move to given location.
	 * 
	 * 	Args:
	 *  - 0: int: id of bot
	 *  - 1: int: playerX
	 *  - 2: int: playerY 
	 *  - 3: boolean: is there a collision
	 */
	public void execute(Object[] args) {
		
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == (Integer)args[0]) {
				if((Boolean)args[3]) {
					b.setTrajectory(new Point(0,0));
				}else {
					b.setTrajectory(calcTrajectory(b.getX(), b.getY(), (Integer)args[1],(Integer)args[2]));
				}
				
				b.setMoved(true);
				return;
			}
		}
	}
	
	public Point calcTrajectory(int x, int y, int targetX, int targetY) { 
		final double sqrt2 = 1.41421356237;
		int dirx = 0;
		int diry = 0;
		int speed = GameEngine.BotSpeed;
		
		if(x - targetX > speed) {	
			dirx = -speed;
		}else if(x - targetX < -speed) {
			dirx = speed;			
		}
		if(y - targetY  > speed) {	
			diry = -speed;
		}else if(y - targetY < -speed) {
			diry = speed;			
		}
		
		if(dirx != 0 && diry != 0) { 
			//TODO: check, how do ints get truncated when negative?
			dirx = (int)((double)dirx * sqrt2); 
			diry = (int)((double)diry * sqrt2); 
		}//bot is heading diagonal, so mod the speed
		
		return new Point(dirx, diry);
	}
	
}