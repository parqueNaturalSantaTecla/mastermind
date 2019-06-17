package mastermind.views;

import mastermind.events.LostGameEvent;
import mastermind.events.NewGameEvent;
import mastermind.events.WonGameEvent;
import mastermind.models.Mastermind;
import mastermind.views.Menu;
import santaTecla.utils.Event;
import santaTecla.utils.Observed;
import santaTecla.utils.Observer;
import santaTecla.utils.YesNoDialog;

public class MastermindView extends Observed implements Observer{

	private Mastermind mastermind;

	private Menu menu;

	public MastermindView(Mastermind mastermind, Observer observer) {
		this.mastermind = mastermind;
		this.menu = new Menu(mastermind, observer);
	}

	public void write() {
		MessageView.TITLE.writeln();
		new SecretCombinationView(this.mastermind.getSecretCombination()).writeln();
		do {
			this.menu.execute();
		} while (!this.mastermind.isWinner() && !this.mastermind.isLooser());
	}

	@Override
	public void update(Observed observed, Event event) {
		if (event instanceof WonGameEvent) {
			MessageView.WINNER.writeln();
			this.resume();
		} else if (event instanceof LostGameEvent) {
			MessageView.LOOSER.writeln();
			this.resume();
		}
	}

	private void resume() {
		if (new YesNoDialog().read(MessageView.RESUME.getMessage())) {
			this.notify(new NewGameEvent());
		}
	}

}
