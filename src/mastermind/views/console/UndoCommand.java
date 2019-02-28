package mastermind.views.console;

import mastermind.controllers.PlayController;
import mastermind.utils.Command;

public class UndoCommand extends Command{

	public static final String TITLE = "Deshacer propuesta anterior";
	
	PlayController playController;

	UndoCommand(PlayController playController) {
		this.playController = playController;
		this.title = UndoCommand.TITLE;
	}

	@Override
	public void execute() {
		this.playController.undo();
		new GameView(this.playController);
	}

	@Override
	public boolean isActive() {
		return this.playController.undoable();
	}
}
