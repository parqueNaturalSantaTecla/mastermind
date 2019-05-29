package mastermind.views;

import mastermind.utils.WithConsoleView;

public class StartView extends WithConsoleView {

	public void write(int width) {
		this.console.writeln(MessageView.TITLE.getMessage());
		new SecretCombinationView().writeln(width);
	}

}
