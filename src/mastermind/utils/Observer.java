package mastermind.utils;

import mastermind.events.Event;

public interface Observer {

	public void update(Observed observed, Event event);

}
