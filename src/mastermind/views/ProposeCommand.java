package mastermind.views;

import mastermind.utils.Command;

public class ProposeCommand extends Command {

	public static final String TITLE = "Proponer Combinación";

	public ProposeCommand() {
		super(ProposeCommand.TITLE);
	}

	@Override
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
