package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Point;
/**
 * Creates a new bot
 * 
 * @author Ben Weber 3-7-11
 */
public class AddBot extends BaseAction {

	/**
	 * Args:
	 *
	 */
	public void execute(Object[] args) {
		Bot b = new Bot();
		Point dimensions = GameEngine.getInstance().getDimensions();
		
		//TODO set location? - do we want this to be passed in? generated randomly?
		b.setLocation(new Point(dimensions.x/3, dimensions.y/3));
		
		GameEngine.getInstance().getBots().add(b);
	}
}
