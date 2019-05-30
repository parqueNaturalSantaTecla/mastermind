package mastermind.views.console;

import mastermind.models.Game;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

class AttemptsView extends WithConsoleView {

	private Game game;

	AttemptsView(Game game) {
		this.game = game;
	}

	void writeln() {
		this.console.writeln(MessageView.ATTEMPTS.getMessage().replace("#attempts", "" + this.game.getAttempts()));
	}
}
