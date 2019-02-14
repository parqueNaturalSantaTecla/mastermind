package mastermind.views;

import mastermind.controllers.Controller;
import mastermind.controllers.ControllerVisitor;
import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;

public class ConsoleView implements ControllerVisitor {
	
	private StartView startView;
	
	private ProposalView proposalView;
	
	private ContinueView continueView;
	
	public ConsoleView(){
		startView = new StartView();
		proposalView = new ProposalView();
		continueView = new ContinueView();
	}

	public void interact(Controller controller) {
		controller.accept(this);
	}

	public void visit(StartController startController) {
		startView.interact(startController);		
	}

	public void visit(ProposalController proposalController) {
		proposalView.interact(proposalController);
	}

	@Override
	public void visit(ResumeController continueController) {
		continueView.interact(continueController);
	}

}
