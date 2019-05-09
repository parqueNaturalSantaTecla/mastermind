package mastermind.views.graphics;

import java.awt.GridBagLayout;
import javax.swing.JPanel;

import mastermind.controllers.Logic;

@SuppressWarnings("serial")
class ProposedCombinationsView extends JPanel {
	
	private Logic logic;

	ProposedCombinationsView(Logic logic) {
		this.logic = logic;
		this.setLayout(new GridBagLayout());
	}

	void add() {
		int attempts = this.logic.getAttempts();
		this.add(new AttemptsView(attempts), new Constraints(0, attempts, 1, 1));
		this.add(new ProposedCombinationView(this.logic), new Constraints(1, attempts, 1, 1));
		this.add(new ResultView(this.logic), new Constraints(2, attempts, 1, 1));
	}
}
