package mastermind.views;

import mastermind.controllers.PlayController;
import mastermind.utils.Menu;

class PlayMenu extends Menu {

	PlayMenu(PlayController playController) {
		this.addCommand(new ProposeCommand(playController));
		this.addCommand(new UndoCommand(playController));
		this.addCommand(new RedoCommand(playController));
		this.addCommand(new ExitCommand(playController));
	}

}
