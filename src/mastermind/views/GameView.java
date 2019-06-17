package mastermind.views;

import java.util.ArrayList;
import java.util.List;

import mastermind.events.UpdateGameEvent;
import mastermind.models.Game;
import santaTecla.utils.Event;
import santaTecla.utils.Observed;
import santaTecla.utils.Observer;

public class GameView implements Observer {

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

	void writeGame() {
		MessageView.NEW_LINE.writeln();
		new AttemptsView(this.game).writeln();
		this.secretCombinationView.writeln();
		MessageView.NEW_LINE.writeln();
		for (int i = 0; i < this.proposedCombinationViews.size(); i++) {
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

	public void reset(List<ProposedCombinationView> proposedCombinationViews, List<ResultView> resultViews) {
		this.proposedCombinationViews = proposedCombinationViews;
		this.resultViews = resultViews;
		this.writeGame();
	}

	public void addProposedCombinationView(ProposedCombinationView proposeCombinationView) {
		this.proposedCombinationViews.add(proposeCombinationView);
	}

	public void addResultView(ResultView resultView) {
		this.resultViews.add(resultView);
	}

}
