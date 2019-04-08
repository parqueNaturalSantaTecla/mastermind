package mastermind.views.console;

import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.views.View;

public class ConsoleView extends View {

	private StartView startView;

	private ProposalView proposalView;

	private ResumeView resumeView;

	public ConsoleView(StartController startController, ProposalController proposalController, ResumeController resumeController) {
		super(startController, proposalController, resumeController);
		this.startView = new StartView();
		this.proposalView = new ProposalView();
		this.resumeView = new ResumeView();
	}

	@Override
	protected void start() {
		this.startView.interact(this.startController);
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
