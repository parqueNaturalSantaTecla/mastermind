package mastermind.views;

import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;

public abstract class View {

	protected ProposalController proposalController;

	protected ResumeController resumeController;

	public View(ProposalController proposalController, ResumeController resumeController) {
		this.proposalController = proposalController;
		this.resumeController = resumeController;
	}

	public void interact() {
		boolean resume;
		do {
			this.start();
			boolean finished;
			do {
				finished = this.propose();
			} while (!finished);
			resume = this.resume();
		} while (resume);
	}

	protected abstract void start();

	protected abstract boolean propose();

	protected abstract boolean resume();

}
