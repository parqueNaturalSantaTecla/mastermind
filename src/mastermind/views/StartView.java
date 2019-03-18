package mastermind.views;

import mastermind.controllers.StartController;
import mastermind.utils.WithConsoleView;

class StartView extends WithConsoleView {

	void interact(StartController startController) {
		this.console.writeln(Message.TITLE.getMessage());
		new StartMenu(startController).execute();
		new GameView(startController).writeln();
	}

}
