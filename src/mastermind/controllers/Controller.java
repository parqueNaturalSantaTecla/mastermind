package mastermind.controllers;

import mastermind.models.Game;

public abstract class Controller {

	protected Game game;
	
	protected State state;

	Controller(Game game, State state) {
		this.game = game;
		this.state = state;
	}
	
	public int getWidth() {
		return game.getWidth();
	}

	public abstract void accept(ControllerVisitor controllerVisitor);

}
