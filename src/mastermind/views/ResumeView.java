package mastermind.views;

import mastermind.models.Game;
import mastermind.utils.YesNoDialog;

class ResumeView {

	boolean interact(Game game) {
		MessageView.RESUME.write();
		boolean resume = new YesNoDialog().read();
		if (resume) {
			game.clear();
		}
		return resume;
	}

}
