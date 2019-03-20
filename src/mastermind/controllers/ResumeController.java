package mastermind.controllers;

import mastermind.distributed.FrameType;
import mastermind.models.Session;
import mastermind.utils.TCPIP;

public class ResumeController extends AcceptorController {

	public ResumeController(Session session, TCPIP tcpip) {
		super(session, tcpip);
	}

	public void resume(boolean resume) {
		if (this.tcpip == null) {
			if (resume) {
				this.session.resume();
			} else {
				this.session.next();
			}
		} else {
			this.tcpip.send(FrameType.RESUME.name());
			this.tcpip.send(resume);
		}
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
