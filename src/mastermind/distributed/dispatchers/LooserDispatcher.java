package mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;

public class LooserDispatcher extends Dispatcher {

	public LooserDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController)this.acceptorController).isLooser());
	}

}
