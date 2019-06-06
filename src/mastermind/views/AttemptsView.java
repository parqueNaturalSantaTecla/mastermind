package mastermind.views;

import mastermind.controllers.PlayController;
import santaTecla.utils.WithConsoleView;

class AttemptsView extends WithConsoleView {

	private PlayController playController;

	AttemptsView(PlayController proposalController) {
		this.playController = proposalController;
	}

	void writeln() {
		MessageView.ATTEMPTS.writeln(this.playController.getAttempts());
	}

}
