package mastermind.views.console;

import mastermind.controllers.Logic;
import mastermind.views.View;

public class ConsoleView extends View {

	private StartView startView;

	private ProposalView proposalView;

	private ResumeView resumeView;

	public ConsoleView(Logic logic) {
		super(logic);
		this.startView = new StartView(this.logic);
		this.proposalView = new ProposalView(this.logic);
		this.resumeView = new ResumeView(this.logic);
	}

	@Override
	protected void start() {
		this.startView.interact();
	}

	@Override
	protected boolean propose() {
		return this.proposalView.interact();
	}

	@Override
	protected boolean resume() {
		return this.resumeView.interact();
	}

}
