package mastermind.views;

import mastermind.models.Result;
import santaTecla.utils.WithConsoleView;

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
