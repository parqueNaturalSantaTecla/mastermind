package mastermind;

import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.views.View;
import mastermind.views.graphics.GraphicsView;

public class GraphicsMastermind extends Mastermind {

	@Override
	protected View createView(ProposalController proposalController, ResumeController resumeController) {
		return new GraphicsView(proposalController, resumeController);
	}

	public static void main(String[] args) {
		new GraphicsMastermind().play();
	}
}
