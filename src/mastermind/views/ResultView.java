package mastermind.views;

public class ResultView extends WithConsoleView {

	private static final String MESSAGES = "-> #blacks negros y #whites blancos";

	public void writeln(int[] results) {
		this.console.writeln(MESSAGES.replaceFirst("#blacks", "" + results[0])
										.replaceFirst("#whites", "" + results[1]));
	}

}
