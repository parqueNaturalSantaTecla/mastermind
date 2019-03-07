package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.StartControllerImplementation;

public class StartDispatcher extends Dispatcher {

	public StartDispatcher(StartControllerImplementation startControllerImplementation) {
		super(startControllerImplementation);
	}

	@Override
	public void dispatch() {
		((StartControllerImplementation) this.acceptorController).start();
	}

}
