package mastermind.views.console;

import mastermind.controllers.PlayController;

public class RedoCommand extends Command{
	
	public static final String TITLE = "Rehacer propuesta anterior";
	
	RedoCommand(PlayController playController) {
		super(RedoCommand.TITLE, playController);
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
