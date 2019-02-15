package mastermind.views;

import mastermind.controllers.Error;

public class ErrorView extends WithConsoleView {

	public void write(Error error) {
		switch (error) {
		case DUPLICATED:
			this.console.writeln("Colores repetidos");
			break;
		}
	}

}
