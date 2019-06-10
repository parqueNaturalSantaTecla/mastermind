package mastermind.menus;

import mastermind.controllers.AcceptorController;

abstract class Command extends santaTecla.utils.Command {

	protected AcceptorController acceptorController;

	protected Command(String title, AcceptorController acceptorController) {
		super(title);
		this.acceptorController = acceptorController;
	}
	
}
