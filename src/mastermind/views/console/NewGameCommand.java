package mastermind.views.console;

import mastermind.controllers.StartController;

public class NewGameCommand extends Command{
	
	public static final String TITLE = "Comenzar una partida nueva";

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
