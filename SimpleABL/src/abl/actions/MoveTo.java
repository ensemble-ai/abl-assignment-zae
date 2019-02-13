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
				
				/*
				//check for player
				if(dist > calcDistance((Integer)args[0], (Integer)args[1], (int)point.getX(), (int)point.getY())) {
					//move away from player instead of towards
					dirx = -dirx;
					diry = -diry;
				}
				*/
				
				b.setTrajectory(new Point(dirx, diry));
				
				/*
				 * if(checkForCollisions(dist, b)) {
					//System.out.println("Collision!");
					b.setTrajectory(new Point(0, 0));
				}
				*/ 
				b.setMoved(true);
				return;
			}
		}
	}

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
	
	
	public int calcDistance(int playerX, int playerY, int botX, int botY) {
		int diffX, diffY;
		
		diffX = playerX - botX;
		diffY = playerY - botY;
	
		diffX = diffX*diffX;
		diffY = diffY*diffY;
	
		return (int)Math.sqrt(diffX + diffY); 
	}
	
}