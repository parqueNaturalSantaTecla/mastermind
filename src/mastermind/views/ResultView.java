package mastermind.views;

import java.util.List;

class ResultView {

	void writeln(List<Integer> results) {
		MessageView.RESULT.writeln(results.get(0), results.get(1));
	}

}
