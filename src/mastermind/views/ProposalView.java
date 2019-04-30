package mastermind.views;

import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import mastermind.utils.WithConsoleView;

class ProposalView extends WithConsoleView {

	boolean interact(Game game) {
		ProposedCombination proposedCombination = new ProposedCombination();
		ProposedCombinationView proposedCombinationView = new ProposedCombinationView();
		proposedCombinationView.read(proposedCombination);
		game.addProposedCombination(proposedCombination);
		this.console.writeln();
		MessageView.TURN.writeln(game.getAttempts());
		new SecretCombinationView().writeln();
		for (int i = 0; i < game.getAttempts(); i++) {
			new ProposedCombinationView().write(game.getProposedCombination(i));
			new ResultView().writeln(game.getResult(i));
		}
		if (game.isWinner()) {
			MessageView.WINNER.writeln();
			return true;
		} else if (game.isLooser()) {
			MessageView.LOOSER.writeln();
			return true;
		}
		return false;
	}

}
