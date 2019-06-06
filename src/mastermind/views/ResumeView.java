package mastermind.views;

import mastermind.models.Game;
import santaTecla.utils.YesNoDialog;

class ResumeView {

	boolean interact(Game game) {
		MessageView.RESUME.write();
		boolean newGame = new YesNoDialog().read();
		if (newGame) {
			game.clear();
		}
		return newGame;
	}

}
