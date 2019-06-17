package mastermind.controllers;

import mastermind.models.ProposedCombination;
import mastermind.models.Session;
import mastermind.views.ProposedCombinationView;

class ProposalController extends InGameController {

	ProposalController(Session session) {
		super(session);
	}

	@Override
	public void inGameControl() {
		ProposedCombination proposedCombination = new ProposedCombination();
		new ProposedCombinationView(proposedCombination).read();
		this.session.proposeCombination(proposedCombination);
		if (this.session.isWinner() || this.session.isLooser()) {
			this.session.next();
		}
	}

}
