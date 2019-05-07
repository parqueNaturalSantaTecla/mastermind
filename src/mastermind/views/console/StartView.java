package mastermind.views.console;

import mastermind.controllers.StartController;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

class StartView extends WithConsoleView {
	
	private StartController startController;
	
	private SecretCombinationView secretCombinationView;
	
	StartView (StartController startController){
		this.startController = startController;
		this.secretCombinationView = new SecretCombinationView(this.startController);
	}

	void interact() {
		this.console.writeln(MessageView.TITLE.getMessage());
		this.secretCombinationView.writeln();
	}

}
