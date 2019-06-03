package mastermind.views.console;

import mastermind.controllers.Logic;
import mastermind.utils.YesNoDialog;
import mastermind.views.MessageView;

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
