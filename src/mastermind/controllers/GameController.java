package mastermind.controllers;

import java.util.ArrayList;
import java.util.List;

import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import mastermind.models.Result;
import mastermind.views.GameView;
import mastermind.views.ProposedCombinationView;
import mastermind.views.ResultView;

class GameController {

	private GameView gameView;

	private Game game;

	GameController() {
		SecretCombinationController secretCombinationController = new SecretCombinationController();
		this.game = new Game(secretCombinationController.getSecretCombination());
		this.gameView = new GameView(this.game, secretCombinationController.getSecretCombinationView());
		this.game.addObserver(this.gameView);
	}

	void proposeCombination() {
		ProposedCombinationController proposecombinationController = new ProposedCombinationController();
		proposecombinationController.proposeCombination();
		this.gameView.addProposedCombinationView(proposecombinationController.getProposeCombinationView());
		this.game.addProposedCombination(proposecombinationController.getProposeCombination());
		ResultController resultController = new ResultController(this.game.getResult());
		this.gameView.addResultView(resultController.getResultView());
		this.game.addResult(resultController.getResult());
	}

	Game getGame() {
		return this.game;
	}

	public void reset() {
		List<ProposedCombinationView> proposedCombinationViews = new ArrayList<ProposedCombinationView>();
		for (ProposedCombination proposedCombination : this.game.getProposedCombinations()) {
			ProposedCombinationController proposedCombinationController = new ProposedCombinationController(
					proposedCombination);
			proposedCombinationViews.add(proposedCombinationController.getProposeCombinationView());
		}
		List<ResultView> resultViews = new ArrayList<ResultView>();
		for (Result result : this.game.getResults()) {
			ResultController resultController = new ResultController(result);
			resultViews.add(resultController.getResultView());
		}
		this.gameView.reset(proposedCombinationViews, resultViews);
	}

}
