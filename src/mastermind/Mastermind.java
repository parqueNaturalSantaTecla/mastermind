package mastermind;

import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.models.Game;
import mastermind.views.View;

public abstract class Mastermind {

	public static final int NO_ERROR = -1;

	private Game game;

	private ProposalController proposalController;

	private ResumeController resumeController;
	
	private View view;

	protected Mastermind() {
		this.game = new Game();
		this.proposalController = new ProposalController (this.game);
		this.resumeController = new ResumeController (this.game);
		this.view = this.createView(this.proposalController, this.resumeController);
	}

	protected abstract View createView(ProposalController proposalController, ResumeController resumeController);

	protected void play() {
		this.view.interact();
	}

}
