package mastermind.distributed.dispatchers;

import java.util.List;

import mastermind.controllers.PlayController;
import mastermind.types.Color;

public class ColorsDispatcher extends Dispatcher {

	public ColorsDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		int position = this.tcpip.receiveInt();
		List<Color> colors = ((PlayController) this.acceptorController).getColors(position);
		for (Color color: colors) {
			this.tcpip.send(color);
		}
	}

}
