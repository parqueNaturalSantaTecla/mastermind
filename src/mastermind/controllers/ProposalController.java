package mastermind.controllers;

import mastermind.models.Combination;
import mastermind.models.Game;
import mastermind.models.ProposedCombination;

public class ProposalController extends Controller {

	public ProposalController(Game game, State state) {
		super(game, state);
	}

	public Error proposeCombination(int[] codes) {
		assert codes.length == Combination.getWidth();
		ProposedCombination proposedCombination = ProposedCombination.getInstance(codes);
		if (proposedCombination == null) {
			return Error.WRONG_LENGTH;
		}
		if (proposedCombination.isDuplicated()) {
			return Error.DUPLICATED;
		}
		this.game.proposeCombination(proposedCombination);
		if (this.game.isGameOver()) {
			this.state.next();
		}
		return null;
	}

	public int[][][] getAllCodes() {
		return this.game.getCodes();
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}
