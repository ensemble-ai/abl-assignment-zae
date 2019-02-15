package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Point;
import java.util.Random;
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
		Random rn = new Random();
		int x = rn.nextInt(201) - 100;	// random number [-100,100]
		Point dimensions = GameEngine.getInstance().getDimensions();
		
		//TODO set location? - do we want this to be passed in? generated randomly?
		b.setLocation(new Point(dimensions.x/3, dimensions.y/3));
		b.setTrust(x);
		System.out.println(b.getTrust());
		GameEngine.getInstance().getBots().add(b);
	}
}
