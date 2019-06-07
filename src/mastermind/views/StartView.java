package mastermind.views;

import mastermind.controllers.StartController;
import mastermind.views.menus.MessageView;
import mastermind.views.menus.StartMenu;

class StartView {
	
	void interact(StartController startController) {
		MessageView.TITLE.writeln();
		new StartMenu(startController).execute();
		new GameView(startController).writeln();
	}

}
