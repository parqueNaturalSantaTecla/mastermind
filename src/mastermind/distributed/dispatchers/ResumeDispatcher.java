package mastermind.distributed.dispatchers;

import mastermind.controllers.ResumeController;

public class ResumeDispatcher extends Dispatcher {

	public ResumeDispatcher(ResumeController resumeController) {
		super(resumeController);
	}

	@Override
	public void dispatch() {
		boolean resume = this.tcpip.receiveBoolean();
		((ResumeController)this.acceptorController).isNewGame(resume);
	}

}
