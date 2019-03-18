package mastermind.views;

import mastermind.controllers.PlayController;

public class UndoCommand extends Command {

	public static final String TITLE = "Deshacer propuesta anterior";

	UndoCommand(PlayController playController) {
		super(UndoCommand.TITLE, playController);
	}

	@Override
	protected void execute() {
		this.playController.undo();
		new GameView(this.playController);
	}

	@Override
	protected boolean isActive() {
		return this.playController.undoable();
	}
	
}
