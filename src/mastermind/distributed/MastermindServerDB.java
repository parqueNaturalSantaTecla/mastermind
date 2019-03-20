package mastermind.distributed;

import mastermind.models.DAO.SessionImplementationDAO;
import mastermind.models.dataBase.SessionImplementationDBDAO;

public class MastermindServerDB extends MastermindServer {
	
	@Override
	protected SessionImplementationDAO createDAO() {
		return new SessionImplementationDBDAO();
	}

	public static void main(String[] args) {
		new MastermindServerDB().serve();
	}

}
