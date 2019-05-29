package mastermind.views.console;

import mastermind.controllers.Logic;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

class AttemptsView extends WithConsoleView {

	private Logic logic;

	AttemptsView(Logic logic) {
		this.logic = logic;
	}

	void writeln() {
		this.console
				.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts", "" + this.logic.getAttempts()));
	}

}
