package mastermind.controllers;

import mastermind.models.ProposedCombination;
import mastermind.views.ProposedCombinationView;

public class ProposedCombinationController {
	
	private ProposedCombinationView proposedCombinationView;
	
	private ProposedCombination proposedCombination;
	
	public ProposedCombinationController() {
		this.proposedCombination = new ProposedCombination();
		this.proposedCombinationView = new ProposedCombinationView(this.proposedCombination);
	}

	public void proposeCombination() {
		this.proposedCombinationView.read();
	}

	public ProposedCombination getProposeCombination() {
		return this.proposedCombination;
	}

	public ProposedCombinationView getProposeCombinationView() {
		return this.proposedCombinationView;
	}

}
