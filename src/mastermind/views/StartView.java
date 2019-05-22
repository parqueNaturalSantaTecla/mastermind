package mastermind.views;

import mastermind.controllers.StartController;
import mastermind.utils.WithConsoleView;
import mastermind.views.menus.MessageView;
import mastermind.views.menus.StartMenu;

class StartView extends WithConsoleView {
	
	void interact(StartController startController) {
		this.console.writeln(MessageView.TITLE.getMessage());
		new StartMenu(startController).execute();
		new GameView(startController).writeln();
	}

}
