package mastermind;

import mastermind.models.DAO.SessionImplementationDAO;
import mastermind.models.Files.SessionImplementationFileDAO;

public class MastermindStandaloneFile extends MastermindStandalone{
	
	@Override
	protected SessionImplementationDAO createDAO() {
		return new SessionImplementationFileDAO();
	}
	
	public static void main(String[] args) {
		new MastermindStandaloneFile().play();
	}

}
