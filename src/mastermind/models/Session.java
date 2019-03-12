package mastermind.models;

import mastermind.controllers.StateValue;

public interface Session {

	StateValue getValueState();
	
	int getWidth();
	
	String getName();
	
	void setName(String title);
	
}
