package mastermind.views;

import mastermind.utils.Command;

public class RedoCommand extends Command{
	
	public static final String TITLE = "Rehacer propuesta anterior";
	
	public RedoCommand() {
		super(RedoCommand.TITLE);
	}

	@Override
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
