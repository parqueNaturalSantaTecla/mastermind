package mastermind.controllers.implementation;

import mastermind.controllers.StartController;
import mastermind.models.Session;
import mastermind.models.SessionImplementation;
import mastermind.models.DAO.SessionImplementationDAO;

public class StartControllerImplementation extends StartController {

	private SessionImplementationDAO sessionImplementationDAO;

	StartControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
		super(session);
		this.sessionImplementationDAO = sessionImplementationDAO;
	}

	@Override
	public void start() {
		((SessionImplementation) this.session).next();
	}

	@Override
	public void start(String name) {
		this.sessionImplementationDAO.load(name);
	}

	@Override
	public String[] getGamesNames() {
		return this.sessionImplementationDAO.getGamesNames();
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
