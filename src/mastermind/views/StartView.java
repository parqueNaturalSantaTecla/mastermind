package mastermind.views;

import mastermind.models.Game;
import mastermind.utils.WithConsoleView;

class StartView extends WithConsoleView {

	void interact(Game game) {
		MessageView.TITLE.writeln();
		new SecretCombinationView().writeln();
	}

}
