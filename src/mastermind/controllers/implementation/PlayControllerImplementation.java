package mastermind.controllers.implementation;

import java.util.List;

import mastermind.controllers.ExitController;
import mastermind.controllers.PlayController;
import mastermind.controllers.ProposalController;
import mastermind.controllers.RedoController;
import mastermind.controllers.UndoController;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;

public class PlayControllerImplementation extends PlayController {

	private ProposalController proposalController;

	private UndoController undoController;

	private RedoController redoController;

	private ExitController exitController;

	PlayControllerImplementation(Session session) {
		super(session);
		this.proposalController = new ProposalController(this.session);
		this.undoController = new UndoController(this.session);
		this.redoController = new RedoController(this.session);
		this.exitController = new ExitController(this.session);
	}

	@Override
	public Error addProposedCombination(List<Color> colors) {
		return this.proposalController.addProposedCombination(colors);
	}

	@Override
	public void undo() {
		this.undoController.undo();
	}

	@Override
	public void redo() {
		this.redoController.redo();
	}

	@Override
	public void next() {
		this.exitController.next();
	}

	@Override
	public boolean undoable() {
		return this.undoController.undoable();
	}

	@Override
	public boolean redoable() {
		return this.redoController.redoable();
	}

	@Override
	public boolean isWinner() {
		return this.proposalController.isWinner();
	}

	@Override
	public boolean isLooser() {
		return this.proposalController.isLooser();
	}

	@Override
	public List<Color> getColors(int position) {
		return this.proposalController.getColors(position);
	}

	@Override
	public int getBlacks(int position) {
		return this.proposalController.getBlacks(position);
	}

	@Override
	public int getWhites(int position) {
		return this.proposalController.getWhites(position);
	}

	@Override
	public int getAttempts() {
		return this.proposalController.getAttempts();
	}

}
