package mastermind.views;

import mastermind.controllers.PlayController;
import santaTecla.utils.Menu;

class PlayMenu extends Menu {

	PlayMenu(PlayController playController) {
		this.addCommand(new ProposeCommand(playController));
		this.addCommand(new UndoCommand(playController));
		this.addCommand(new RedoCommand(playController));
	}

}
