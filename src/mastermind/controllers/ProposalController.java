package mastermind.controllers;

import mastermind.models.Error;
import mastermind.models.Game;
import mastermind.models.ProposedCombination;

public class ProposalController extends Controller {

	public ProposalController(Game game) {
		super(game);
	}

	public int proposeCombination(int[] codes) {
		Error error = ProposedCombination.isValid(codes);
		if (error != null) {
			return error.ordinal();
		}
		ProposedCombination proposedCombination = ProposedCombination.getInstance(codes);
		this.game.proposeCombination(proposedCombination);
		return Logic.NO_ERROR;
	}

	public int[][][] getAllCodes() {
		return this.game.getCodes();
	}

	public boolean isWinner() {
		return this.game.isWinner();
	}

	public boolean isLooser() {
		return this.game.isLooser();
	}
	
	public int getTurn() {
		return this.game.getTurn();
	}

	public int getWidth() {
		return this.game.getWidth();
	}

}
