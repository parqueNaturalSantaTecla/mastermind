package mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import mastermind.models.Game;
import mastermind.models.Session;

public class Logic {
	
//	private State state;
//	
//	private Game game;
	
	private Session session;
	
	private Map<StateValue, AcceptorController> acceptorControllers;
		
	public Logic() {
//		this.state = new State();
//		this.game = new Game();
		this.session = new Session();
		this.acceptorControllers = new HashMap<StateValue, AcceptorController>();
//		this.acceptorControllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
//		this.acceptorControllers.put(StateValue.IN_GAME, new PlayController(this.game, this.state));
//		this.acceptorControllers.put(StateValue.FINAL, new ResumeController(this.game, this.state));
		this.acceptorControllers.put(StateValue.INITIAL, new StartController(this.session));
		this.acceptorControllers.put(StateValue.IN_GAME, new PlayController(this.session));
		this.acceptorControllers.put(StateValue.FINAL, new ResumeController(this.session));
		this.acceptorControllers.put(StateValue.EXIT, null);
	}
	
	public AcceptorController getController() {
		return this.acceptorControllers.get(this.session.getValueState());
	}
	
}
