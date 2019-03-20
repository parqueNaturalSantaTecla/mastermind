package mastermind.models.Files;

import mastermind.models.ProposedCombination;

public class ProposedCombinationFileDAO extends CombinationFileDAO{
	
	ProposedCombinationFileDAO(ProposedCombination proposedCombination){
		super(proposedCombination);
	}

	public ProposedCombination getProposedCombination() {
		return (ProposedCombination) this.combination;
	}

}
