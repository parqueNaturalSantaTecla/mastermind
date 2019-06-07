package mastermind.controllers;

import mastermind.distributed.FrameType;
import mastermind.models.Session;
import santaTecla.utils.TCPIP;

public class StartController extends AcceptorController {

	public StartController(Session session, TCPIP tcpip) {
		super(session, tcpip);
	}
	
	public void start() {
		if (this.tcpip == null) {
			this.session.next();	
		} else {
			this.tcpip.send(FrameType.START.name());
		}
	}
	
	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
