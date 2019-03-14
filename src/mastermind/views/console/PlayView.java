package mastermind.views.console;

import mastermind.controllers.PlayController;
import mastermind.utils.WithConsoleView;

class PlayView extends WithConsoleView {

	void interact(PlayController playController) {
		new PlayMenu(playController).execute();	
		new GameView(playController).writeln();
	}

}
