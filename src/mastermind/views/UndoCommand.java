package mastermind.views;

import mastermind.models.Mastermind;
import mastermind.mvcUtils.Observer;
import mastermind.mvcUtils.UndoEvent;
import mastermind.utils.Command;

public class UndoCommand extends Command {

	public static final String TITLE = "Deshacer propuesta anterior";

	public UndoCommand(Mastermind mastermind, Observer observer) {
		super(UndoCommand.TITLE, mastermind, observer);
	}

	@Override
	public void updateIsActive() {
		this.isActive = this.mastermind.undoable();
	}

	@Override
	public void execute() {
		System.out.println("UndoCommand");
		this.notify(new UndoEvent());
	}
	
}
