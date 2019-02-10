package game.input;

import abl.actions.*;
import java.awt.event.KeyEvent;
import game.GameEngine;

public class Spawn implements IInput {
	
	public int triggerKeyCode = KeyEvent.VK_N;
	
	public Spawn() {
	}

	@Override
	public void process(GameEngine gameEngine, int keyCode) {
		Object object[] = null;
		
		if(keyCode == this.triggerKeyCode) {
			(new AddBot()).execute(object);
		}
	}
}
