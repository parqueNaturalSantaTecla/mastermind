package mastermind.controllers.implementation;

import mastermind.controllers.StartController;
import mastermind.models.Session;
import mastermind.models.SessionImplementation;

public class StartControllerImplementation extends StartController {

	public StartControllerImplementation(Session session) {
		super(session);
	}

	@Override
	public void start() {
		((SessionImplementation) this.session).next();
	}

	@Override
	public void start(String title) {
		((SessionImplementation) this.session).load(title);
	}

	@Override
	public String[] getGamesNames() {
		return ((SessionImplementation) this.session).getGamesNames();
	}

	@Override
	public int getTurn() {
		return ((SessionImplementation) this.session).getTurn();
	}

	@Override
	public int[][][] getAllCodes() {
		return ((SessionImplementation) this.session).getCodes();
	}

	@Override
	public boolean isWinner() {
		return ((SessionImplementation) this.session).isWinner();
	}

	@Override
	public boolean isLooser() {
		return ((SessionImplementation) this.session).isLooser();
	}

}
