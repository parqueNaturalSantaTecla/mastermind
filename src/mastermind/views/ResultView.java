package mastermind.views;

import mastermind.models.Result;
import santaTecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {

	void writeln(Result result) {
		MessageView.RESULT.writeln(result.getBlacks(), result.getWhites());
	}

}
