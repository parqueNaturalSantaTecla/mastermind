package mastermind.views.console;

import mastermind.controllers.Logic;
import mastermind.utils.WithConsoleView;
import mastermind.views.Error;
import mastermind.views.Message;

class ProposalView extends WithConsoleView {

	boolean interact(Logic logic) {
		int error;
		do {
			int[] codes = new ProposedCombinationView().read();
			error = logic.proposeCombination(codes);
			if (error != Logic.NO_ERROR) {
				this.console.writeln(Error.values()[error].getMessage());
			}
		} while (error != Logic.NO_ERROR);
		this.console.writeln();
		this.console.writeln(Message.TURN.getMessage().replaceFirst("#turn", "" + logic.getTurn()));
		new SecretCombinationView().writeln(logic.getWidth());
		int[][][] allCodes = logic.getAllCodes();
		for (int i = 0; i < allCodes.length; i++) {
			new ProposedCombinationView().write(allCodes[i][0]);
			new ResultView().writeln(allCodes[i][1]);
		}
		if (logic.isWinner()) {
			this.console.writeln(Message.WINNER.getMessage());
			return true;
		} else if (logic.isLooser()) {
			this.console.writeln(Message.LOOSER.getMessage());
			return true;
		}
		return false;
	}

}
