package mastermind;

import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.models.Game;
import mastermind.views.View;

public abstract class Mastermind {

	public static final int NO_ERROR = -1;

	private Game game;
	
	private StartController startController;

	private ProposalController proposalController;

	private ResumeController resumeController;
	
	private View view;

	protected Mastermind() {
		this.game = new Game();
		this.startController = new StartController(this.game);
		this.proposalController = new ProposalController (this.game);
		this.resumeController = new ResumeController (this.game);
		this.view = this.createView(this.startController, this.proposalController, this.resumeController);
	}

	protected abstract View createView(StartController startController, ProposalController proposalController, ResumeController resumeController);

	protected void play() {
		this.view.interact();
	}

}
