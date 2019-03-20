package mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;

public class RedoableDispatcher extends Dispatcher {

	public RedoableDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController)this.acceptorController).redoable());
	}

}
