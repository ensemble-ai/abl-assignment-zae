package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Point;
/**
 */
public class Fire extends BaseAction {

	/**
	 * Fires a bullet at the target location.
	 * 
	 * Args:
	 *  - 0: target x position
	 *  - 1: target y position
	 *  - 2: id
	 */
	public void execute(Object[] args) {
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == (Integer)args[2]) {
				//if (b.getTrust() < -50) {
					GameEngine.getInstance().fireBullet(
							new Point((int)(b.getLocation().getX()), (int)(b.getLocation().getY())), 
							new Point((Integer)args[0], (Integer)args[1]));					
				//}
				b.setFiredCheck(true);
			}
		}
	}
}
