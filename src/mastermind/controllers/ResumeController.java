package mastermind.controllers;

import mastermind.models.Game;

public class ResumeController extends Controller {

	public ResumeController(Game game) {
		super(game);
	}

	public void resume(boolean newGame) {
		if (newGame) {
			this.game.clear();
		}
	}

}
