package abl.actions;

import java.awt.Point;

import game.Bot;
import game.GameEngine;

public class ChangeTrust extends BaseAction {
	/**
	 * Fires a bullet at the target location.
	 * 
	 * Args:
	 *  - 0: bot id
	 *  - 1: amount to change trust
	 */
	public void execute(Object[] args) {
		int trust;
		int bot_ID = (Integer)args[0];
		Bot bot = null;
		
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == bot_ID) {
				bot = b;
			}
		}
		trust = bot.getTrust();
		trust += (Integer)args[1];
		if (trust < -100) {
			trust = -100;
		}
		if (trust > 100) {
			trust = 100;
		}
		System.out.println(trust);
		bot.setTrust(trust);
	}
}
