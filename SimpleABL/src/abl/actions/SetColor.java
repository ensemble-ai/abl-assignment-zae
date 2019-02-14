package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Color;
import java.awt.Point;
/**
 * Sets Color of the bot with the given ID 
 * 
 */
public class SetColor extends BaseAction {
	/**
	 * Args:
	 *  - 0: r 
	 *  - 1: g
	 *  - 2: b
	 *  - 3: id
	 */
	public void execute(Object[] args) {
		for(Bot b:GameEngine.getInstance().getBots()) {	
			if(b.getId() == (Integer)args[3]) {
				b.setColor(new Color((Integer)args[0], (Integer)args[1], (Integer)args[2]));
			}
		}
	}
}
