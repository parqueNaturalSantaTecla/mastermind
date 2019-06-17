package mastermind.views;

import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

class AttemptsView extends WithConsoleView{
	
	void writeln(int attempts) {
		this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts", "" + attempts));
	}

}
