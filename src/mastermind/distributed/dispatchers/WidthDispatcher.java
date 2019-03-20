package mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;

public class WidthDispatcher extends Dispatcher {

	public WidthDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(this.acceptorController.getWidth());
	}

}
