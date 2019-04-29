package mastermind.views.console;

import mastermind.models.Combination;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

class SecretCombinationView extends WithConsoleView {

	SecretCombinationView() {
		super();
	}

	void writeln() {
		for (int i = 0; i < Combination.getWidth(); i++) {
			this.console.write(MessageView.SECRET.getMessage());
		}
		this.console.writeln();
	}

}
