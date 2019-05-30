package mastermind.views;

import mastermind.models.Game;
import mastermind.utils.WithConsoleView;

class AttemptsView extends WithConsoleView {

	private Game game;

	AttemptsView(Game game) {
		this.game = game;
	}

	void writeln() {
		this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts", "" + this.game.getAttempts()));
	}

}
