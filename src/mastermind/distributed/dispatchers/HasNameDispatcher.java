package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.SaveControllerImplementation;

public class HasNameDispatcher extends Dispatcher {

	public HasNameDispatcher(SaveControllerImplementation saveControllerImplementation) {
		super(saveControllerImplementation);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((SaveControllerImplementation) this.acceptorController).hasName());
	}

}
