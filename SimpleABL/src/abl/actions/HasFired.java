package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Color;
import java.awt.Point;
/**
 * Sets color of the chaser. 
 */
public class HasFired extends BaseAction {

	/**
	 * Sets color of the bot.
	 * args[0] - bot id
	 * args[1] - boolean
	 */
	public void execute(Object[] args) {
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == (Integer)args[0]) {
				b.setFiredCheck((Boolean)args[1]);
			}
		}
	}
}
