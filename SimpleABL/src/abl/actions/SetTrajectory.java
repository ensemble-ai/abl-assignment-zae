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
	 *  - 0: id of bot
	 *  - 1: trajectory 
	 */
	public void execute(Object[] args) {
		
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == (Integer)args[0]) {
				
				b.setTrajectory((Point)args[1]);
				
				b.setMoved(true);
				return;
			}
		}
	}

	
	
}