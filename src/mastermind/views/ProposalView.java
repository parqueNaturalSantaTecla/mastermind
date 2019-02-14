package mastermind.views;

import mastermind.controllers.Error;
import mastermind.controllers.ProposalController;

public class ProposalView {

	public void interact(ProposalController proposalController) {
		boolean ok = false;
		do {
			int[] codes = new ProposedCombinationView().read();
			Error error = proposalController.proposeCombination(codes);
			if (error == null) {
				ok = true;
			} else {
				new ErrorView().write(error);
			}
		} while (!ok);
		new SecretCombinationView().writeln(proposalController.getWidth());
		int[][][] allCodes = proposalController.getAllCodes();
		for(int i=0; i<allCodes.length; i++) {
			new ProposedCombinationView().write(allCodes[i][0]);
			new ResultView().writeln(allCodes[i][1]);
		}
	}

}
