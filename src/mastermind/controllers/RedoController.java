package mastermind.controllers;

import mastermind.models.Session;
import mastermind.models.SessionImplementation;

public class RedoController extends Controller {

	public RedoController(Session session) {
		super(session);
	}

	public void redo() {
		((SessionImplementation) this.session).redo();
	}

	public boolean redoable() {
		return ((SessionImplementation) this.session).redoable();
	}

}
