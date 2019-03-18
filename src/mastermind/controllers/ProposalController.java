package mastermind.controllers;

import mastermind.models.Error;
import mastermind.models.Game;
import mastermind.models.ProposedCombination;

public class ProposalController extends Controller {
	
	public static final int NO_ERROR = -1;

	public ProposalController(Game game, State state) {
		super(game, state);
	}

	public int proposeCombination(int[] codes) {
		Error error = ProposedCombination.isValid(codes);
		if (error != null) {
			return error.ordinal();
		}
		ProposedCombination proposedCombination = ProposedCombination.getInstance(codes);
		this.game.proposeCombination(proposedCombination);
		if (this.game.isWinner() || this.game.isLooser()) {
			this.state.next();
		}
		return ProposalController.NO_ERROR;
	}

	public int[][][] getAllCodes() {
		return this.game.getCodes();
	}
	
	public int getTurn() {
		return this.game.getTurn();
	}

	public boolean isWinner() {
		return this.game.isWinner();
	}

	public boolean isLooser() {
		return this.game.isLooser();
	}

}
