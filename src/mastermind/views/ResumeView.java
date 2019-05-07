package mastermind.views;

import mastermind.models.Game;
import mastermind.utils.YesNoDialog;

class ResumeView {

	private Game game;

	ResumeView(Game game) {
		this.game = game;
	}

	boolean interact() {
		MessageView.RESUME.write();
		boolean answer = new YesNoDialog().read();
		if (answer) {
			this.game.clear();
		}
		return answer;
	}

}
