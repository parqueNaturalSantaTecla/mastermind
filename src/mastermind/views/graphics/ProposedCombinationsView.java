package mastermind.views.graphics;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import mastermind.models.Game;

@SuppressWarnings("serial")
class ProposedCombinationsView extends JPanel {

	ProposedCombinationsView() {
		this.setLayout(new GridBagLayout());
	}

	void add(Game game) {
		int attempts = game.getAttempts();
		this.add(new AttemptsView(attempts), new Constraints(0, attempts, 1, 1));
		this.add(new ProposedCombinationView(game.getProposedCombination(attempts)), new Constraints(1, attempts, 1, 1));
		this.add(new ResultView(game.getResult(attempts)), new Constraints(2, attempts, 1, 1));
	}
}
