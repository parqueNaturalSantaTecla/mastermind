package mastermind.views;

import mastermind.events.ProposeEvent;
import mastermind.models.Mastermind;
import mastermind.views.Command;
import santaTecla.utils.Observer;

public class ProposeCommand extends Command {

	ProposeCommand(Mastermind mastermind, Observer observer) {
		super(MessageView.PROPOSE_COMMAND.getMessage(), mastermind, observer);
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
