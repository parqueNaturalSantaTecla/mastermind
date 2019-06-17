package mastermind.views;

import mastermind.models.Session;
import santaTecla.utils.Command;

public class UndoCommand extends Command {

	public UndoCommand(Session session) {
		super(MessageView.UNDO_COMMAND.getMessage(), session);
	}

	@Override
	public void updateIsActive() {
		this.isActive = this.session.undoable();
	}
	
}
