package mastermind.distributed;

import mastermind.distributed.dispatchers.DispatcherPrototype;

public class MastermindServer {

	private DispatcherPrototype dispatcherPrototype;

	private LogicServer logic;

	private MastermindServer() {
		this.dispatcherPrototype = new DispatcherPrototype();
		this.logic = new LogicServer(true);
		this.logic.createDispatchers(this.dispatcherPrototype);
	}

	private void serve() {
		this.dispatcherPrototype.serve();
	}

	public static void main(String[] args) {
		new MastermindServer().serve();
	}

}
