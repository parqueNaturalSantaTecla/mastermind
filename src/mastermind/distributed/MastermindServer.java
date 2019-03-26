package mastermind.distributed;

import java.util.HashMap;
import java.util.Map;
import mastermind.distributed.dispatchers.DispatcherPrototype;
import mastermind.models.DAO.SessionImplementationDAO;
import mastermind.models.Files.SessionImplementationFileDAO;
import mastermind.models.dataBase.SessionImplementationDBDAO;

public class MastermindServer {

	private static Map<String, SessionImplementationDAO> sessionDaoMap;
	
	private static Map<String, LogicImplementationServer> logicDaoMap;

	static {
		MastermindServer.sessionDaoMap = new HashMap<String, SessionImplementationDAO>();
		MastermindServer.sessionDaoMap.put("file", new SessionImplementationFileDAO());
		MastermindServer.sessionDaoMap.put("db", new SessionImplementationDBDAO());
		MastermindServer.logicDaoMap = new HashMap<String, LogicImplementationServer>();
		MastermindServer.logicDaoMap.put("file", new LogicImplementationServer(MastermindServer.sessionDaoMap.get("file")));
		MastermindServer.logicDaoMap.put("db", new LogicImplementationServer(MastermindServer.sessionDaoMap.get("db")));
	}

	private DispatcherPrototype dispatcherPrototype;

	private static LogicImplementationServer logic;

	protected MastermindServer() {
		this.dispatcherPrototype = new DispatcherPrototype();
		MastermindServer.logic.createDispatchers(this.dispatcherPrototype);
	}

	protected void serve() {
		this.dispatcherPrototype.serve();
	}

	public static void main(String[] args) {
		SessionImplementationDAO sessionImplementationDAO = MastermindServer.sessionDaoMap.get(args[0]);
		if (sessionImplementationDAO == null) {
			System.out.println("Introduce 'file' para ficheros o 'db' para bases de datos");
			System.exit(0);
		}
		MastermindServer.logic = MastermindServer.logicDaoMap.get(args[0]);
		new MastermindServer().serve();
	}

}
