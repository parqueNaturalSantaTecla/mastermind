package mastermind.views.graphics;

import javax.swing.JLabel;

import mastermind.views.MessageView;

@SuppressWarnings("serial")
class TurnView extends JLabel {

	TurnView(int turn) {
		this.setText(MessageView.TURN.getMessage().replaceFirst("#turn", "" + (turn)));
	}

}
