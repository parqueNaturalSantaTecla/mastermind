package mastermind.views;

import mastermind.models.Game;
import mastermind.utils.YesNoDialog;

class ResumeView {

	boolean interact(Game game) {
		MessageView.RESUME.write();
		boolean answer = new YesNoDialog().read();
		if (answer) {
			game.clear();
		}
		return answer;
	}

}
