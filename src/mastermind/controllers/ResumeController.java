package mastermind.controllers;

import mastermind.models.Session;
import mastermind.views.ResumeView;

public class ResumeController extends Controller {

	public ResumeController(Session session) {
		super(session);
	}

	public void resume(boolean resume) {
		if (resume) {
			this.session.resume();
		} else {
			this.session.next();
		}
	}

	@Override
	public void control() {
		this.resume(new ResumeView().write());
	}

}
