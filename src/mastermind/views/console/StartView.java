package mastermind.views.console;

import mastermind.controllers.Logic;
import mastermind.utils.WithConsoleView;
import mastermind.views.Message;

class StartView extends WithConsoleView {

	void interact(Logic logic) {
		this.console.writeln(Message.TITLE.getMessage());
		new SecretCombinationView().writeln(logic.getWidth());
	}

}
