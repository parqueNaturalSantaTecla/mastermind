package mastermind.views.console;

import mastermind.models.Game;
import mastermind.views.MessageView;
import santaTecla.utils.YesNoDialog;

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
