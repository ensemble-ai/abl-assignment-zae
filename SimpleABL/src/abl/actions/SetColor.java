package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Color;
import java.awt.Point;
/**
 * Sets color of the chaser. 
 * @author Zee Chen 2-10-2019
 */
public class SetColor extends BaseAction {

	/**
	 * Sets color of the bot.
	 * args[0] - int red
	 * args[1] - int blue
	 * args[2] - int green
	 * args[3] - int id
	 */
	public void execute(Object[] args) {
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == (Integer)args[3]) {
				b.setColor(new Color((Integer)args[0], (Integer)args[1], (Integer)args[2]));
			}
		}
	}
}
