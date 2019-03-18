package mastermind.views;

import mastermind.controllers.PlayController;

public class ExitCommand extends Command {
	
	public static final String TITLE = "Salir de la partida";

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
