package mastermind.models.DAO;

import java.io.BufferedReader;

import mastermind.models.SecretCombination;

class SecretCombinationDAO extends CombinationDAO{
	
	SecretCombinationDAO(SecretCombination secretCombination) {
		super(secretCombination);
	}
	
	public void load(BufferedReader bufferedReader) {
		this.combination.clearColors();
		super.load(bufferedReader);
		System.out.println("SC.load(): " + this.combination.toString());
		System.out.println(this.combination.hashCode());
	}

}
