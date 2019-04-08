package mastermind.views;

import mastermind.controllers.PlayController;
import mastermind.controllers.ProposalController;

class ProposeCommand extends Command {

	ProposeCommand(PlayController playController) {
		super(Message.PROPOSE_COMMAND.getMessage(), playController);
	}

	@Override
	protected void execute() {
		int error;
		do {
			int[] codes = new ProposedCombinationView().read();
			error = ((PlayController) acceptorController).proposeCombination(codes);
			if (error != ProposalController.NO_ERROR) {
				this.console.writeln(Error.values()[error].getMessage());
			}
		} while (error != ProposalController.NO_ERROR);
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
