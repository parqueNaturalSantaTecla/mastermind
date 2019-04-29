package mastermind.views.graphics;

import javax.swing.JLabel;

import mastermind.views.MessageView;

@SuppressWarnings("serial")
class ResultView extends JLabel {

	ResultView(int[] results) {
		this.setText(MessageView.RESULT.getMessage().replaceFirst("#blacks", "" + results[0]).replaceFirst("#whites",
				"" + results[1]));
	}

}
