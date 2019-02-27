package mastermind.views.console;

import mastermind.controllers.PlayController;
import mastermind.utils.Menu;

public class PlayMenu extends Menu{

	public PlayMenu(PlayController playController) {
		this.addCommand(new ProposeCommand(playController));
		if(playController.undoable()) {
			this.addCommand(new UndoCommand(playController));
		}
		if(playController.redoable()) {
			this.addCommand(new RedoCommand(playController));
		}
	}

}
