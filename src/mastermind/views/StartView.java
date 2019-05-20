package mastermind.views;

import mastermind.controllers.StartController;
import mastermind.utils.WithConsoleView;

class StartView extends WithConsoleView {
	
	private SecretCombinationView secretCombinationView;
	
	void interact(StartController startController) {
		startController.start();
		this.console.writeln(MessageView.TITLE.getMessage());
		this.secretCombinationView = new SecretCombinationView(startController);
		this.secretCombinationView.writeln();
	}

}
