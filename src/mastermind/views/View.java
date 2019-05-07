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
		boolean newGame;
		do {
			this.startView.interact();
			boolean finished;
			do {
				finished = this.proposalView.interact(game);
			} while (!finished);
			newGame = this.resumeView.interact(game);
		} while (newGame);
	}

}
