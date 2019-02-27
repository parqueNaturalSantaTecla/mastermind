package mastermind.views.console;

import mastermind.controllers.PlayController;
import mastermind.controllers.ProposalController;
import mastermind.utils.Command;
import mastermind.views.Error;

public class ProposeCommand extends Command{
	
	public static final String TITLE = "Proponer Combinación";
	
	PlayController playController;

	public ProposeCommand(PlayController playController) {
		this.playController = playController;
		this.title = ProposeCommand.TITLE;
	}

	@Override
	public void execute() {
		int error;
		do {
			int[] codes = new ProposedCombinationView().read();
			error = playController.proposeCombination(codes);
			if (error != ProposalController.NO_ERROR) {
				this.console.writeln(Error.values()[error].getMessage());
			}
		} while (error != ProposalController.NO_ERROR);
		new GameView(this.playController);
	}

	@Override
	public boolean isActive() {
		return true;
	}

}
