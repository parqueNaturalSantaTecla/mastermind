package mastermind.controllers;

import mastermind.models.Combination;
import mastermind.models.Game;

public abstract class Controller {

	protected Game game;

	Controller(Game game) {
		this.game = game;
	}

	public int getWidth() {
		return Combination.getWidth();
	}

}
