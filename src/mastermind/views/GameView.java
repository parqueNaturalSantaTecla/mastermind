package mastermind.views;

import mastermind.controllers.GameController;
import mastermind.views.menus.MessageView;

public class GameView {

	GameController gameController;

	public GameView(GameController gameController) {
		this.gameController = gameController;
	}

	void writeln() {
		MessageView.NEW_LINE.writeln();
		new AttemptsView(this.gameController).writeln();
		new SecretCombinationView(this.gameController).writeln();
		for (int i = 0; i < this.gameController.getAttempts(); i++) {
			new ProposedCombinationView(this.gameController).write(i);
			new ResultView(this.gameController).writeln(i);
		}
		if (this.gameController.isWinner()) {
			MessageView.WINNER.writeln();
		} else if (this.gameController.isLooser()) {
			MessageView.LOOSER.writeln();
		}
	}

}
