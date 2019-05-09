package mastermind.views.graphics;

import javax.swing.JLabel;

import mastermind.controllers.Logic;
import mastermind.views.MessageView;

@SuppressWarnings("serial")
class ResultView extends JLabel {
	
	private Logic logic;

	ResultView(Logic logic) {
		this.logic = logic;
		this.setText(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.logic.getBlacks(this.logic.getAttempts()-1))
				.replaceFirst("#whites", "" + this.logic.getWhites(this.logic.getAttempts()-1)));
	}
	
}
