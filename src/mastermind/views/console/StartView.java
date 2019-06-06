package mastermind.views.console;

import mastermind.controllers.Logic;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

class StartView extends WithConsoleView {
	
	private Logic logic;
	
	private SecretCombinationView secretCombinationView;
	
	StartView (Logic logic){
		this.logic = logic;
		this.secretCombinationView = new SecretCombinationView(this.logic);
	}

	void interact() {
		this.console.writeln(MessageView.TITLE.getMessage());
		this.secretCombinationView.writeln();
	}

}
