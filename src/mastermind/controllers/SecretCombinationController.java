package mastermind.controllers;

import mastermind.models.SecretCombination;
import mastermind.views.SecretCombinationView;

public class SecretCombinationController {
	
	private SecretCombination secretCombination;
	
	private SecretCombinationView secretCombinationView;
	
	public SecretCombinationController() {
		this.secretCombination = new SecretCombination();
		this.secretCombinationView = new SecretCombinationView(this.secretCombination);
	}

	public SecretCombination getSecretCombination() {
		return this.secretCombination;
	}

	

}
