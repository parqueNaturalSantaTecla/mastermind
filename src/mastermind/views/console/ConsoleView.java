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
		this.proposalView = new ProposalView(this.game);
		this.resumeView = new ResumeView(this.game);
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
	protected boolean isNewGame() {
		return this.resumeView.interact();
	}

}
