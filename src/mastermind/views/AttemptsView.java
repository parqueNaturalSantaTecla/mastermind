package mastermind.views;

import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

class AttemptsView extends WithConsoleView{
	
	void writeln(int attempts) {
		this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts", "" + attempts));
	}

}
