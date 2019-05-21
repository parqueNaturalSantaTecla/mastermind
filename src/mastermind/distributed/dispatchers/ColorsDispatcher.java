package mastermind.distributed.dispatchers;

import java.util.List;

import mastermind.controllers.implementation.PlayControllerImplementation;
import mastermind.types.Color;

public class ColorsDispatcher extends Dispatcher {

	public ColorsDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		int position = this.tcpip.receiveInt();
		List<Color> colors = ((PlayControllerImplementation) this.acceptorController).getColors(position);
		this.tcpip.send(colors.size());
		for (Color color: colors) {
			this.tcpip.send(color);
		}
	}

}
