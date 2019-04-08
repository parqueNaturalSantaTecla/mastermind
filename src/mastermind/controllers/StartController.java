package mastermind.controllers;

import mastermind.models.Game;

public class StartController extends Controller {

	public StartController(Game game) {
		super(game);
	}

	int getWidth() {
		return this.game.getWidth();
	}

}
