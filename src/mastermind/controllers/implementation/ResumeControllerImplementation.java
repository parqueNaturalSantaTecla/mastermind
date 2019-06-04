package mastermind.controllers.implementation;

import mastermind.controllers.ResumeController;
import mastermind.models.Session;
import mastermind.models.SessionImplementation;

public class ResumeControllerImplementation extends ResumeController {

	public ResumeControllerImplementation(Session session) {
		super(session);
	}

	@Override
	public void resume(boolean newGame) {
		if (newGame) {
			((SessionImplementation) this.session).clearGame();
		} else {
			((SessionImplementation) this.session).next();
		}
	}

}
