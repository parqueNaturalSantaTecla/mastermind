package mastermind.views;

import santaTecla.utils.Command;

public class RedoCommand extends Command{
	
	public RedoCommand() {
		super(MessageView.REDO_COMMAND.getMessage());
	}

	@Override
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
