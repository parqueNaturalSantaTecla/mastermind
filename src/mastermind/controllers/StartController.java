package mastermind.controllers;

import mastermind.models.Session;
import mastermind.views.StartView;

public class StartController extends Controller {

	public StartController(Session session) {
		super(session);
	}

	@Override
	public void control() {
		this.session.next();
		new StartView(this.session).write();
	}

}
