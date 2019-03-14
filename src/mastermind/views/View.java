package mastermind.views;

import mastermind.models.Game;

public abstract class View {

	protected Game game;

	public View(Game game) {
		this.game = game;
	}

	public void interact() {
		boolean resume;
		do {
			this.start();
			boolean finished;
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
