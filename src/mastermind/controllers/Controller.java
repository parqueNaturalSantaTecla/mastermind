package mastermind.controllers;

import mastermind.models.Game;

public abstract class Controller {

	protected Game game;
	
	protected State state;

	public Controller(Game game, State state) {
		this.game = game;
		this.state = state;
	}
	
	public int getMaxLength() {
		return game.getWidth();
	}

	public abstract void accept(ControllerVisitor controllerVisitor);

}
