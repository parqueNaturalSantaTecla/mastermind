package mastermind.controllers;

import mastermind.models.Session;

class RedoController extends InGameController {

	RedoController(Session session) {
		super(session);
	}

	@Override
	public void inGameControl() {
		this.session.redo();
	}

}
