package mastermind.controllers;

import mastermind.models.Game;

public class ResumeController extends Controller {

	public ResumeController(Game game, State state) {
		super(game, state);
	}
	
	public void resume(boolean resume) {
		if (resume) {
			this.game.clear();
			this.state.reset();
		} else {
			this.state.next();
		}
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}
