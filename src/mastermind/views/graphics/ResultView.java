package mastermind.views.graphics;

import javax.swing.JLabel;

import mastermind.models.Result;
import mastermind.views.MessageView;

@SuppressWarnings("serial")
class ResultView extends JLabel {

	ResultView(Result result) {
		this.setText(MessageView.RESULT.getMessage().replaceFirst("#blacks", "" + result.getBlacks())
				.replaceFirst("#whites", "" + result.getWhites()));
	}

}
