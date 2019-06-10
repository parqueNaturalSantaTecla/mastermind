package mastermind.views.menus;

import mastermind.controllers.PlayController;
import santaTecla.utils.Menu;

public class PlayMenu extends Menu {

	public PlayMenu(PlayController playController) {
		this.addCommand(new ProposeCommand(playController));
		this.addCommand(new UndoCommand(playController));
		this.addCommand(new RedoCommand(playController));
		this.addCommand(new ExitCommand(playController));
	}

}
