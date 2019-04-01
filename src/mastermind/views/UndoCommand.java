package mastermind.views;

import mastermind.utils.Command;

public class UndoCommand extends Command {

	public static final String TITLE = "Deshacer propuesta anterior";

	public UndoCommand() {
		super(UndoCommand.TITLE);
	}

	@Override
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
