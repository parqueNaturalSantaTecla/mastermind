package mastermind.views.console;

import java.util.List;

import mastermind.controllers.Logic;
import mastermind.utils.WithConsoleView;
import mastermind.views.console.ErrorView;
import mastermind.views.MessageView;
import mastermind.types.Error;
import mastermind.types.Color;

class ProposalView extends WithConsoleView {

	private Logic logic;

	private SecretCombinationView secretCombinationView;

	private ProposedCombinationView proposedCombinationView;

	private ResultView resultView;

	ProposalView(Logic logic) {
		this.logic = logic;
		this.secretCombinationView = new SecretCombinationView(this.logic);
		this.proposedCombinationView = new ProposedCombinationView(this.logic);
		this.resultView = new ResultView(this.logic);
	}

	boolean interact() {
		Error error;
		do {
			List<Color> colors = this.proposedCombinationView.read();
			error = this.logic.addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
		this.console.writeln();
		new AttemptsView(this.logic).writeln();
		this.secretCombinationView.writeln();
		for (int i = 0; i < this.logic.getAttempts(); i++) {
			this.proposedCombinationView.write(i);
			this.resultView.writeln(i);
		}
		if (this.logic.isWinner()) {
			this.console.writeln(MessageView.WINNER.getMessage());
			return true;
		} else if (this.logic.isLooser()) {
			this.console.writeln(MessageView.LOOSER.getMessage());
			return true;
		}
		return false;
	}

}
