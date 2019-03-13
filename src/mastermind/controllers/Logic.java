package mastermind.controllers;

import mastermind.models.Game;

public class Logic {

	public static final int NO_ERROR = -1;

	private Game game;

	private ProposalController proposalController;

	private ResumeController resumeController;

	public Logic() {
		this.game = new Game();
		this.proposalController = new ProposalController(this.game);
		this.resumeController = new ResumeController(this.game);
	}

	public void resume(boolean resume) {
		this.resumeController.resume(resume);
	}

	public int proposeCombination(int[] codes) {
		return this.proposalController.proposeCombination(codes);
	}

	public boolean isWinner() {
		return this.proposalController.isWinner();
	}

	public boolean isLooser() {
		return this.proposalController.isLooser();
	}

	public int[][][] getAllCodes() {
		return this.proposalController.getAllCodes();
	}

	public int getTurn() {
		return this.proposalController.getTurn();
	}

	public int getWidth() {
		return this.proposalController.getWidth();
	}

}
