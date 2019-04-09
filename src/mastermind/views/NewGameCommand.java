package mastermind.views;

import mastermind.controllers.StartController;

class NewGameCommand extends Command {
	
	protected NewGameCommand(StartController startController) {
		super(Message.NEWGAME_COMMAND.getMessage(), startController);
	}

	@Override
	protected void execute() {
		((StartController) this.acceptorController).start();
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
