package mastermind.controllers;

import java.util.ArrayList;
import java.util.List;

import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.distributed.dispatchers.FrameType;
import mastermind.distributed.dispatchers.TCPIP;

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

	public Error addProposedCombination(List<Color> colors) {
		if (this.tcpip == null) {
			return this.proposalController.addProposedCombination(colors);
		}
		this.tcpip.send(FrameType.PROPOSECOMBINATION.name());
		this.tcpip.send(colors.size());
		for (Color color : colors) {
			this.tcpip.send(color);
		}
		return this.tcpip.receiveError();
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

	public List<Color> getColors(int position) {
		if (this.tcpip == null) {
			return this.proposalController.getColors(position);
		} 
		this.tcpip.send(FrameType.COLORS.name());
		this.tcpip.send(position);
		int size = this.tcpip.receiveInt();
		List<Color> colors = new ArrayList<Color>(); 
		for (int i = 0; i < size; i++) {
			colors.add(this.tcpip.receiveColor());
		}
		return colors;
	}

	public int getAttempts() {
		if (this.tcpip == null) {
			return this.proposalController.getAttempts();
		}
		this.tcpip.send(FrameType.ATTEMPTS.name());
		return this.tcpip.receiveInt();
	}

	public int getBlacks(int position) {
		if (this.tcpip == null) {
			return this.proposalController.getBlacks(position);
		}
		this.tcpip.send(FrameType.BLACKS.name());
		this.tcpip.send(position);
		return this.tcpip.receiveInt();
	}

	public int getWhites(int position) {
		if (this.tcpip == null) {
			return this.proposalController.getWhites(position);
		}
		this.tcpip.send(FrameType.WHITES.name());
		this.tcpip.send(position);
		return this.tcpip.receiveInt();
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
