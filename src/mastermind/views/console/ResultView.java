package mastermind.views.console;

import mastermind.controllers.Logic;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {

	private Logic logic;

	ResultView(Logic logic) {
		this.logic = logic;
	}

	void writeln(int i) {
		this.console.writeln(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.logic.getBlacks(i))
						.replaceFirst("#whites", "" + this.logic.getWhites(i)));
	}

}
