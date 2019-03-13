package mastermind.views;

import mastermind.controllers.Logic;

public abstract class View {

	protected Logic logic;

	public View(Logic logic) {
		this.logic = logic;
	}

	public void interact() {
		boolean finished;
		boolean resume;
		do {
			this.start();
			do {
				finished = this.propose();
			} while (!finished);
			resume = this.resume();
		} while (resume);
	}

	protected abstract void start();

	protected abstract boolean propose();

	protected abstract boolean resume();

}
