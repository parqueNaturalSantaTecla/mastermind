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
		boolean answer = new YesNoDialog().read(MessageView.RESUME.getMessage());
		if (answer) {
			this.game.clear();
		}
		return answer;
	}

}
