package mastermind.distributed.dispatchers;

import java.util.ArrayList;
import java.util.List;

import mastermind.controllers.PlayController;
import mastermind.types.Color;

public class ProposeCombinationDispatcher extends Dispatcher {

	public ProposeCombinationDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		int length = this.tcpip.receiveInt();
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<length; i++) {
			colors.add(this.tcpip.receiveColor());
		}
		this.tcpip.send(((PlayController) this.acceptorController).addProposedCombination(colors));
	}

}
