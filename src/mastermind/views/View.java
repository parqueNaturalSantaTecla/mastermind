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
		boolean finished;
		boolean resume;
		do {
			this.start();
			do {
				finished = this.propose();
			} while (!finished);
			resume = this.resume();
		} while (resume);
	}

	protected void start() {
		this.startView.interact(this.game);
	}

	protected boolean propose() {
		return this.proposalView.interact(this.game);
	}

	protected boolean resume() {
		return this.resumeView.interact(this.game);
	}

}
