package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Point;
import java.util.ArrayList;

import abl.runtime.BehavingEntity;
/**
 * Checks for incoming collisions and 
 * updates the trajectory of the bot if needed
 * 
 */
public class MoveAway extends BaseAction {

	/**
	 * 	Args:
	 *  - 0: playerX
	 *  - 1: playerY
	 *  - 2: id of bot
	 *  - 3: distance to maintain
	 */
	public void execute(Object[] args) {
		int dist = (Integer)args[3];
		Bot movingBot = null;
		
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == (Integer)args[2]) {
				movingBot = b;		
				break;
			}
		}//find bot we are moving	
		if(movingBot == null) { return; }
		
		Point oldLocation = movingBot.getLocation();
		Point trajectory = movingBot.getTrajectory();
		int newX = (int)oldLocation.getX();
		int newY = (int)oldLocation.getY();
		
		//check for player
		if(dist > calcDistance((Integer)args[0], (Integer)args[1], newX, newY)) {
			movingBot.setTrajectory(new Point(0, 0));
		}
	
		/*
		//check for collisions with bots
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() != (Integer)args[2]) {
				if( dist < calcDistance(newX, newY, b.getX(), b.getY())) {
					movingBot.setTrajectory(new Point(0, 0));
					return;
				}//moving the bot would make it too close to another bot, so freeze instead
			}
		}
		*/
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