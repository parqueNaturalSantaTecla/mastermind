package mastermind;

import mastermind.models.DAO.SessionImplementationDAO;

public class MastermindStandaloneDB {
	
	protected SessionImplementationDAO createDAO() {
		return null;
	}
	
	public static void main(String[] args) {
		new MastermindStandaloneFile().play();
	}

}
