package mastermind.views;

import mastermind.models.Mastermind;
import mastermind.mvcUtils.Observer;
import mastermind.mvcUtils.UndoEvent;
import mastermind.utils.Command;

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
