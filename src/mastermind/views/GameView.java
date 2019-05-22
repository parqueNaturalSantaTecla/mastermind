package mastermind.views;

import mastermind.controllers.GameController;
import mastermind.utils.WithConsoleView;
import mastermind.views.menus.MessageView;

public class GameView extends WithConsoleView {

	GameController gameController;

	public GameView(GameController gameController) {
		this.gameController = gameController;
	}

	void writeln() {
		this.console.writeln();
		new AttemptsView(this.gameController).writeln();
		new SecretCombinationView(this.gameController).writeln();
		for (int i = 0; i < this.gameController.getAttempts(); i++) {
			new ProposedCombinationView(this.gameController).write(i);
			new ResultView(this.gameController).writeln(i);
		}
		if (this.gameController.isWinner()) {
			this.console.writeln(MessageView.WINNER.getMessage());
		} else if (this.gameController.isLooser()) {
			this.console.writeln(MessageView.LOOSER.getMessage());
		}
	}

}
