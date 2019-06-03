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

	public void clearGame() {
		this.resumeController.clearGame();
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

	public List<Color> getColors(int position) {
		return this.proposalController.getColors(position);
	}

	public int getBlacks(int position) {
		return this.proposalController.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.proposalController.getWhites(position);
	}

	public int getWidth() {
		return this.startController.getWidth();
	}

}
