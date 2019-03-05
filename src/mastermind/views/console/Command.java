package mastermind.views.console;

import mastermind.controllers.PlayController;

public abstract class Command extends mastermind.utils.Command {

	protected PlayController playController;

	protected Command(String title, PlayController playController) {
		super(title);
		this.playController = playController;
	}
	
}
