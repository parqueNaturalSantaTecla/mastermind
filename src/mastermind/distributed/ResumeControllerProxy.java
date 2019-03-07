package mastermind.distributed;

import mastermind.controllers.ResumeController;
import mastermind.models.Session;
import mastermind.utils.TCPIP;

public class ResumeControllerProxy extends ResumeController {
	
	private TCPIP tcpip;

	public ResumeControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void resume(boolean resume) {
		this.tcpip.send(FrameType.RESUME.name());
		this.tcpip.send(resume);	
	}

}
