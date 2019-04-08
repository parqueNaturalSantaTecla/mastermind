package mastermind.controllers;

import mastermind.models.Error;
import mastermind.models.Game;
import mastermind.models.ProposedCombination;

class ProposalController extends Controller {

	ProposalController(Game game) {
		super(game);
	}

	int proposeCombination(int[] codes) {
		Error error = ProposedCombination.isValid(codes);
		if (error != null) {
			return error.ordinal();
		}
		ProposedCombination proposedCombination = ProposedCombination.getInstance(codes);
		this.game.proposeCombination(proposedCombination);
		return Logic.NO_ERROR;
	}

	int[][][] getAllCodes() {
		return this.game.getCodes();
	}

	boolean isWinner() {
		return this.game.isWinner();
	}

	boolean isLooser() {
		return this.game.isLooser();
	}
	
	int getTurn() {
		return this.game.getTurn();
	}

}
