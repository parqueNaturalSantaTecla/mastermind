package mastermind.views.console;

import mastermind.controllers.Logic;
import mastermind.views.View;

public class ConsoleView extends View {

	private StartView startView;

	private ProposalView proposalView;

	private ResumeView resumeView;

	public ConsoleView(Logic logic) {
		super(logic);
		this.startView = new StartView();
		this.proposalView = new ProposalView();
		this.resumeView = new ResumeView();
	}

	@Override
	protected void start() {
		this.startView.interact(this.logic);
	}

	@Override
	protected boolean propose() {
		return this.proposalView.interact(this.logic);
	}

	@Override
	protected boolean resume() {
		return this.resumeView.interact(this.logic);
	}

}
