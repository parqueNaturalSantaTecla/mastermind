package mastermind.views;

import mastermind.controllers.StartController;
import mastermind.menus.StartMenu;
import santaTecla.utils.WithConsoleView;

class StartView extends WithConsoleView {

	void interact(StartController startController) {
		this.console.writeln(MessageView.TITLE.getMessage());
		new StartMenu(startController).execute();
		new GameView(startController).writeln();
	}

}
