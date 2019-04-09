package mastermind.models;

public interface Session {

	StateValue getValueState();

	int getWidth();

	String getName();

	void setName(String name);

}
