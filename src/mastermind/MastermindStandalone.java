package mastermind;

import java.util.HashMap;
import java.util.Map;
import mastermind.controllers.implementation.LogicImplementation;
import mastermind.models.DAO.SessionImplementationDAO;
import mastermind.models.Files.SessionImplementationFileDAO;
import mastermind.models.dataBase.SessionImplementationDBDAO;

public class MastermindStandalone extends Mastermind {

	private Map<String, SessionImplementationDAO> sessionDaoMap;

	public MastermindStandalone() {
		super();
		this.sessionDaoMap = new HashMap<String, SessionImplementationDAO>();
		this.sessionDaoMap.put("file", new SessionImplementationFileDAO());
		this.sessionDaoMap.put("db", new SessionImplementationDBDAO());
	}

	public void play(String arg) {
		SessionImplementationDAO sessionImplementationDAO = this.sessionDaoMap.get(arg);
		if (sessionImplementationDAO == null) {
			System.out.println("Introduce 'file' para ficheros o 'db' para bases de datos");
			System.exit(0);
		}
		this.logic = new LogicImplementation(sessionImplementationDAO);
		super.play();
	}
	
	public static void main(String[] args) {
		new MastermindStandalone().play(args[0]);
	}

}
