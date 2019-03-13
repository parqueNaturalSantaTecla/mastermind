package mastermind.views.console;

import mastermind.models.Game;
import mastermind.utils.YesNoDialog;
import mastermind.views.Message;

class ResumeView {

	boolean interact(Game game) {
		boolean resume = new YesNoDialog().read(Message.RESUME.getMessage());
		if (resume) {
			game.clear();
		}
		return resume;
	}

}
