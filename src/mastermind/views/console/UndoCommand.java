package mastermind.views.console;

import mastermind.controllers.PlayController;

public class UndoCommand extends Command {

	public static final String TITLE = "Deshacer propuesta anterior";

	UndoCommand(PlayController playController) {
		super(UndoCommand.TITLE, playController);
	}

	@Override
	protected void execute() {
		((PlayController) this.acceptorController).undo();
	}

	@Override
	protected boolean isActive() {
		return ((PlayController) this.acceptorController).undoable();
	}
	
}
