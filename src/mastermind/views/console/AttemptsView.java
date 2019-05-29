package mastermind.views.console;

import mastermind.controllers.ProposalController;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

public class AttemptsView extends WithConsoleView {

	private ProposalController proposalController;

	AttemptsView(ProposalController proposalController) {
		this.proposalController = proposalController;
	}

	void writeln() {
		this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts",
				"" + this.proposalController.getAttempts()));
	}
}
