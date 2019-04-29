package mastermind.views.graphics;

import javax.swing.JLabel;

import mastermind.models.Result;
import mastermind.views.MessageView;

@SuppressWarnings("serial")
class ResultView extends JLabel {
	
	private Result result;

	ResultView(Result result) {
		this.setText(MessageView.RESULT.getMessage().replaceFirst("#blacks", "" + this.result.getBlacks())
				.replaceFirst("#whites", "" + this.result.getWhites()));
	}

}
