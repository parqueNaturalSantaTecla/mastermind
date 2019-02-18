package mastermind.views;

import java.util.HashMap;
import java.util.Map;

public class ErrorView extends WithConsoleView {
	
	private static Map<Integer, String> MESSAGES;
	public static final int NO_ERROR = -1;
	private static final int DUPLICATED = 0;
	private static final int WRONG_CHARACTERS = 1;
	private static final int WRONG_LENGTH = 2;
	
	static {
		ErrorView.MESSAGES = new HashMap<Integer, String>();
		ErrorView.MESSAGES.put(ErrorView.DUPLICATED,  "Colores repetidos");
		ErrorView.MESSAGES.put(ErrorView.WRONG_CHARACTERS,  "Colores erróneos, tienen que ser: #initials");
		ErrorView.MESSAGES.put(ErrorView.WRONG_LENGTH,  "Error en la longitud de la combinación");
	}

	public void write(int error) {
		String message = ErrorView.MESSAGES.get(error);
		if (error == ErrorView.WRONG_CHARACTERS) {
			message = message.replaceFirst("#initials", ColorView.allInitials());
		}
		this.console.writeln(message);
	}

}
