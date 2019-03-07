package mastermind.controllers.implementation;

import mastermind.controllers.StartController;
import mastermind.models.Session;
import mastermind.models.SessionImplementation;

public class StartControllerImplementation extends StartController {

	public StartControllerImplementation(Session session) {
		super(session);
	}

	@Override
	public void start() {
		((SessionImplementation) this.session).next();		
	}

}
