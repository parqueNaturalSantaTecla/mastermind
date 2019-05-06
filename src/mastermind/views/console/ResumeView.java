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
		boolean resume = new YesNoDialog().read(MessageView.RESUME.getMessage());
		if (resume) {
			this.game.clear();
		}
		return resume;
	}

}
