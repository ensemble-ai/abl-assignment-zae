package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Point;
/**
 * Sets the trajectory of the chaser. 
 * @author Zee Chen 2-10-2019
 */
public class MoveTo extends BaseAction {

	/**
	 * Sets the trajectory of the bot to move to a location.
	 * args[0] - target x direction
	 * args[1] - target y direction
	 * args[2] - id
	 */
	public void execute(Object[] args) {
		int x = 0, y = 0;
		int botSpeed = GameEngine.BotSpeed;
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == (Integer)args[2]) {
				Point target = b.getLocation();
				if(target.getX() - (Integer)args[0] > botSpeed) {
					x = -botSpeed;
				} else if (target.getX() - (Integer)args[0] < -botSpeed){
					x = botSpeed;
				}
				
				if(target.getY() - (Integer)args[1] > botSpeed) {
					y = -botSpeed;
				} else if(target.getY() - (Integer)args[1] < -botSpeed) {
					y = botSpeed;
				}
				
				b.setTrajectory(new Point(x,y));
			}
		}
	}
}
