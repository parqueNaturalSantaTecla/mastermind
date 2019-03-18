package mastermind.views.graphics;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import mastermind.controllers.ProposalController;

@SuppressWarnings("serial")
class ProposedCombinationsView extends JPanel {

	ProposedCombinationsView() {
		this.setLayout(new GridBagLayout());
	}

	void add(ProposalController proposalController) {
		int turn = proposalController.getTurn();
		int[][][] allCodes = proposalController.getAllCodes();
		int[][] codes = allCodes[allCodes.length - 1];
		this.add(new TurnView(turn), new Constraints(0, turn, 1, 1));
		this.add(new ProposedCombinationView(codes[0]), new Constraints(1, turn, 1, 1));
		this.add(new ResultView(codes[1]), new Constraints(2, turn, 1, 1));
	}
}
