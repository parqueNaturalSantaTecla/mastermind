package mastermind.views;

import mastermind.models.Session;
import mastermind.utils.Command;

public class RedoCommand extends Command{
	
	public static final String TITLE = "Rehacer propuesta anterior";
	
	public RedoCommand(Session session) {
		super(RedoCommand.TITLE, session);
	}

	@Override
	public void updateIsActive() {
		this.isActive = this.session.redoable();
	}

}
