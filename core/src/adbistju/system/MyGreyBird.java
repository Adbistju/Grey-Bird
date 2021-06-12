package adbistju.system;

import com.badlogic.gdx.Game;

import adbistju.system.screen.MenuScreen;

public class MyGreyBird extends Game {
	@Override
	public void create() {
		setScreen(new MenuScreen(this));
	}
}
