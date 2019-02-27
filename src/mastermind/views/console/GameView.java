package mastermind.views.console;

import mastermind.controllers.PlayController;
import mastermind.utils.WithConsoleView;
import mastermind.views.Message;

public class GameView extends WithConsoleView {

	public GameView(PlayController playController) {
		this.console.writeln();
		this.console.writeln(Message.TURN.getMessage().replaceFirst("#turn", "" + playController.getTurn()));
		new SecretCombinationView().writeln(playController.getWidth());
		int[][][] allCodes = playController.getAllCodes();
		for (int i = 0; i < allCodes.length; i++) {
			new ProposedCombinationView().write(allCodes[i][0]);
			new ResultView().writeln(allCodes[i][1]);
		}
		if (playController.isWinner()) {
			this.console.writeln(Message.WINNER.getMessage());
		} else if (playController.isLooser()) {
			this.console.writeln(Message.LOOSER.getMessage());
		}
	}
	
}
