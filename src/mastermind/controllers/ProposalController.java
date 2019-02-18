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
		if (this.game.isGameOver()) {
			this.state.next();
		}
		return ProposalController.NO_ERROR;
	}

	public int[][][] getAllCodes() {
		return this.game.getCodes();
	}
	
	public int getTurn() {
		return game.getTurn();
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}
