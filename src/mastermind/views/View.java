package mastermind.views;

import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;

public abstract class View {
	
	protected StartController startController;

	protected ProposalController proposalController;

	protected ResumeController resumeController;

	public View(StartController startController, ProposalController proposalController, ResumeController resumeController) {
		this.startController = startController;
		this.proposalController = proposalController;
		this.resumeController = resumeController;
	}

	public void interact() {
		boolean newGame;
		do {
			this.start();
			boolean finished;
			do {
				finished = this.propose();
			} while (!finished);
			newGame = this.isNewGame();
		} while (newGame);
	}

	protected abstract void start();

	protected abstract boolean propose();

	protected abstract boolean isNewGame();

}
