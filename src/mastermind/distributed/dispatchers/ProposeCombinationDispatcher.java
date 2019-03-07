package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class ProposeCombinationDispatcher extends Dispatcher {

	public ProposeCombinationDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		int length = this.tcpip.receiveInt();
		int[] codes = new int[length];
		for (int i=0; i<length; i++) {
			codes[i] = this.tcpip.receiveInt();
		}
		this.tcpip.send(((PlayControllerImplementation) this.acceptorController).proposeCombination(codes));
	}

}
