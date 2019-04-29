package mastermind.views.console;

import mastermind.models.Game;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

class StartView extends WithConsoleView {

	void interact(Game game) {
		this.console.writeln(MessageView.TITLE.getMessage());
		new SecretCombinationView().writeln();
	}

}
