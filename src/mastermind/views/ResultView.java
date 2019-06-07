package mastermind.views;

import mastermind.controllers.PlayController;
import santaTecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {
	
	private PlayController playController;
	
	ResultView(PlayController playController){
		this.playController = playController;
	}

	void writeln(int position) {
		this.console.writeln(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.playController.getBlacks(position))
				.replaceFirst("#whites", "" + this.playController.getWhites(position)));
	}

}
