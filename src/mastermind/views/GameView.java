package mastermind.views;

import mastermind.controllers.PlayController;
import santaTecla.utils.WithConsoleView;

class GameView extends WithConsoleView {

	GameView(PlayController playController) {
		this.console.writeln();
		new AttemptsView(playController).writeln();
		new SecretCombinationView(playController).writeln();
		for (int i = 0; i < playController.getAttempts(); i++) {
			new ProposedCombinationView(playController).write(i);
			new ResultView(playController).writeln(i);
		}
		if (playController.isWinner()) {
			this.console.writeln(MessageView.WINNER.getMessage());
		} else if (playController.isLooser()) {
			this.console.writeln(MessageView.LOOSER.getMessage());
		}
	}
	
}
