package mastermind.views;

import mastermind.utils.WithConsoleView;

class ResultView extends WithConsoleView {

	void writeln(int[] results) {
		this.console.writeln(Message.RESULT.getMessage().replaceFirst("#blacks", "" + results[0])
				.replaceFirst("#whites", "" + results[1]));
	}

}
