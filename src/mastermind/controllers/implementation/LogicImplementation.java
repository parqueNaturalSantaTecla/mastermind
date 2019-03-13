package mastermind.controllers.implementation;

import mastermind.controllers.Logic;
import mastermind.controllers.StateValue;
import mastermind.models.SessionImplementation;

public class LogicImplementation extends Logic {

	protected StartControllerImplementation startControllerImplementation;

	protected PlayControllerImplementation playControllerImplementation;

	protected SaveControllerImplementation saveControllerImplementation;

	protected ResumeControllerImplementation resumeControllerImplementation;

	public LogicImplementation() {
		this.session = new SessionImplementation();
		this.startControllerImplementation = new StartControllerImplementation(this.session);
		this.playControllerImplementation = new PlayControllerImplementation(this.session);
		this.saveControllerImplementation = new SaveControllerImplementation(this.session);
		this.resumeControllerImplementation = new ResumeControllerImplementation(this.session);
		this.acceptorControllers.put(StateValue.INITIAL, this.startControllerImplementation);
		this.acceptorControllers.put(StateValue.IN_GAME, this.playControllerImplementation);
		this.acceptorControllers.put(StateValue.SAVING, this.saveControllerImplementation);
		this.acceptorControllers.put(StateValue.FINAL, this.resumeControllerImplementation);
		this.acceptorControllers.put(StateValue.EXIT, null);
	}

}
