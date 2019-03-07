package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class AllCodesDispatcher extends Dispatcher {

	public AllCodesDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		int[][][] codes = ((PlayControllerImplementation) this.acceptorController).getAllCodes();
		this.tcpip.send(codes.length);
		if (codes.length != 0) {
			this.tcpip.send(codes[0].length);
			this.tcpip.send(codes[0][0].length);
			for (int i = 0; i < codes.length; i++) {
				for (int j = 0; j < codes[i].length; j++) {
					for (int k = 0; k < codes[i][j].length; k++) {
						this.tcpip.send(codes[i][j][k]);
					}
				}
			}
		}
	}

}
