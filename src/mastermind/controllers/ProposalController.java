package mastermind.controllers;

import mastermind.models.Error;
import mastermind.models.ProposedCombination;
import mastermind.models.Session;

public class ProposalController extends Controller{
	
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
		this.session.proposeCombination(proposedCombination);
		
		if (this.session.isWinner() || this.session.isLooser()) {
			this.session.next();
		}
		return ProposalController.NO_ERROR;
	}

	public int[][][] getAllCodes() {
		return this.session.getCodes();
	}
	
	public int getTurn() {
		return this.session.getTurn();
	}

	public boolean isWinner() {
		return this.session.isWinner();
	}

	public boolean isLooser() {
		return this.session.isLooser();
	}

}
