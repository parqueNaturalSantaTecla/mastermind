package mastermind.views.console;

import mastermind.controllers.StartController;

public class OpenGameCommand extends Command{
	
	public static final String TITLE = "Recuperar una partida guardada";

	protected OpenGameCommand(StartController startController) {
		super(OpenGameCommand.TITLE, startController);
	}

	@Override
	protected void execute() {
		new GameSelectMenu((StartController) this.acceptorController).execute();
		new GameView((StartController) this.acceptorController).show();
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
