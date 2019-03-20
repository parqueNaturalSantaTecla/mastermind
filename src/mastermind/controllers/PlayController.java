package mastermind.controllers;

import mastermind.distributed.FrameType;
import mastermind.models.Session;
import mastermind.utils.TCPIP;

public class PlayController extends AcceptorController {

	private ProposalController proposalController;

	private UndoController undoController;

	private RedoController redoController;

	protected PlayController(Session session, TCPIP tcpip) {
		super(session, tcpip);
		if (tcpip == null) {
			this.proposalController = new ProposalController(this.session);
			this.undoController = new UndoController(this.session);
			this.redoController = new RedoController(this.session);
		}
	}

	public int proposeCombination(int[] codes) {
		if (this.tcpip == null) {
			return this.proposalController.proposeCombination(codes);
		}
		this.tcpip.send(FrameType.PROPOSECOMBINATION.name());
		this.tcpip.send(codes.length);
		for (int code : codes) {
			this.tcpip.send(code);
		}
		return this.tcpip.receiveInt();
	}

	public void undo() {
		if (this.tcpip == null) {
			this.undoController.undo();
		} else {
			this.tcpip.send(FrameType.UNDO.name());
		}
	}

	public void redo() {
		if (this.tcpip == null) {
			this.redoController.redo();
		} else {
			this.tcpip.send(FrameType.REDO.name());
		}
	}

	public boolean undoable() {
		if (this.tcpip == null) {
			return this.undoController.undoable();
		}
		this.tcpip.send(FrameType.UNDOABLE.name());
		return this.tcpip.receiveBoolean();
	}

	public boolean redoable() {
		if (this.tcpip == null) {
			return this.redoController.redoable();
		} 
		this.tcpip.send(FrameType.REDOABLE.name());
		return this.tcpip.receiveBoolean();
	}

	public boolean isWinner() {
		if (this.tcpip == null) {
			return this.proposalController.isWinner();
		} 
		this.tcpip.send(FrameType.WINNER.name());
		return this.tcpip.receiveBoolean();
	}

	public boolean isLooser() {
		if (this.tcpip == null) {
			return this.proposalController.isLooser();
		}
		this.tcpip.send(FrameType.LOOSER.name());
		return this.tcpip.receiveBoolean();
	}

	public int[][][] getAllCodes() {
		if (this.tcpip == null) {
			return this.proposalController.getAllCodes();
		} 
		this.tcpip.send(FrameType.ALLCODES.name());
		int row = this.tcpip.receiveInt();
		if (row == 0) {
			return new int[0][][];
		}
		int column = this.tcpip.receiveInt();
		int array = this.tcpip.receiveInt();
		int[][][] codes = new int[row][column][];
		for(int i=0; i<codes.length; i++) {
			codes[i][0] = new int[array];
			codes[i][1] = new int[2];
		}
		for (int i=0; i<codes.length; i++) {
			for (int j=0; j<codes[i].length; j++) {
				for (int k=0; k<codes[i][j].length; k++) {
					codes[i][j][k] = this.tcpip.receiveInt();
				}
			}
		}
		return codes;
	}

	public int getTurn() {
		if (this.tcpip == null) {
			return this.proposalController.getTurn();
		}
		this.tcpip.send(FrameType.TURN.name());
		return this.tcpip.receiveInt();
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
