package mastermind.views;

import java.util.List;

import mastermind.controllers.PlayController;
import mastermind.types.Color;
import mastermind.types.Error;

class ProposeCommand extends Command {

	ProposeCommand(PlayController playController) {
		super(MessageView.PROPOSE_COMMAND.getMessage(), playController);
	}

	@Override
	protected void execute() {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView(this.playController).read();
			error = this.playController.addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
		new GameView(this.playController);
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
