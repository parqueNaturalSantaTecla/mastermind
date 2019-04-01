package mastermind.views;

import mastermind.models.Session;
import mastermind.utils.Command;

public class UndoCommand extends Command {

	public static final String TITLE = "Deshacer propuesta anterior";

	public UndoCommand(Session session) {
		super(UndoCommand.TITLE, session);
		this.updateIsActive();
	}

	@Override
	public void updateIsActive() {
		this.isActive = this.session.undoable();
	}
	
}
