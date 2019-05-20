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
		int attempts = proposalController.getAttempts();
		this.add(new AttemptsView(attempts), new Constraints(0, attempts, 1, 1));
		this.add(new ProposedCombinationView(proposalController), new Constraints(1, attempts, 1, 1));
		this.add(new ResultView(proposalController), new Constraints(2, attempts, 1, 1));
	}
}
