package mastermind;

import mastermind.controllers.AcceptorController;
import mastermind.controllers.Logic;
import mastermind.views.View;

public abstract class Mastermind {
	
	private Logic logic;
	
	private View view;
	
	protected Mastermind() {
		this.logic = this.createLogic();
		this.view = this.createView();
	}
	
	protected abstract Logic createLogic();

	protected abstract View createView();

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

