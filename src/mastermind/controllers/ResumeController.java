package mastermind.controllers;

import mastermind.models.Session;
import mastermind.views.ResumeView;

public class ResumeController extends Controller {

	public ResumeController(Session session) {
		super(session);
	}

	void isNewGame(boolean newGame) {
		if (newGame) {
			this.session.isNewGame();
		} else {
			this.session.next();
		}
	}

	@Override
	public void control() {
		this.isNewGame(new ResumeView().write());
	}

}
