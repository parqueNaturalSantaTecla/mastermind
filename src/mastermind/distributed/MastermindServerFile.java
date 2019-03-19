package mastermind.distributed;

import mastermind.models.DAO.SessionImplementationDAO;
import mastermind.models.Files.SessionImplementationFileDAO;

public class MastermindServerFile extends MastermindServer{
	
	@Override
	protected SessionImplementationDAO createDAO() {
		return new SessionImplementationFileDAO();
	}

	public static void main(String[] args) {
		new MastermindServerFile().serve();
	}

}
