package mastermind.views;

import mastermind.models.Game;

public class GameView {
	
	private Game game;

	public GameView(Game game) {
		this.game = game;
	}

	public void writeGame() {
		MessageView.ATTEMPTS.writeln();
		new AttemptsView(this.game).writeln();
		new SecretCombinationView(this.game.getSecretCombination()).writeln();
		for (int i = 0; i < this.game.getAttempts(); i++) {
			new ProposedCombinationView(this.game.getProposedCombination(i)).write();
			new ResultView(this.game.getResultCombination(i)).writeln();
		}
	}

	public void writeLooser() {
		MessageView.LOOSER.writeln();
	}

	public void writeWinner() {
		MessageView.WINNER.writeln();
	}

}
