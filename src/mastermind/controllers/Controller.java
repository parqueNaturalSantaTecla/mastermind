package mastermind.controllers;

import mastermind.models.Combination;
import mastermind.models.Game;

public abstract class Controller {
	
	public static final int NO_ERROR = -1;

	protected Game game;

	Controller(Game game) {
		this.game = game;
	}

	public static int getWidth() {
		return Combination.getWidth();
	}

}
