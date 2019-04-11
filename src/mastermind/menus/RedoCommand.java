package mastermind.menus;

import mastermind.controllers.PlayController;
import mastermind.views.Message;

class RedoCommand extends Command{
	
	RedoCommand(PlayController playController) {
		super(Message.REDO_COMMAND.getMessage(), playController);
	}

	@Override
	protected void execute() {
		((PlayController) this.acceptorController).redo();
	}

	@Override
	protected boolean isActive() {
		return ((PlayController) this.acceptorController).redoable();
	}

}
