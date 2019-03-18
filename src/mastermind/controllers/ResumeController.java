package mastermind.controllers;

import mastermind.models.Game;

class ResumeController extends Controller {

	ResumeController(Game game) {
		super(game);
	}

	void resume(boolean resume) {
		if (resume) {
			this.game.clear();
		}
	}

}
