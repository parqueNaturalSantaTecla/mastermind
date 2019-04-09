package mastermind.views;

import mastermind.controllers.StartController;

class OpenGameCommand extends Command{

	protected OpenGameCommand(StartController startController) {
		super(Message.OPENGAME_COMMAND.getMessage(), startController);
	}

	@Override
	protected void execute() {
		new GameSelectMenu((StartController) this.acceptorController).execute();
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
