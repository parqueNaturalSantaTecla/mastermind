package mastermind.views;

import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import mastermind.utils.WithConsoleView;

class ProposalView extends WithConsoleView {

	boolean interact(Game game) {
		int error;
		do {
			int[] codes = new ProposedCombinationView().read();
			error = this.proposeCombination(codes, game);
			if (error != Game.NO_ERROR) {
				new ErrorView(error).write();
			}
		} while (error != Game.NO_ERROR);
		this.console.writeln();
		this.console.writeln(MessageView.TURN.getMessage().replaceFirst("#turn", "" + game.getTurn()));
		new SecretCombinationView().writeln(game.getWidth());
		int[][][] allCodes = game.getCodes();
		for (int i = 0; i < allCodes.length; i++) {
			new ProposedCombinationView().write(allCodes[i][0]);
			new ResultView().writeln(allCodes[i][1]);
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

	private int proposeCombination(int[] codes, Game game) {
		mastermind.models.Error error = ProposedCombination.isValid(codes);
		if (error != null) {
			return error.ordinal();
		}
		ProposedCombination proposedCombination = ProposedCombination.getInstance(codes);
		game.proposeCombination(proposedCombination);
		return Game.NO_ERROR;
	}

}
