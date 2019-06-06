package mastermind.views.console;

import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

class StartView extends WithConsoleView {

	void interact() {
		this.console.writeln(MessageView.TITLE.getMessage());
		new SecretCombinationView().writeln();
	}

}
