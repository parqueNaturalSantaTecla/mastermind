package mastermind.controllers;

import mastermind.views.Error;
import mastermind.models.ProposedCombination;
import mastermind.models.Session;
import mastermind.views.ProposedCombinationView;

public class ProposalController extends InGameController {

	public static final int NO_ERROR = -1;

	public ProposalController(Session session) {
		super(session);
	}

	@Override
	public void inGameControl() {
		int error;
		do {
			int[] codes = new ProposedCombinationView().read();
			error = this.proposeCombination(codes);
			if (error != ProposalController.NO_ERROR) {
				Error.values()[error].write();
			}
		} while (error != ProposalController.NO_ERROR);
	}

	public int proposeCombination(int[] codes) {
		mastermind.models.Error error = ProposedCombination.isValid(codes);
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
