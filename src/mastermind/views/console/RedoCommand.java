package mastermind.views.console;

import mastermind.controllers.PlayController;
import mastermind.utils.Command;

public class RedoCommand extends Command{
	
	public static final String TITLE = "Rehacer propuesta anterior";
	
	PlayController playController;

	public RedoCommand(PlayController playController) {
		this.playController = playController;
		this.title = RedoCommand.TITLE;
	}

	@Override
	public void execute() {
		this.playController.redo();
		new GameView(this.playController);
	}

	@Override
	public boolean isActive() {
		return this.playController.redoable();
	}

}
