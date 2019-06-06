package mastermind.views.console;

import mastermind.controllers.Logic;
import mastermind.views.MessageView;
import santaTecla.utils.YesNoDialog;

class ResumeView {
	
	private Logic logic;

	ResumeView(Logic logic) {
		this.logic = logic;
	}

	boolean interact() {
		boolean newGame = new YesNoDialog().read(MessageView.RESUME.getMessage());
		if (newGame) {
			this.logic.clearGame();			
		}
		return newGame;
	}

}
