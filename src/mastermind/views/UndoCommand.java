package mastermind.views;

import mastermind.events.UndoEvent;
import mastermind.models.Mastermind;
import mastermind.views.Command;
import mastermind.utils.Observer;

public class UndoCommand extends Command {

	public UndoCommand(Mastermind mastermind, Observer observer) {
		super(Message.UNDO_COMMAND.getMessage(), mastermind, observer);
	}

	@Override
	public void updateIsActive() {
		this.isActive = this.mastermind.undoable();
	}

	@Override
	public void execute() {
		this.notify(new UndoEvent());
	}
	
}
