package mastermind.views;

import mastermind.controllers.GameController;
import mastermind.views.menus.MessageView;
import santaTecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {
	
	private GameController gameController;
	
	ResultView(GameController gameController){
		this.gameController = gameController;
	}

	void writeln(int position) {
		this.console.writeln(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.gameController.getBlacks(position))
				.replaceFirst("#whites", "" + this.gameController.getWhites(position)));
	}

}
