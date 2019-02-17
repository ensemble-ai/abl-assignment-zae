package abl.actions;

import game.GameEngine;

/**
 * Adds a bot to the game engine
 */
public class AddBotInt extends BaseAction {

	/**
	 * Add bots.
	 * args[0] - count of bots
	 * args[1] - max number of bots produced
	 */
	public void execute(Object[] args) {
		int modArg = (Integer)args[0] % (Integer)args[1];
		GameEngine.getInstance().addBots(modArg);
	}
}