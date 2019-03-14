package mastermind.views.console;

import mastermind.utils.WithConsoleView;
import mastermind.views.Message;

class SecretCombinationView extends WithConsoleView {

	SecretCombinationView() {
		super();
	}

	void writeln(int length) {
		for (int i = 0; i < length; i++) {
			this.console.write(Message.SECRET.getMessage());
		}
		this.console.writeln();
	}

}
