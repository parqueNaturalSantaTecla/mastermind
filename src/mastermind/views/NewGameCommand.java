package mastermind.views;

import mastermind.controllers.StartController;

class NewGameCommand extends Command {

	private static final String TITLE = "Comenzar una partida nueva";

	protected NewGameCommand(StartController startController) {
		super(NewGameCommand.TITLE, startController);
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
