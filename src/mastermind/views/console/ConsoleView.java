package mastermind.views.console;

import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.views.View;

public class ConsoleView extends View {

	private StartView startView;

	private ProposalView proposalView;

	private ResumeView resumeView;

	public ConsoleView(ProposalController proposalController, ResumeController resumeController) {
		super(proposalController, resumeController);
		this.startView = new StartView();
		this.proposalView = new ProposalView();
		this.resumeView = new ResumeView();
	}

	@Override
	protected void start() {
		this.startView.interact();
	}

	@Override
	protected boolean propose() {
		return this.proposalView.interact(this.proposalController);
	}

	@Override
	protected boolean resume() {
		return this.resumeView.interact(this.resumeController);
	}

}
