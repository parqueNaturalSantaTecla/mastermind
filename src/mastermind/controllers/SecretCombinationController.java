package mastermind.controllers;

import mastermind.models.SecretCombination;
import mastermind.views.SecretCombinationView;

class SecretCombinationController {
	
	private SecretCombination secretCombination;
	
	private SecretCombinationView secretCombinationView;
	
	SecretCombinationController() {
		this.secretCombination = new SecretCombination();
		this.secretCombinationView = new SecretCombinationView(this.secretCombination);
	}

	SecretCombination getSecretCombination() {
		return this.secretCombination;
	}

	SecretCombinationView getSecretCombinationView() {
		return this.secretCombinationView;
	}

}
