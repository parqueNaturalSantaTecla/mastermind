package mastermind.controllers;

import mastermind.models.Error;
import mastermind.models.ProposedCombination;
import mastermind.models.Session;
import mastermind.models.SessionImplementation;

public class ProposalController extends Controller {

	public static final int NO_ERROR = -1;

	public ProposalController(Session session) {
		super(session);
	}

	public int proposeCombination(int[] codes) {
		Error error = ProposedCombination.isValid(codes);
		if (error != null) {
			return error.ordinal();
		}
		ProposedCombination proposedCombination = ProposedCombination.getInstance(codes);
		((SessionImplementation) this.session).proposeCombination(proposedCombination);
		if (((SessionImplementation) this.session).isWinner() || ((SessionImplementation) this.session).isLooser()) {
			((SessionImplementation) this.session).next();
		}
		return ProposalController.NO_ERROR;
	}

	public int[][][] getAllCodes() {
		return ((SessionImplementation) this.session).getCodes();
	}

	public int getTurn() {
		return ((SessionImplementation) this.session).getTurn();
	}

	public boolean isWinner() {
		return ((SessionImplementation) this.session).isWinner();
	}

	public boolean isLooser() {
		return ((SessionImplementation) this.session).isLooser();
	}

}
