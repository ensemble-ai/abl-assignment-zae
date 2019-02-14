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
	 *  - 3: distance to maintain
	 */
	public void execute(Object[] args) {
		final double sqrt2 = 1.41421356237;
		
		int dirx = 0;
		int diry = 0;
		int speed = GameEngine.BotSpeed;
		int dist = (Integer)args[3];
		
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
		
				if(dirx != 0 && diry != 0) { 
					//TODO: check, how do ints get truncated when negative?
					dirx = (int)((double)dirx * sqrt2); 
					diry = (int)((double)diry * sqrt2); 
				}//bot is heading diagonal, so mod the speed
				
				b.setTrajectory(new Point(dirx, diry));
				
				b.setMoved(true);
				return;
			}
		}
	}

	/*
	private boolean checkForCollisions(int dist, Bot movingBot) {
		//check for collisions
		Point oldLocation = movingBot.getLocation();
		Point trajectory = movingBot.getTrajectory();
		int newX = (int)oldLocation.getX();
		int newY = (int)oldLocation.getY();
		
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() != movingBot.getId()) {
				if( dist > calcDistance(newX, newY, b.getX(), b.getY())) {
					b.setTrajectory(new Point(0, 0));
					return true;
				}//moving the bot would make it too close to another bot, so freeze instead
			}
		}	
		return false;
	}
	*/
	
	
}