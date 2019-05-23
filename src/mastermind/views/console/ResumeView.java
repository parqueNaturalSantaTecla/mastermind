package mastermind.views.console;

import mastermind.models.Game;
import mastermind.utils.YesNoDialog;
import mastermind.views.MessageView;

class ResumeView {
	
	private Game game;
	
	ResumeView (Game game){
		this.game = game;
	}

	boolean interact() {
		boolean newGame = new YesNoDialog().read(MessageView.RESUME.getMessage());
		if (newGame) {
			this.game.clear();
		}
		return newGame;
	}

}
