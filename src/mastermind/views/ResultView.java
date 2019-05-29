package mastermind.views;

import java.util.List;

import mastermind.utils.WithConsoleView;

class ResultView extends WithConsoleView {

	void writeln(List<Integer> results) {
		this.console.writeln(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + results.get(0))
				.replaceFirst("#whites", "" + results.get(1)));
	}

}
