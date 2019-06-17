package mastermind.views;

import mastermind.models.SecretCombination;

class SecretCombinationView {
	
	private SecretCombination secretCombination;
	
	SecretCombinationView(SecretCombination secretCombination) {
		this.secretCombination = secretCombination;
	}

	void writeln() {
		for (int i = 0; i < this.secretCombination.getColors().size(); i++) {
			MessageView.SECRET.write();
		}
		MessageView.NEW_LINE.writeln();
	}
	
}
