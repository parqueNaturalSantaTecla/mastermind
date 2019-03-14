package mastermind.views.graphics;

import javax.swing.JLabel;

import mastermind.views.Message;

@SuppressWarnings("serial")
class ResultView extends JLabel {

	ResultView(int[] results) {
		this.setText(Message.RESULT.getMessage().replaceFirst("#blacks", "" + results[0]).replaceFirst("#whites",
				"" + results[1]));
	}

}
