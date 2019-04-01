package mastermind.views;

import mastermind.models.Session;
import mastermind.utils.WithConsoleView;

public class GameView extends WithConsoleView {
	
	private Session session;

	public GameView(Session session) {
		this.session = session;
	}

	public void writeGame() {
		this.console.writeln();
		this.console.writeln(Message.TURN.getMessage().replaceFirst("#turn", "" + this.session.getTurn()));
		new SecretCombinationView().writeln(this.session.getWidth());
		for (int i = 0; i < this.session.getCodes().length; i++) {
			new ProposedCombinationView().write(this.session.getCodes()[i][0]);
			new ResultView().writeln(this.session.getCodes()[i][1]);
		}
	}

	public void writeLooser() {
		this.console.writeln(Message.LOOSER.getMessage());
	}

	public void writeWinner() {
		this.console.writeln(Message.WINNER.getMessage());
	}

}
