package mastermind.views;

import mastermind.models.Game;
import mastermind.views.MessageView;

class AttemptsView {

	private Game game;

	AttemptsView(Game game) {
		this.game = game;
	}

	void writeln() {
		MessageView.ATTEMPTS.writeln(this.game.getAttempts());
	}

}
