package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Point;
/**
 * Reset variables that keep track of which bots have moved 
 * 
 * @author Ben Weber 3-7-11
 */
public class ResetOtherTrajectories extends BaseAction {

	/**
	 * Args:
	 *  - 0 : int id
	 *
	 */
	public void execute(Object[] args) {
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() != (Integer)args[0]) {
				b.setTrajectory(new Point(0,0));
			}
		}
	}
}
