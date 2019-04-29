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
		this.proposalView = new ProposalView(this.game);
		this.resumeView = new ResumeView(this.game);
	}

	public void interact() {
		boolean resume;
		do {
			this.startView.interact();
			boolean finished;
			do {
				finished = this.proposalView.interact();
			} while (!finished);
			resume = this.resumeView.interact();
		} while (resume);
	}

}
