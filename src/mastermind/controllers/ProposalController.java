//package mastermind.controllers;
//
//import mastermind.models.ProposedCombination;
//import mastermind.models.Session;
//import mastermind.views.ProposedCombinationView;
//
//public class ProposalController extends InGameController {
//
//	public ProposalController(Session session) {
//		super(session);
//	}
//
//	@Override
//	public void inGameControl() {
//		ProposedCombination proposedCombination = new ProposedCombination();
//		new ProposedCombinationView(proposedCombination).read();
//		this.session.proposeCombination(proposedCombination);
//		if (this.session.isWinner() || this.session.isLooser()) {
//			this.session.next();
//		}
//	}
//
//}
