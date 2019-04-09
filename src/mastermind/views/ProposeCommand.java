package mastermind.views;

import mastermind.models.Session;
import mastermind.utils.Command;

public class ProposeCommand extends Command {

	public ProposeCommand(Session session) {
		super(Message.PROPOSE_COMMAND.getMessage(), session);
	}

	@Override
	public void updateIsActive() {
		this.isActive = true;
	}

}
