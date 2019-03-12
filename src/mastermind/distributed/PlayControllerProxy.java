package mastermind.distributed;

import mastermind.controllers.PlayController;
import mastermind.models.Session;
import mastermind.utils.TCPIP;

public class PlayControllerProxy extends PlayController {

	private TCPIP tcpip;

	PlayControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public int proposeCombination(int[] codes) {
		this.tcpip.send(FrameType.PROPOSECOMBINATION.name());
		this.tcpip.send(codes.length);
		for (int code: codes) {
			this.tcpip.send(code);			
		}
		return this.tcpip.receiveInt();
	}

	@Override
	public void undo() {
		this.tcpip.send(FrameType.UNDO.name());
	}

	@Override
	public void redo() {
		this.tcpip.send(FrameType.REDO.name());
	}

	@Override
	public void next() {
		this.tcpip.send(FrameType.NEXT.name());
	}

	@Override
	public boolean undoable() {
		this.tcpip.send(FrameType.UNDOABLE.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public boolean redoable() {
		this.tcpip.send(FrameType.REDOABLE.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public boolean isWinner() {
		this.tcpip.send(FrameType.WINNER.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public boolean isLooser() {
		this.tcpip.send(FrameType.LOOSER.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public int[][][] getAllCodes() {
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

	@Override
	public int getTurn() {
		this.tcpip.send(FrameType.TURN.name());
		return this.tcpip.receiveInt();
	}

}
