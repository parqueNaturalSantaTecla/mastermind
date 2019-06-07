package mastermind.models;

import java.util.List;

import mastermind.distributed.FrameType;
import mastermind.types.Color;
import santaTecla.utils.TCPIP;

public class Session {

	private State state;

	private Game game;

	private Registry registry;

	private TCPIP tcpip;

	public Session(TCPIP tcpip) {
		this.state = new State();
		this.game = new Game();
		this.registry = new Registry(this.game);
		this.tcpip = tcpip;
	}

	public void next() {
		this.state.next();
	}

	public void addProposedCombination(List<Color> colors) {
		this.game.addProposedCombination(colors);
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

	public void clearGame() {
		this.game.clear();
		this.state.reset();
		this.registry.reset();
	}

	public boolean isWinner() {
		return this.game.isWinner();
	}

	public boolean isLooser() {
		return this.game.isLooser();
	}

	public int getAttempts() {
		return this.game.getAttempts();
	}

	public List<Color> getColors(int position) {
		return this.game.getColors(position);
	}

	public int getBlacks(int position) {
		return this.game.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.game.getWhites(position);
	}

	public int getWidth() {
		if (this.tcpip == null) {
			return this.game.getWidth();
		}
		this.tcpip.send(FrameType.WIDTH.name());
		return this.tcpip.receiveInt();
	}

	public StateValue getValueState() {
		if (this.tcpip == null) {
			return this.state.getValueState();
		}
		this.tcpip.send(FrameType.STATE.name());
		return StateValue.values()[this.tcpip.receiveInt()];
	}

}
