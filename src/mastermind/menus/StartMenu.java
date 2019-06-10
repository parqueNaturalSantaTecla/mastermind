package mastermind.menus;

import mastermind.controllers.StartController;
import santaTecla.utils.Menu;

public class StartMenu extends Menu {

	public StartMenu(StartController startController) {
		this.addCommand(new NewGameCommand(startController));
		this.addCommand(new OpenGameCommand(startController));
	}
}
