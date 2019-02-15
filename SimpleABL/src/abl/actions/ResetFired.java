
package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Color;
import java.awt.Point;
/**
 * Sets color of the chaser. 
 * @author Zee Chen 2-10-2019
 */
public class ResetFired extends BaseAction {

	/**
	 * Sets color of the bot.
	 * args[0] - boolean
	 */
	public void execute(Object[] args) {
		for(Bot b:GameEngine.getInstance().getBots()) {
			b.setFiredCheck(false);
		}
	}
}

