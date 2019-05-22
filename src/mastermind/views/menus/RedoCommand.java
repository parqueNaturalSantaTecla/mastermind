package mastermind.views.menus;

import mastermind.controllers.PlayController;

class RedoCommand extends Command{
	
	RedoCommand(PlayController playController) {
		super(MessageView.REDO_COMMAND.getMessage(), playController);
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
