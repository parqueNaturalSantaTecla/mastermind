package mastermind.views;

import mastermind.controllers.GameController;
import mastermind.views.MessageView;

class AttemptsView {

	private GameController gameController;

	AttemptsView(GameController gameController) {
		this.gameController = gameController;
	}

	void writeln() {
		MessageView.ATTEMPTS.writeln(this.gameController.getAttempts());
	}

}
