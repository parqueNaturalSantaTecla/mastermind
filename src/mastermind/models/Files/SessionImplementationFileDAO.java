package mastermind.models.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import mastermind.models.SessionImplementation;
import mastermind.models.StateValue;
import mastermind.models.DAO.SessionImplementationDAO;

public class SessionImplementationFileDAO extends SessionImplementationDAO{

	protected static final String EXTENSION = ".mm";

	protected static final String DIRECTORY = "/Users/Tamara/git/mastermind.mvp.pm/partidas";

	protected static File directory;

	static {
		SessionImplementationFileDAO.directory = new File(SessionImplementationFileDAO.DIRECTORY);
	}

	private GameFileDAO gameFileDAO;

	public void associate(SessionImplementation sessionImplementation) {
		super.associate(sessionImplementation);
		this.gameFileDAO = new GameFileDAO(this.sessionImplementation.getGame());
	}
	
	@Override
	public void load(String name) {
		this.sessionImplementation.setName(name);
		File file = new File(SessionImplementationFileDAO.directory, name);
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			this.gameFileDAO.load(bufferedReader);
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

	@Override
	public void save(String name) {
		if (name.endsWith(SessionImplementationFileDAO.EXTENSION)) {
			name = name.replace(SessionImplementationFileDAO.EXTENSION, "");
		}
		File file = new File(SessionImplementationFileDAO.directory, name + SessionImplementationFileDAO.EXTENSION);
		try {
			FileWriter fileWriter = new FileWriter(file);
			this.gameFileDAO.save(fileWriter);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean exists(String name) {
		for (String auxName : this.getGamesNames()) {
			if (auxName.equals(name + SessionImplementationFileDAO.EXTENSION)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String[] getGamesNames() {
		return SessionImplementationFileDAO.directory.list();
	}

}
