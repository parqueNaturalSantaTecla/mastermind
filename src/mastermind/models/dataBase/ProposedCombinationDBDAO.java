package mastermind.models.dataBase;

import mastermind.models.Combination;
import mastermind.models.ProposedCombination;

public class ProposedCombinationDBDAO extends CombinationDBDAO {

	public ProposedCombinationDBDAO(Combination combination) {
		super(combination);
	}

	public ProposedCombination getProposedCombination() {
		return (ProposedCombination) this.combination;
	}

}
