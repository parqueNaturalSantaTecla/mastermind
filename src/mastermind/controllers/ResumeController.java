package mastermind.controllers;

import mastermind.models.Game;

public class ResumeController extends Controller {

	public ResumeController(Game game) {
		super(game);
	}

	public void resume(boolean resume) {
		if (resume) {
			this.game.clear();
		}
	}

}
