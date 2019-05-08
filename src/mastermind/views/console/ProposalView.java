package mastermind.views.console;

import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

class ProposalView extends WithConsoleView {

	private Game game;

	private SecretCombinationView secretCombinationView;

	private AttemptsView attemptsView;

	ProposalView(Game game) {
		this.game = game;
		this.secretCombinationView = new SecretCombinationView();
		this.attemptsView = new AttemptsView(this.game);
	}

	boolean interact() {
		ProposedCombination proposedCombination = new ProposedCombination();
		ProposedCombinationView proposedCombinationView = new ProposedCombinationView(proposedCombination);
		proposedCombinationView.read();
		this.game.addProposedCombination(proposedCombination);
		this.console.writeln();
		this.attemptsView.writeln();
		this.secretCombinationView.writeln();
		for (int i = 0; i < this.game.getAttempts(); i++) {
			new ProposedCombinationView(this.game.getProposedCombination(i)).write();
			new ResultView(this.game.getResult(i)).writeln();
		}
		if (this.game.isWinner()) {
			this.console.writeln(MessageView.WINNER.getMessage());
			return true;
		} else if (this.game.isLooser()) {
			this.console.writeln(MessageView.LOOSER.getMessage());
			return true;
		}
		return false;
	}

}
