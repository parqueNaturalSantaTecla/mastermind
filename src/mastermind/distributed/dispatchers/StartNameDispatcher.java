package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.StartControllerImplementation;

public class StartNameDispatcher extends Dispatcher {

	public StartNameDispatcher(StartControllerImplementation startControllerImplementation) {
		super(startControllerImplementation);
	}

	@Override
	public void dispatch() {
		String title = this.tcpip.receiveLine();
		((StartControllerImplementation) this.acceptorController).start(title);
	}

}
