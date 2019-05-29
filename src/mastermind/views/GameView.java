package mastermind.views;

import mastermind.models.Game;
import mastermind.utils.WithConsoleView;

public class GameView extends WithConsoleView {
	
	private Game game;

	public GameView(Game game) {
		this.game = game;
	}

	public void writeGame() {
		this.console.writeln();
		new AttemptsView(this.game).writeln();
		new SecretCombinationView(this.game.getSecretCombination()).writeln();
		for (int i = 0; i < this.game.getAttempts(); i++) {
			new ProposedCombinationView(this.game.getProposedCombination(i)).write();
			new ResultView(this.game.getResultCombination(i)).writeln();
		}
	}

	public void writeLooser() {
		this.console.writeln(MessageView.LOOSER.getMessage());
	}

	public void writeWinner() {
		this.console.writeln(MessageView.WINNER.getMessage());
	}

}
