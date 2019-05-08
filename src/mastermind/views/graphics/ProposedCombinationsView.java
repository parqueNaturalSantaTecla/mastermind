package mastermind.views.graphics;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import mastermind.controllers.ProposalController;

@SuppressWarnings("serial")
class ProposedCombinationsView extends JPanel {
	
	private ProposalController proposalController;

	ProposedCombinationsView(ProposalController proposalController) {
		this.proposalController = proposalController;
		this.setLayout(new GridBagLayout());
	}

	void add() {
		int attempts = this.proposalController.getAttempts();
		this.add(new AttemptsView(attempts), new Constraints(0, attempts, 1, 1));
		this.add(new ProposedCombinationView(this.proposalController), new Constraints(1, attempts, 1, 1));
		this.add(new ResultView(this.proposalController), new Constraints(2, attempts, 1, 1));
	}
}
