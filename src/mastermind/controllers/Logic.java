package mastermind.controllers;

import java.util.HashMap;
import java.util.Map;
import mastermind.models.Session;
import mastermind.models.StateValue;

public class Logic {

	protected Session session;

	protected Map<StateValue, AcceptorController> acceptorControllers;

	protected Logic() {
		this.acceptorControllers = new HashMap<StateValue, AcceptorController>();
	}

	public AcceptorController getController() {
		return this.acceptorControllers.get(this.session.getValueState());
	}

}
