package mastermind.controllers;

public class State {

	private StateValue stateValue;

	public State() {
		this.reset();
	}

	public void next() {
		this.stateValue = StateValue.values()[this.stateValue.ordinal() + 1];
	}

	public void reset() {
		this.stateValue = StateValue.INITIAL;
	}

	public void setStateValue(StateValue stateValue) {
		this.stateValue = stateValue;
	}

	public StateValue getValueState() {
		return this.stateValue;
	}

}
