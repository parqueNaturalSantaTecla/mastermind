package mastermind.controllers;

import mastermind.models.Session;

public abstract class GameController extends AcceptorController {

	GameController(Session session) {
		super(session);
	}

	public abstract int getTurn();

	public abstract int[][][] getAllCodes();

	public abstract boolean isWinner();

	public abstract boolean isLooser();

	@Override
	public abstract void accept(ControllersVisitor controllersVisitor);
	
}
