package mastermind.views;

import mastermind.events.RedoEvent;
import mastermind.models.Mastermind;
import mastermind.utils.Command;
import mastermind.utils.Observer;

public class RedoCommand extends Command{
	
	public RedoCommand(Mastermind mastermind, Observer observer) {
		super(Message.REDO_COMMAND.getMessage(), mastermind, observer);
	}

	@Override
	public void updateIsActive() {
		this.isActive = this.mastermind.redoable();
	}

	@Override
	public void execute() {
		this.notify(new RedoEvent());		
	}

}
