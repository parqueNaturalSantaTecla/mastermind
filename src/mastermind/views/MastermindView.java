package mastermind.views;

import mastermind.models.Mastermind;
import mastermind.mvcUtils.Event;
import mastermind.mvcUtils.LostGameEvent;
import mastermind.mvcUtils.NewGameEvent;
import mastermind.mvcUtils.Observed;
import mastermind.mvcUtils.Observer;
import mastermind.mvcUtils.WonGameEvent;
import mastermind.utils.Menu;
import mastermind.utils.YesNoDialog;

public class MastermindView extends Observed implements Observer{

	private Mastermind mastermind;

	private Menu menu;

	public MastermindView(Mastermind mastermind, Observer observer) {
		this.mastermind = mastermind;
		this.menu = new Menu(mastermind, observer);
	}

	public void write() {
		this.console.writeln(Message.TITLE.getMessage());
		new SecretCombinationView(this.mastermind.getSecretCombination()).writeln();
		do {
			this.menu.execute();
		} while (!this.mastermind.isWinner() && !this.mastermind.isLooser());
	}

	@Override
	public void update(Observed observed, Event event) {
		if (event instanceof WonGameEvent) {
			this.console.writeln(Message.WINNER.getMessage());
			this.resume();
		} else if (event instanceof LostGameEvent) {
			this.console.writeln(Message.LOOSER.getMessage());
			this.resume();
		}
	}

	private void resume() {
		if (new YesNoDialog().read(Message.RESUME.getMessage())) {
			this.notify(new NewGameEvent());
		}
	}

}
