package mastermind.controllers;

import mastermind.models.Session;
import mastermind.utils.TCPIP;

public abstract class AcceptorController extends Controller {
	
	protected TCPIP tcpip;

	AcceptorController(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	public abstract void accept(ControllersVisitor controllersVisitor);

}
