package mastermind.views.graphics;

import javax.swing.JLabel;

import mastermind.views.Message;

@SuppressWarnings("serial")
class TurnView extends JLabel {

	TurnView(int turn) {
		this.setText(Message.TURN.getMessage().replaceFirst("#turn", "" + (turn)));
	}

}
