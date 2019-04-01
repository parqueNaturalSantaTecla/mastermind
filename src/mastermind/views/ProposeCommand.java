package mastermind.views;

import mastermind.models.Session;
import mastermind.utils.Command;

public class ProposeCommand extends Command {

	public static final String TITLE = "Proponer Combinación";

	public ProposeCommand(Session session) {
		super(ProposeCommand.TITLE, session);
		this.updateIsActive();
	}

	@Override
	public void updateIsActive() {
		this.isActive = true;
	}

}
