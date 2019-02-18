package mastermind.views;

import mastermind.controllers.ProposalController;

class ProposalView extends WithConsoleView {

	private static final String MESSAGES = "#turn intento(s)";

	public void interact(ProposalController proposalController) {
		int error;
		do {
			int[] codes = new ProposedCombinationView().read();
			error = proposalController.proposeCombination(codes);
			if (error != ProposalController.NO_ERROR) {
				new ErrorView().write(error);
			}
		} while (error != ProposalController.NO_ERROR);
		this.console.writeln();
		this.console.writeln(MESSAGES.replaceFirst("#turn", "" + proposalController.getTurn()));
		new SecretCombinationView().writeln(proposalController.getWidth());
		int[][][] allCodes = proposalController.getAllCodes();
		for (int i = 0; i < allCodes.length; i++) {
			new ProposedCombinationView().write(allCodes[i][0]);
			new ResultView().writeln(allCodes[i][1]);
		}
	}

}
