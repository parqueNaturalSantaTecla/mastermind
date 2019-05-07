package mastermind;

import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.views.View;
import mastermind.views.graphics.GraphicsView;

public class GraphicsMastermind extends Mastermind {

	@Override
	protected View createView(StartController startController, ProposalController proposalController,
			ResumeController resumeController) {
		return new GraphicsView(startController, proposalController, resumeController);
	}

	public static void main(String[] args) {
		new GraphicsMastermind().play();
	}
}
