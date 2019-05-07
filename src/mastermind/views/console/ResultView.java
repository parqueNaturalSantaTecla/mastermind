package mastermind.views.console;

import mastermind.controllers.ProposalController;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

class ResultView extends WithConsoleView {

	private ProposalController proposalController;

	ResultView(ProposalController proposalController) {
		this.proposalController = proposalController;
	}

	void writeln(int i) {
		this.console.writeln(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.proposalController.getBlacks(i))
						.replaceFirst("#whites", "" + this.proposalController.getWhites(i)));
	}

}
