package mastermind;

import java.util.HashMap;
import java.util.Map;
import mastermind.controllers.Logic;
import mastermind.controllers.implementation.LogicImplementation;
import mastermind.models.DAO.SessionImplementationDAO;
import mastermind.models.Files.SessionImplementationFileDAO;
import mastermind.models.dataBase.SessionImplementationDBDAO;

public class MastermindStandalone extends Mastermind {

	private static Map<String, SessionImplementationDAO> sessionDaoMap;
	
	private static Map<String, Logic> logicDaoMap;

	static {
		MastermindStandalone.sessionDaoMap = new HashMap<String, SessionImplementationDAO>();
		MastermindStandalone.sessionDaoMap.put("file", new SessionImplementationFileDAO());
		MastermindStandalone.sessionDaoMap.put("db", new SessionImplementationDBDAO());
		MastermindStandalone.logicDaoMap = new HashMap<String, Logic>();
		MastermindStandalone.logicDaoMap.put("file", new LogicImplementation(MastermindStandalone.sessionDaoMap.get("file")));
		MastermindStandalone.logicDaoMap.put("db", new LogicImplementation(MastermindStandalone.sessionDaoMap.get("db")));
	}

	public MastermindStandalone() {
		super();
	}

	public static void main(String[] args) {
		SessionImplementationDAO sessionImplementationDAO = MastermindStandalone.sessionDaoMap.get(args[0]);
		if (sessionImplementationDAO == null) {
			System.out.println("Introduce 'file' para ficheros o 'db' para bases de datos");
			System.exit(0);
		}
		MastermindStandalone.logic = MastermindStandalone.logicDaoMap.get(args[0]);
		new MastermindStandalone().play();
	}

}
