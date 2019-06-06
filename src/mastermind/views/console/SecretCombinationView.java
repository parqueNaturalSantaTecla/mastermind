package mastermind.views.console;

import mastermind.controllers.Logic;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

class SecretCombinationView extends WithConsoleView {
	
	private Logic logic;
	
	SecretCombinationView (Logic logic){
		this.logic = logic;
	}
	
	void writeln() {
		for (int i = 0; i < this.logic.getWidth(); i++) {
			this.console.write(MessageView.SECRET.getMessage());
		}
		this.console.writeln();
	}
	
}
