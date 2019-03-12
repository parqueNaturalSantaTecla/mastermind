package mastermind.views.console;

import mastermind.controllers.StartController;
import mastermind.utils.Menu;

public class GameSelectMenu extends Menu{

	public GameSelectMenu(StartController startController) {
		String[] gamesNames = startController.getGamesNames();
		for (String title:gamesNames) {
			System.out.println("syso");
			this.addCommand(new GameSelectCommand(title, startController));
		}
	}

}
