package mastermind;

import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.views.View;
import mastermind.views.console.ConsoleView;

public class ConsoleMastermind extends Mastermind {

	@Override
	protected View createView(StartController startController, ProposalController proposalController,
			ResumeController resumeController) {
		return new ConsoleView(startController, proposalController, resumeController);
	}

	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}

}
