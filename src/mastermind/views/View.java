package mastermind.views;

import mastermind.models.Game;

public class View {

	private StartView startView;

	private ProposalView proposalView;

	private ResumeView resumeView;

	public View() {
		this.startView = new StartView();
		this.proposalView = new ProposalView();
		this.resumeView = new ResumeView();
	}

	public void interact(Game game) {
		boolean resume;
		do {
			this.startView.interact();
			boolean finished;
			do {
				finished = this.proposalView.interact(game);
			} while (!finished);
			resume = this.resumeView.interact(game);
		} while (resume);
	}

}
