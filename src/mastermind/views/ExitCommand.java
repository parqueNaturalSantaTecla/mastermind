package mastermind.views;

import mastermind.controllers.PlayController;

class ExitCommand extends Command {
	
	private static final String TITLE = "Salir de la partida";

	protected ExitCommand(PlayController playController) {
		super(ExitCommand.TITLE, playController);
	}

	@Override
	protected void execute() {
		((PlayController) this.acceptorController).next();	
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
