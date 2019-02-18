package mastermind.views.console;

import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.views.View;

public class ConsoleView extends View {
	
	private StartView startView;
	
	private ProposalView proposalView;
	
	private ResumeView continueView;
	
	public ConsoleView(){
		startView = new StartView();
		proposalView = new ProposalView();
		continueView = new ResumeView();
	}

	@Override
	public void visit(StartController startController) {
		startView.interact(startController);		
	}

	@Override
	public void visit(ProposalController proposalController) {
		proposalView.interact(proposalController);
	}

	@Override
	public void visit(ResumeController continueController) {
		continueView.interact(continueController);
	}

}
