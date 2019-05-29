package mastermind.views;

import mastermind.utils.Command;

public class UndoCommand extends Command {

	public UndoCommand() {
		super(MessageView.UNDO_COMMAND.getMessage());
	}

	@Override
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
