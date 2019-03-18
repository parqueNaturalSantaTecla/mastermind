package mastermind.views.console;

import mastermind.controllers.Controller;
import mastermind.controllers.ProposalController;
import mastermind.utils.WithConsoleView;
import mastermind.views.Error;
import mastermind.views.Message;

class ProposalView extends WithConsoleView {

	boolean interact(ProposalController proposalController) {
		int error;
		do {
			int[] codes = new ProposedCombinationView().read();
			error = proposalController.proposeCombination(codes);
			if (error != Controller.NO_ERROR) {
				this.console.writeln(Error.values()[error].getMessage());
			}
		} while (error != Controller.NO_ERROR);
		this.console.writeln();
		this.console.writeln(Message.TURN.getMessage().replaceFirst("#turn", "" + proposalController.getTurn()));
		new SecretCombinationView().writeln(Controller.getWidth());
		int[][][] allCodes = proposalController.getAllCodes();
		for (int i = 0; i < allCodes.length; i++) {
			new ProposedCombinationView().write(allCodes[i][0]);
			new ResultView().writeln(allCodes[i][1]);
		}
		if (proposalController.isWinner()) {
			this.console.writeln(Message.WINNER.getMessage());
			return true;
		} else if (proposalController.isLooser()) {
			this.console.writeln(Message.LOOSER.getMessage());
			return true;
		}
		return false;
	}

}
