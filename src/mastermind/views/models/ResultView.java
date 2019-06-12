package mastermind.views.models;

import mastermind.controllers.GameController;

class ResultView {
	
	private GameController gameController;
	
	ResultView(GameController gameController){
		this.gameController = gameController;
	}

	void writeln(int position) {
		MessageView.RESULT.writeln(this.gameController.getBlacks(position),this.gameController.getWhites(position));
	}

}
