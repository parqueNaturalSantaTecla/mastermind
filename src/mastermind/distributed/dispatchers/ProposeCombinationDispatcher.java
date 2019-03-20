package mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;

public class ProposeCombinationDispatcher extends Dispatcher {

	public ProposeCombinationDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		int length = this.tcpip.receiveInt();
		int[] codes = new int[length];
		for (int i=0; i<length; i++) {
			codes[i] = this.tcpip.receiveInt();
		}
		this.tcpip.send(((PlayController) this.acceptorController).proposeCombination(codes));
	}

}
