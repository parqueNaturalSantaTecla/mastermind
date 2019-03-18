package mastermind.views.console;

import mastermind.controllers.Controller;
import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.views.View;

public class ConsoleView extends View {

	private StartView startView;

	private ProposalView proposalView;

	private ResumeView resumeView;

	public ConsoleView() {
		this.startView = new StartView();
		this.proposalView = new ProposalView();
		this.resumeView = new ResumeView();
	}

	@Override
	public void interact(Controller controller) {
		if (controller instanceof StartController) {
			this.startView.interact((StartController) controller);
		} else {
			if (controller instanceof ProposalController) {
				this.proposalView.interact((ProposalController) controller);
			} else {
				this.resumeView.interact((ResumeController) controller);
			}
		}
	}

}
