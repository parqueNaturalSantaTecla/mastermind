package mastermind.controllers;

import java.util.List;

import mastermind.models.Game;
import mastermind.types.Color;
import mastermind.types.Error;

public class Logic {

	private Game game;
	
	private StartController startController;

	private ProposalController proposalController;

	private ResumeController resumeController;

	public Logic() {
		this.game = new Game();
		this.startController = new StartController(this.game);
		this.proposalController = new ProposalController(this.game);
		this.resumeController = new ResumeController(this.game);
	}

	public void resume(boolean newGame) {
		this.resumeController.resume(newGame);
	}

	public Error addProposedCombination(List<Color> colors) {
		return this.proposalController.addProposedCombination(colors);
	}

	public boolean isWinner() {
		return this.proposalController.isWinner();
	}

	public boolean isLooser() {
		return this.proposalController.isLooser();
	}

	public int getAttempts() {
		return this.proposalController.getAttempts();
	}

	public List<Color> getColors(int i) {
		return this.proposalController.getColors(i);
	}

	public int getBlacks(int i) {
		return this.proposalController.getBlacks(i);
	}

	public int getWhites(int i) {
		return this.proposalController.getWhites(i);
	}

	public int getWidth() {
		return this.startController.getWidth();
	}

}
