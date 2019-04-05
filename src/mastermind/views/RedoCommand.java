package mastermind.views;

import mastermind.models.Mastermind;
import mastermind.mvcUtils.Observer;
import mastermind.mvcUtils.RedoEvent;
import mastermind.utils.Command;

public class RedoCommand extends Command{
	
	public static final String TITLE = "Rehacer propuesta anterior";
	
	public RedoCommand(Mastermind mastermind, Observer observer) {
		super(RedoCommand.TITLE, mastermind, observer);
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
