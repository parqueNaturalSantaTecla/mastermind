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
		boolean resume = new YesNoDialog().read();
		if (resume) {
			this.game.clear();
		}
		return resume;
	}

}
