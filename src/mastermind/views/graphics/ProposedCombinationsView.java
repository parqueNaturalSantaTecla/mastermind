package mastermind.views.graphics;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import mastermind.models.Game;

@SuppressWarnings("serial")
class ProposedCombinationsView extends JPanel {
	
	private Game game;

	ProposedCombinationsView(Game game) {
		this.game = game;
		this.setLayout(new GridBagLayout());
	}

	void add() {
		int attempts = this.game.getAttempts();
		this.add(new AttemptsView(attempts), new Constraints(0, attempts, 1, 1));
		this.add(new ProposedCombinationView(this.game.getProposedCombination(attempts-1)), new Constraints(1, attempts, 1, 1));
		this.add(new ResultView(this.game.getResult(attempts-1)), new Constraints(2, attempts, 1, 1));
	}
}
