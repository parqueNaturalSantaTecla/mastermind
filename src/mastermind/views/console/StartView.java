package mastermind.views.console;

import mastermind.controllers.StartController;
import mastermind.utils.WithConsoleView;
import mastermind.views.Message;

class StartView extends WithConsoleView {

	void interact(StartController startController) {
		this.console.writeln(Message.TITLE.getMessage());
		new StartMenu(startController).execute();
		new GameView(startController).writeln();
	}

}
