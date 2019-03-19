package mastermind.distributed;

import mastermind.models.DAO.SessionImplementationDAO;

public class MastermindServerFile extends MastermindServer{
	
	@Override
	protected abstract SessionImplementationDAO createDAO() {
		return new SessionImplementationFileDAO();
	}

	public static void main(String[] args) {
		new MastermindServerFile().serve();
	}

}
