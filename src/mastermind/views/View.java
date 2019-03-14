package mastermind.views;

import mastermind.models.Game;

public class View {

	protected Game game;

	private StartView startView;

	private ProposalView proposalView;

	private ResumeView resumeView;

	public View(Game game) {
		this.game = game;
		this.startView = new StartView();
		this.proposalView = new ProposalView();
		this.resumeView = new ResumeView();
	}

	public void interact() {
		boolean resume;
		do {
			this.startView.interact(this.game);
			boolean finished;
			do {
				finished = this.proposalView.interact(this.game);
			} while (!finished);
			resume = this.resumeView.interact(this.game);
		} while (resume);
	}

}
