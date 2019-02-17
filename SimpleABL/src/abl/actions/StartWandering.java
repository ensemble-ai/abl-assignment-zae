package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Point;
/**
 * Sets the trajectory of the chaser. 
 * 
 * @author Ben Weber 3-7-11
 */
public class StartWandering extends BaseAction {

	/**
	 * Picks new point for bot to wander to
	 * args[0] - bot id
	 */
	public void execute(Object[] args) {
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == (Integer)args[0]) {
				System.out.println("Bot " + b.getId() + " is starting to wander");
				
				Point dimensions = GameEngine.getInstance().getDimensions();
				Point target = new Point((int)(dimensions.x*Math.random()), (int)(dimensions.y*Math.random()));
				
				b.setWandering(true);
				b.setMoved(true);
				b.setWanderingTarget(target);
				return;
			}
		}
	}
}
