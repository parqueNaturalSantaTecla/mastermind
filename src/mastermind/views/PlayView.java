package mastermind.views;

import mastermind.controllers.PlayController;
import mastermind.utils.WithConsoleView;
import mastermind.views.menus.PlayMenu;

class PlayView extends WithConsoleView {

	void interact(PlayController playController) {
		new PlayMenu(playController).execute();	
		new GameView(playController).writeln();
	}

}
