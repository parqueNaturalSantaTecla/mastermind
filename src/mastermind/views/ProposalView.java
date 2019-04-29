package mastermind.views;

import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import mastermind.utils.WithConsoleView;

class ProposalView extends WithConsoleView {

	boolean interact(Game game) {
		ProposedCombinationView proposedCombinationView = new ProposedCombinationView(new ProposedCombination());
		game.addProposedCombination(proposedCombinationView.read());
		this.console.writeln();
		MessageView.TURN.writeln(game.getAttempts());
		new SecretCombinationView().writeln();
		for (int i = 0; i < game.getAttempts(); i++) {
			new ProposedCombinationView(game.getProposedCombination(i)).write();
			new ResultView(game.getResult(i)).writeln();
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
