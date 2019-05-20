package mastermind.views;

import mastermind.controllers.PlayController;

class RedoCommand extends Command{
	
	RedoCommand(PlayController playController) {
		super(MessageView.REDO_COMMAND.getMessage(), playController);
	}

	@Override
	protected void execute() {
		this.playController.redo();
		new GameView(this.playController);
	}

	@Override
	protected boolean isActive() {
		return this.playController.redoable();
	}

}
