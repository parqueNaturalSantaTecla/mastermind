package mastermind.views.console;

import mastermind.models.Result;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

class ResultView extends WithConsoleView {

	private Result result;

	public ResultView(Result result) {
		this.result = result;
	}

	void writeln() {
		this.console.writeln(MessageView.RESULT.getMessage().replaceFirst("#blacks", "" + this.result.getBlacks())
				.replaceFirst("#whites", "" + this.result.getWhites()));
	}

}
