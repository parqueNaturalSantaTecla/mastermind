package mastermind.views;

import mastermind.controllers.PlayController;
import mastermind.menus.PlayMenu;

class PlayView {

	void interact(PlayController playController) {
		new PlayMenu(playController).execute();	
		new GameView(playController).writeln();
	}

}
