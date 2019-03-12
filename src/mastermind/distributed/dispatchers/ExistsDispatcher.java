package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.SaveControllerImplementation;

public class ExistsDispatcher extends Dispatcher {

	public ExistsDispatcher(SaveControllerImplementation saveControllerImplementation) {
		super(saveControllerImplementation);
	}

	@Override
	public void dispatch() {
		String name = this.tcpip.receiveLine();
		this.tcpip.send(((SaveControllerImplementation) this.acceptorController).exists(name));
	}

}
