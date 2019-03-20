package mastermind.models.dataBase;

import mastermind.models.SecretCombination;

public class SecretCombinationDBDAO extends CombinationDBDAO {

	protected SecretCombinationDBDAO(SecretCombination secretCombination) {
		super(secretCombination);
	}

	public void load() {
		this.combination.clearColors();
		super.load();
	}

}
