package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Point;
/**
 * Reset variables that keep track of which bots have moved 
 * 
 * @author Ben Weber 3-7-11
 */
public class ResetMoves extends BaseAction {

	/**
	 * Args:
	 *
	 */
	public void execute(Object[] args) {
		for(Bot b:GameEngine.getInstance().getBots()) {
			b.setMoved(false);
			b.setTrustChange(true);
		}
	}
}
