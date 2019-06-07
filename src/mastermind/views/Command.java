package mastermind.views;

import mastermind.controllers.PlayController;

public abstract class Command extends santaTecla.utils.Command {

	protected PlayController playController;

	protected Command(String title, PlayController playController) {
		super(title);
		this.playController = playController;
	}
	
}
