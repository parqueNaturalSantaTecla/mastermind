package mastermind.views.menus;

import java.util.List;

import mastermind.controllers.PlayController;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.views.models.ErrorView;
import mastermind.views.models.GameView;
import mastermind.views.models.ProposedCombinationView;

class ProposeCommand extends Command {

	ProposeCommand(PlayController playController) {
		super(MessageView.PROPOSE_COMMAND.getMessage(), playController);
	}

	@Override
	protected void execute() {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView((PlayController)this.acceptorController).read();
			error = ((PlayController)this.acceptorController).addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
		new GameView((PlayController)this.acceptorController);
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
