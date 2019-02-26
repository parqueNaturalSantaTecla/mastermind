package mastermind.controllers;

public interface ControllersVisitor {
	
	void visit(StartController startController);
	
	void visit(ProposalController proposalController);
	
	void visit(ResumeController continueController);
}
