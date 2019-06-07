package mastermind.distributed;

import mastermind.controllers.StartController;
import mastermind.models.Session;
import santaTecla.utils.TCPIP;

public class StartControllerProxy extends StartController {
	
	private TCPIP tcpip;

	public StartControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void start() {
		this.tcpip.send(FrameType.START.name());
	}

}
