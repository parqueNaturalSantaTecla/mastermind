package mastermind.views;

import mastermind.controllers.PlayController;

public class UndoCommand extends Command {

	UndoCommand(PlayController playController) {
		super(Message.UNDO_COMMAND.getMessage(), playController);
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
