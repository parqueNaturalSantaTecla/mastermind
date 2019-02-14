package mastermind.controllers;

public interface ControllerVisitor {
	
	void visit(StartController startController);
	
	void visit(ProposalController proposalController);
	
	void visit(ResumeController continueController);
}
