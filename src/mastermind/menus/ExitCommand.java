package mastermind.menus;

import mastermind.controllers.PlayController;
import mastermind.views.Message;

class ExitCommand extends Command {
	
	protected ExitCommand(PlayController playController) {
		super(Message.EXIT_COMMAND.getMessage(), playController);
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
