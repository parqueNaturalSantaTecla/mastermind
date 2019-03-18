package mastermind.views;

import mastermind.controllers.StartController;

class OpenGameCommand extends Command{
	
	private static final String TITLE = "Recuperar una partida guardada";

	protected OpenGameCommand(StartController startController) {
		super(OpenGameCommand.TITLE, startController);
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
