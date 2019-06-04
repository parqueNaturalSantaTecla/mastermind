package mastermind.views;

import mastermind.controllers.PlayController;
import mastermind.utils.WithConsoleView;

class AttemptsView extends WithConsoleView {

	private PlayController playController;

	AttemptsView(PlayController playController) {
		this.playController = playController;
	}

	void writeln() {
		this.console.writeln(
				MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts", "" + this.playController.getAttempts()));
	}

}
