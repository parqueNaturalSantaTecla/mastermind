package mastermind.views;

import mastermind.models.SecretCombination;

public class SecretCombinationView {

	private SecretCombination secretCombination;

	public SecretCombinationView(SecretCombination secretCombination) {
		this.secretCombination = secretCombination;
	}

	void writeln() {
		for (int i = 0; i < this.secretCombination.getColors().size(); i++) {
			MessageView.SECRET.write();
		}
		MessageView.NEW_LINE.writeln();
	}

}
