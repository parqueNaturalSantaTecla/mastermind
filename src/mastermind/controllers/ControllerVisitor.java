package mastermind.controllers;

public interface ControllerVisitor {
	
	void visit(StartController startController);
	
	void visit(PlayController playController);
	
	void visit(ResumeController continueController);
}
