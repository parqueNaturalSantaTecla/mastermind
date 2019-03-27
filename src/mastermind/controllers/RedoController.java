package mastermind.controllers;

import mastermind.models.Session;

class RedoController extends InGameController {

	RedoController(Session session) {
		super(session);
	}

	boolean redoable() {
		return this.session.redoable();
	}

	@Override
	public void inGameControl() {
		this.session.redo();
	}

}
