package abl.sensors;

import game.Bot;
import game.GameEngine;
import abl.runtime.BehavingEntity;
import abl.wmes.BlackBoardWME;
import abl.wmes.BotWME;

import java.util.Map;
import java.util.Hashtable;

/**
 * Adds a BlackBoardWME object to working memory when sense is invoked.
 * 
 */
public class BlackBoardSensor extends SerialSensor {

	/**
	 * Adds a BlackBoardWME to working memory and deletes the old BlackBoard WME in memory 
	 */
	public void sense() {
 
		BehavingEntity.getBehavingEntity().deleteAllWMEClass("BlackBoardWME");

		Map bots = new Hashtable();
		
		for(Bot b : GameEngine.getInstance().getBots()) {
			bots.put(b.getId(), b.getLocation());
		}//store location of all bots
		
		
		BehavingEntity.getBehavingEntity().addWME(
				new BlackBoardWME(bots, GameEngine.getInstance().getPlayerLocation()));
		
		
	}
}
