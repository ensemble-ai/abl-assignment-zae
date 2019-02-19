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
	 *  - 2: Trust threshold that is needed to activate
	 */
	public void execute(Object[] args) {
		int bot_ID = (Integer)args[0];
		for(Bot b:GameEngine.getInstance().getBots()) {

			if(b.getId() == bot_ID) {
				changeTrust(b, (Integer)args[1]);
				b.setTrustUpdated(true);
			}
		}

	}
	public void changeTrust(Bot bot, int trust_mod) {
		int trust;
		trust = bot.getTrust();
		trust += trust_mod;
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
