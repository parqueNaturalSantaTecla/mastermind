package mastermind.models.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import mastermind.controllers.StateValue;
import mastermind.models.SessionImplementation;

public class SessionImplementationDAO {

	private static final String EXTENSION = ".mm";

	private static final String DIRECTORY = "/Users/Tamara/git/mastermind.mvp.pm/partidas";

	private static File directory;

	static {
		SessionImplementationDAO.directory = new File(SessionImplementationDAO.DIRECTORY);
	}
	
	private SessionImplementation sessionImplementation;
	
	private GameDAO gameDAO;

	public void associate(SessionImplementation sessionImplementation) {
		this.sessionImplementation = sessionImplementation;
		this.gameDAO = new GameDAO(this.sessionImplementation.getGame());
	}

	public void load(String name) {
		this.sessionImplementation.setName(name);
		File file = new File(SessionImplementationDAO.directory, name);
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			this.gameDAO.load(bufferedReader);
			this.sessionImplementation.resetRegistry();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.sessionImplementation.setStateValue(StateValue.IN_GAME);
		if (this.sessionImplementation.isLooser() || this.sessionImplementation.isWinner()) {
			this.sessionImplementation.setStateValue(StateValue.FINAL);
		}
	}

	public void save() {
		this.save(this.sessionImplementation.getName());
	}

	public void save(String name) {
		if (name.endsWith(SessionImplementationDAO.EXTENSION)) {
			name = name.replace(SessionImplementationDAO.EXTENSION, "");
		}
		File file = new File(SessionImplementationDAO.directory, name + SessionImplementationDAO.EXTENSION);
		try {
			FileWriter fileWriter = new FileWriter(file);
			this.gameDAO.save(fileWriter);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] getGamesNames() {
		return SessionImplementationDAO.directory.list();
	}

	public boolean exists(String name) {
		for (String auxName : this.getGamesNames()) {
			if (auxName.equals(name + SessionImplementationDAO.EXTENSION)) {
				return true;
			}
		}
		return false;
	}

}
