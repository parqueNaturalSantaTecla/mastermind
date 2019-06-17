package mastermind.models;

import mastermind.events.LostGameEvent;
import mastermind.events.WonGameEvent;
import santaTecla.utils.Observed;

public class Mastermind extends Observed{
	
	private Game game;
	
	private Registry registry;
	
	public Mastermind(Game game) {
		this.game = game;
		this.registry = new Registry(this.game);
	}

	public SecretCombination getSecretCombination() {
		return this.game.getSecretCombination();
	}

	public boolean undoable() {
		return this.registry.undoable();
	}

	public boolean redoable() {
		return this.registry.redoable();
	}

	public boolean isWinner() {
		boolean isWinner = this.game.isWinner();
		if (isWinner) {
			this.notify(new WonGameEvent());
		}
		return isWinner;
	}

	public boolean isLooser() {
		boolean isLooser = this.game.isLooser();
		if (isLooser) {
			this.notify(new LostGameEvent());
		}
		return isLooser;
	}
	
	public void undo() {
		this.registry.undo(this.game);
	}

	public void redo() {
		this.registry.redo(this.game);
	}

	public void proposeCombination() {
		this.registry.registry();
	}

	public void clear() {
		this.game.clear();
		this.registry.reset();
	}
	
}
