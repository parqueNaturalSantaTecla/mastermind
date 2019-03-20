package mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;

public class RedoDispatcher extends Dispatcher {

	public RedoDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		((PlayController)this.acceptorController).redo();
	}

}
