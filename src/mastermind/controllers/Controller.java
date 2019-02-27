package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.Session;

public abstract class Controller {

//	protected Game game;
//	
//	protected State state;
	
	protected Session session;

	Controller(Session session) {
		this.session = session;
	}
	
	public int getWidth() {
		return this.session.getWidth();
	}

}
