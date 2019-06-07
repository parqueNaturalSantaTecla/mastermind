package mastermind.views;

import mastermind.controllers.GameController;
import mastermind.views.menus.MessageView;
import santaTecla.utils.WithConsoleView;

class AttemptsView extends WithConsoleView {

	private GameController gameController;

	AttemptsView(GameController gameController) {
		this.gameController = gameController;
	}

	void writeln() {
		this.console.writeln(
				MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts", "" + this.gameController.getAttempts()));
	}

}
