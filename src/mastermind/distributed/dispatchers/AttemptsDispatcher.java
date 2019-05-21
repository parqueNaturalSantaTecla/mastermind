package mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;

public class AttemptsDispatcher extends Dispatcher {

	public AttemptsDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController)this.acceptorController).getAttempts());
	}

}
