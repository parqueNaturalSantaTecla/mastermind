package mastermind.views.console;

import mastermind.controllers.ProposalController;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {

	private ProposalController proposalController;

	ResultView(ProposalController proposalController) {
		this.proposalController = proposalController;
	}

	void writeln(int position) {
		this.console.writeln(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.proposalController.getBlacks(position))
						.replaceFirst("#whites", "" + this.proposalController.getWhites(position)));
	}

}
