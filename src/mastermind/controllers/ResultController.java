package mastermind.controllers;

import mastermind.models.Result;
import mastermind.views.ResultView;

public class ResultController {
	
	private Result result;
	
	private ResultView resultView;

	public ResultController(Result result) {
		this.result = result;
		this.resultView = new ResultView(this.result);
	}

	public ResultView getResultView() {
		return this.resultView;
	}
	
	public Result getResult() {
		return this.result;
	}

}
