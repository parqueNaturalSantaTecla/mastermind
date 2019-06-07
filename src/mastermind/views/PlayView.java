package mastermind.views;

import mastermind.controllers.PlayController;

class PlayView {

	void interact(PlayController playController) {
		new PlayMenu(playController).execute();	
	}

}
