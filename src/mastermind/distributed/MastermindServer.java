package mastermind.distributed;

import mastermind.distributed.dispatchers.DispatcherPrototype;
import mastermind.models.DAO.SessionImplementationDAO;

public abstract class MastermindServer {

	private DispatcherPrototype dispatcherPrototype;

	private LogicImplementationServer logic;

	protected MastermindServer() {
		this.dispatcherPrototype = new DispatcherPrototype();
		this.logic = new LogicImplementationServer(this.createDAO());
		this.logic.createDispatchers(this.dispatcherPrototype);
	}

	protected void serve() {
		this.dispatcherPrototype.serve();
	}

	protected abstract SessionImplementationDAO createDAO();

}
