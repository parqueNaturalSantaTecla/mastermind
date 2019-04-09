package mastermind.views;

import mastermind.utils.Command;

public class UndoCommand extends Command {

	public UndoCommand() {
		super(Message.UNDO_COMMAND.getMessage());
	}

	@Override
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
