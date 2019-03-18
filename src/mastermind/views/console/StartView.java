package mastermind.views.console;

import mastermind.controllers.Controller;
import mastermind.utils.WithConsoleView;
import mastermind.views.Message;

class StartView extends WithConsoleView {

	void interact() {
		this.console.writeln(Message.TITLE.getMessage());
		new SecretCombinationView().writeln(Controller.getWidth());
	}

}
