package mastermind.controllers;

import mastermind.models.Session;

public abstract class StartController extends AcceptorController {

	public StartController(Session session) {
		super(session);
	}
	
	public abstract void start();
	
	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
