package mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;

public class TurnDispatcher extends Dispatcher {

	public TurnDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController)this.acceptorController).getTurn());
	}

}
