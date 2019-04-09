package mastermind.views;

import mastermind.utils.Command;

public class RedoCommand extends Command{
	
	public RedoCommand() {
		super(Message.REDO_COMMAND.getMessage());
	}

	@Override
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
