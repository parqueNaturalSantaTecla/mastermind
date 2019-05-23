package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class BlacksDispatcher extends Dispatcher {

	public BlacksDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		int position = this.tcpip.receiveInt();
		this.tcpip.send(((PlayControllerImplementation)this.acceptorController).getBlacks(position));
	}

}
