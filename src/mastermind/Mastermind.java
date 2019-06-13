package mastermind;

import mastermind.controllers.AcceptorController;
import mastermind.controllers.Logic;
import mastermind.views.View;

public abstract class Mastermind {
	
	protected Logic logic;
	
	private View view;
	
	protected Mastermind() {
		this.view = new View();
	}

	protected void play() {
		AcceptorController acceptorController;
		do {
			acceptorController = this.logic.getController();
			if (acceptorController != null){
				this.view.interact(acceptorController);
			}
		} while (acceptorController != null); 
	}
	
}

