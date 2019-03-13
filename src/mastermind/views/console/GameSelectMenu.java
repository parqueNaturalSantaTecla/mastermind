package mastermind.views.console;

import mastermind.controllers.StartController;
import mastermind.utils.Menu;

public class GameSelectMenu extends Menu {

	public GameSelectMenu(StartController startController) {
		String[] gamesNames = startController.getGamesNames();
		for (String title : gamesNames) {
			this.addCommand(new GameSelectCommand(title, startController));
		}
	}

}
