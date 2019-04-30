package mastermind.views.console;

import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

class StartView extends WithConsoleView {

	void interact() {
		this.console.writeln(MessageView.TITLE.getMessage());
		new SecretCombinationView().writeln();
	}

}
