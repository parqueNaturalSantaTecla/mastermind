package mastermind.views.console;

import mastermind.models.Game;
import mastermind.utils.WithConsoleView;
import mastermind.views.Message;

class StartView extends WithConsoleView {

	void interact(Game game) {
		this.console.writeln(Message.TITLE.getMessage());
		new SecretCombinationView().writeln(game.getWidth());
	}

}
