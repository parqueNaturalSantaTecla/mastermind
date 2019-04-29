package mastermind.views.console;

import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

class ProposalView extends WithConsoleView {

	boolean interact(Game game) {
		ProposedCombinationView proposedCombinationView = new ProposedCombinationView(new ProposedCombination());
		game.addProposedCombination(proposedCombinationView.read());
		this.console.writeln();
		this.console.writeln(MessageView.TURN.getMessage().replace("#attempts", ""+game.getAttempts()));
		new SecretCombinationView().writeln();
		for (int i = 0; i < game.getAttempts(); i++) {
			new ProposedCombinationView(game.getProposedCombination(i)).write();
			new ResultView(game.getResult(i)).writeln();
		}
		if (game.isWinner()) {
			this.console.writeln(MessageView.WINNER.getMessage());
			return true;
		} else if (game.isLooser()) {
			this.console.writeln(MessageView.LOOSER.getMessage());
			return true;
		}
		return false;
	}

}
