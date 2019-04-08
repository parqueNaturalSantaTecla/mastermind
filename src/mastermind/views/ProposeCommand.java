package mastermind.views;

import mastermind.models.Mastermind;
import mastermind.mvcUtils.Observer;
import mastermind.mvcUtils.ProposeEvent;
import mastermind.utils.Command;

public class ProposeCommand extends Command {

	public ProposeCommand(Mastermind mastermind, Observer observer) {
		super(Message.PROPOSE_COMMAND.getMessage(), mastermind, observer);
	}

	@Override
	public void updateIsActive() {
		this.isActive = true;
	}

	@Override
	public void execute() {
		this.notify(new ProposeEvent());
	}

}
