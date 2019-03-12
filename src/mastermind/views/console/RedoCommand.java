package mastermind.views.console;

import mastermind.controllers.PlayController;

public class RedoCommand extends Command{
	
	public static final String TITLE = "Rehacer propuesta anterior";
	
	RedoCommand(PlayController playController) {
		super(RedoCommand.TITLE, playController);
	}

	@Override
	protected void execute() {
		((PlayController) this.acceptorController).redo();
	}

	@Override
	protected boolean isActive() {
		return ((PlayController) this.acceptorController).redoable();
	}

}
