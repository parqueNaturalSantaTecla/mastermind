package mastermind.views;

import mastermind.controllers.Error;
import mastermind.controllers.ProposalController;
import mastermind.utils.Console;

public class ProposalView {

	public void interact(ProposalController proposalController) {
		Error error = null;
		do {
			int[] codes = new ProposedCombinationView().read();
			error = proposalController.proposeCombination(codes);
			if (error != null) {
				new ErrorView().write(error);
			}
		} while (error!=null);
		new SecretCombinationView().writeln(proposalController.getWidth());
		new Console().writeln(proposalController.getTurn());
		int[][][] allCodes = proposalController.getAllCodes();
		for(int i=0; i<allCodes.length; i++) {
			new ProposedCombinationView().write(allCodes[i][0]);
			new ResultView().writeln(allCodes[i][1]);
		}
	}

}
