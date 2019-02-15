package mastermind.views;

import mastermind.controllers.Error;

public class ErrorView extends WithConsoleView {

	public void write(Error error) {
		switch (error) {
		case DUPLICATED:
			this.console.writeln("Colores repetidos");
			break;
		case WRONG_CHARACTERS:
			this.console.writeln("Caracteres erróneos, tienen que ser: ");
			ColorView.writeAll();
			break;
		case WRONG_LENGTH:
			this.console.writeln("Error en la longitud de la combinación");
			break;
		}
	}

}
