package mastermind.views;

import mastermind.controllers.PlayController;
import mastermind.views.menus.PlayMenu;
import mastermind.views.models.GameView;

class PlayView {

	void interact(PlayController playController) {
		new PlayMenu(playController).execute();	
		new GameView(playController).writeln();
	}

}
