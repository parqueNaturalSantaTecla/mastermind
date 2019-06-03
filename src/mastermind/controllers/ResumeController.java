package mastermind.controllers;

import mastermind.distributed.FrameType;
import mastermind.models.Session;
import mastermind.utils.TCPIP;

public class ResumeController extends AcceptorController {

	public ResumeController(Session session, TCPIP tcpip) {
		super(session, tcpip);
	}

	public void clearGame(boolean newGame) {
		if (this.tcpip == null) {
			if (newGame) {
				this.session.clearGame();
			} else {
				this.session.next();
			}
		} else {
			this.tcpip.send(FrameType.NEW_GAME.name());
			this.tcpip.send(newGame);
		}
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
