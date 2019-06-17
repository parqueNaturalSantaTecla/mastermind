package mastermind.views;

import mastermind.models.Result;

class ResultView {

	private Result result;

	public ResultView(Result result) {
		this.result = result;
	}

	void writeln() {
		MessageView.RESULT.writeln(this.result.getBlacks(), this.result.getWhites());
	}

}
