package mastermind.controllers.implementation;

import mastermind.controllers.ExitController;
import mastermind.controllers.PlayController;
import mastermind.controllers.ProposalController;
import mastermind.controllers.RedoController;
import mastermind.controllers.UndoController;
import mastermind.models.Session;

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
	public int proposeCombination(int[] codes) {
		return this.proposalController.proposeCombination(codes);
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
	public int[][][] getAllCodes() {
		return this.proposalController.getAllCodes();
	}

	@Override
	public int getTurn() {
		return this.proposalController.getTurn();
	}

}
