package mastermind.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import mastermind.controllers.State;
import mastermind.controllers.StateValue;

public class SessionImplementation implements Session {

	public static final String EXTENSION = ".mm";

	public static final String DIRECTORY = "/Users/Tamara/git/mastermind.mvp.pm/partidas";

	private static File directory;

	static {
		SessionImplementation.directory = new File(SessionImplementation.DIRECTORY);
	}

	private State state;

	private Game game;

	private Registry registry;

	private String name;

	public SessionImplementation() {
		this.state = new State();
		this.game = new Game();
		this.registry = new Registry(this.game);
		this.name = null;
	}

	public void next() {
		this.state.next();
	}

	public void proposeCombination(ProposedCombination proposedCombination) {
		this.game.proposeCombination(proposedCombination);
		this.registry.registry();
	}

	public boolean undoable() {
		return this.registry.undoable();
	}

	public boolean redoable() {
		return this.registry.redoable();
	}

	public void undo() {
		this.registry.undo(this.game);
	}

	public void redo() {
		this.registry.redo(this.game);
	}

	public void resume() {
		this.game.clear();
		this.state.reset();
		this.registry.reset();
		this.name = null;
	}

	public void load(String name) {
		this.name = name;
		File file = new File(SessionImplementation.directory, name);
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			this.game.load(bufferedReader);
			this.registry.reset();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.state.setStateValue(StateValue.IN_GAME);
		if (this.isLooser() || this.isWinner()) {
			this.state.setStateValue(StateValue.FINAL);
		}
	}

	public void save() {
		this.save(this.name);
	}

	public void save(String name) {
		if (name.endsWith(SessionImplementation.EXTENSION)) {
			name = name.replace(SessionImplementation.EXTENSION, "");
		}
		File file = new File(SessionImplementation.directory, name + SessionImplementation.EXTENSION);
		try {
			FileWriter fileWriter = new FileWriter(file);
			this.game.save(fileWriter);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isWinner() {
		return this.game.isWinner();
	}

	public boolean isLooser() {
		return this.game.isLooser();
	}

	public int[][][] getCodes() {
		return this.game.getCodes();
	}

	public int getTurn() {
		return this.game.getTurn();
	}

	public String[] getGamesNames() {
		return SessionImplementation.directory.list();
	}

	public boolean exists(String name) {
		for (String auxName : this.getGamesNames()) {
			if (auxName.equals(name + SessionImplementation.EXTENSION)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasName() {
		return this.name != null;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getWidth() {
		return this.game.getWidth();
	}

	@Override
	public StateValue getValueState() {
		return this.state.getValueState();
	}

	@Override
	public String getName() {
		return this.name;
	}

}
