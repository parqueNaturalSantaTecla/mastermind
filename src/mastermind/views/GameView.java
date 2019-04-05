package mastermind.views;

import java.util.ArrayList;
import java.util.List;

import mastermind.models.Game;
import mastermind.mvcUtils.Event;
import mastermind.mvcUtils.UpdateGameEvent;
import mastermind.mvcUtils.Observed;
import mastermind.mvcUtils.Observer;
import mastermind.utils.WithConsoleView;

public class GameView extends WithConsoleView implements Observer {

	private Game game;

	private SecretCombinationView secretCombinationView;

	private List<ProposedCombinationView> proposedCombinationViews;

	private List<ResultView> resultViews;

	public GameView(Game game, SecretCombinationView secretCombinationView) {
		this.game = game;
		this.secretCombinationView = secretCombinationView;
		this.proposedCombinationViews = new ArrayList<ProposedCombinationView>();
		this.resultViews = new ArrayList<ResultView>();
	}

	public void writeGame() {
		this.console.writeln();
		this.console.writeln(Message.TURN.getMessage().replaceFirst("#turn", "" + this.game.getTurn()));
		this.secretCombinationView.writeln();
		for (mastermind.models.Color color : this.game.getSecretCombination().getColors()) {
			this.console.write(color.ordinal());
		}
		this.console.writeln();
		for (int i = 0; i < this.game.getTurn(); i++) {
			this.proposedCombinationViews.get(i).write();
			this.resultViews.get(i).writeln();
		}
	}

	@Override
	public void update(Observed observed, Event event) {
		if (event instanceof UpdateGameEvent) {
			this.writeGame();
		}
	}

	public void addProposedCombinationView(ProposedCombinationView proposeCombinationView) {
		this.proposedCombinationViews.add(proposeCombinationView);
	}

	public void addResultView(ResultView resultView) {
		this.resultViews.add(resultView);
	}

}
