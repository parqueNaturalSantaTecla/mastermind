package mastermind.distributed;

import java.util.ArrayList;
import java.util.List;

import mastermind.controllers.StartController;
import mastermind.distributed.FrameType;
import mastermind.models.Session;
import mastermind.types.Color;
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
		for (int i = 0; i < length; i++) {
			names[i] = this.tcpip.receiveLine();
		}
		return names;
	}

	@Override
	public int getAttempts() {
		this.tcpip.send(FrameType.ATTEMPTS.name());
		return this.tcpip.receiveInt();
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
	public List<Color> getColors(int position) {
		this.tcpip.send(FrameType.COLORS.name());
		this.tcpip.send(position);
		int size = this.tcpip.receiveInt();
		List<Color> colors = new ArrayList<Color>();
		for (int i = 0; i < size; i++) {
			colors.add(this.tcpip.receiveColor());
		}
		return colors;
	}
	
	@Override
	public int getBlacks(int position) {
		this.tcpip.send(FrameType.BLACKS.name());
		this.tcpip.send(position);
		return this.tcpip.receiveInt();
	}

	@Override
	public int getWhites(int position) {
		this.tcpip.send(FrameType.WHITES.name());
		this.tcpip.send(position);
		return this.tcpip.receiveInt();
	}

}
