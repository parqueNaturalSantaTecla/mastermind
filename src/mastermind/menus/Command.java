package mastermind.menus;

import mastermind.controllers.AcceptorController;

abstract class Command extends mastermind.utils.Command {

	protected AcceptorController acceptorController;

	protected Command(String title, AcceptorController acceptorController) {
		super(title);
		this.acceptorController = acceptorController;
	}
	
}
