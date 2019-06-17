package mastermind.controllers;

import mastermind.models.Session;
import mastermind.views.ResumeView;

public class ResumeController extends Controller {

	public ResumeController(Session session) {
		super(session);
	}

	private void resume(boolean newGame) {
		if (newGame) {
			this.session.clearGame();
		} else {
			this.session.next();
		}
	}

	@Override
	public void control() {
		this.resume(new ResumeView().write());
	}

}
