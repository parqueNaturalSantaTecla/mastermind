package mastermind.views;

import mastermind.controllers.PlayController;

class AttemptsView {

	private PlayController playController;

	AttemptsView(PlayController proposalController) {
		this.playController = proposalController;
	}

	void writeln() {
		MessageView.ATTEMPTS.writeln(this.playController.getAttempts());
	}

}
