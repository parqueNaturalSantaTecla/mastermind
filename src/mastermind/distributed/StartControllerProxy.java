package mastermind.distributed;

import mastermind.controllers.StartController;
import mastermind.distributed.dispatchers.FrameType;
import mastermind.models.Session;
import mastermind.utils.TCPIP;

public class StartControllerProxy extends StartController {
	
	private TCPIP tcpip;

	StartControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void start() {
		this.tcpip.send(FrameType.START.name());
	}

	@Override
	public void start(String title) {
		this.tcpip.send(FrameType.START_NAME.name());
		this.tcpip.send(title);
	}

	@Override
	public String[] getGamesNames() {
		this.tcpip.send(FrameType.TITLES.name());
		int length = this.tcpip.receiveInt();
		String[] names = new String[length];
		for (int i=0; i<length; i++) {
			names[i] = this.tcpip.receiveLine();
		}
		return names;		
	}

	@Override
	public int getTurn() {
		this.tcpip.send(FrameType.TURN.name());
		return this.tcpip.receiveInt();
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
	public boolean isWinner() {
		this.tcpip.send(FrameType.WINNER.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public boolean isLooser() {
		this.tcpip.send(FrameType.LOOSER.name());
		return this.tcpip.receiveBoolean();
	}

}
