package mastermind.views;

import mastermind.models.Game;
import mastermind.mvcUtils.Event;
import mastermind.mvcUtils.GameEvent;
import mastermind.mvcUtils.Observed;
import mastermind.mvcUtils.Observer;
import mastermind.utils.WithConsoleView;

public class GameView extends WithConsoleView implements Observer{
	
	private Game game;

	public GameView(Game game) {
		this.game = game;
	}

	public void writeGame() {
		this.console.writeln();
		this.console.writeln(Message.TURN.getMessage().replaceFirst("#turn", "" + this.game.getTurn()));
		new SecretCombinationView(this.game.getSecretCombination()).writeln();
		for (int i = 0; i < this.game.getTurn(); i++) {
			new ProposedCombinationView(this.game.getProposedCombination(i)).write();
			new ResultView(this.game.getResultCombination(i)).writeln();
		}
	}

	public void writeLooser() {
		this.console.writeln(Message.LOOSER.getMessage());
	}

	public void writeWinner() {
		this.console.writeln(Message.WINNER.getMessage());
	}

	@Override
	public void update(Observed observed, Event event) {
		if (event instanceof GameEvent) {
			this.writeGame();
		}
	}

}
