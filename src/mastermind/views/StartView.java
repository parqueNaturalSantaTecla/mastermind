package mastermind.views;

import mastermind.models.Session;
import mastermind.utils.WithConsoleView;

public class StartView extends WithConsoleView {

	private Session session;
	
	public StartView(Session session) {
		this.session = session;
	}
	
	public void write() {
		this.console.writeln(Message.TITLE.getMessage());
		new SecretCombinationView().writeln(this.session.getWidth());
	}

}
