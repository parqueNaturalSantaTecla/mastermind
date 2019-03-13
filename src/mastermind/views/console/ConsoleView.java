package mastermind.views.console;

import mastermind.models.Game;
import mastermind.views.View;

public class ConsoleView extends View {

	private StartView startView;

	private ProposalView proposalView;

	private ResumeView resumeView;

	public ConsoleView(Game game) {
		super(game);
		this.startView = new StartView();
		this.proposalView = new ProposalView();
		this.resumeView = new ResumeView();
	}

	@Override
	protected void start() {
		this.startView.interact(this.game);
	}

	@Override
	protected boolean propose() {
		return this.proposalView.interact(this.game);
	}

	@Override
	protected boolean resume() {
		return this.resumeView.interact(this.game);
	}

}
