package abl.actions;

import game.GameEngine;

/**
 * Adds a bot to the game engine
 */
public class AddBot extends BaseAction {

	/**
	 * Add bots.
	 * args[0] - 
	 */
	public void execute(Object[] args) {
		GameEngine.getInstance().addBots();
	}
}
