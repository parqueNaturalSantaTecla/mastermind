package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.Session;

public class StartController extends AcceptorController {

	public StartController(Session session) {
		super(session);
	}
	
	public void start() {
		this.session.next();
	}
	
	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
