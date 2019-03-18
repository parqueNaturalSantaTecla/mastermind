package mastermind.views;

import mastermind.controllers.StartController;
import mastermind.utils.WithConsoleView;

class StartView extends WithConsoleView {
	
	void interact(StartController startController) {
		startController.start();
		this.console.writeln(Message.TITLE.getMessage());
		new SecretCombinationView().writeln(startController.getWidth());
	}

}
