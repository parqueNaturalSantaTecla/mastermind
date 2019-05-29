package mastermind.views;

import mastermind.utils.WithConsoleView;

class SecretCombinationView extends WithConsoleView {
	
	SecretCombinationView() {
		super();
	}
	
	void writeln(int length) {
		for (int i = 0; i < length; i++) {
			this.console.write(MessageView.SECRET.getMessage());
		}
		this.console.writeln();
	}
	
}
