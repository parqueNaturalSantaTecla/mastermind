package mastermind.views.graphics;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import mastermind.views.console.ColorView;

public class ErrorView {
	
	private static Map<Integer, String> MESSAGES;
	public static final int NO_ERROR = -1;
	private static final int DUPLICATED = 0;
	private static final int WRONG_CHARACTERS = 1;
	private static final int WRONG_LENGTH = 2;
	private String message;
	
	static {
		ErrorView.MESSAGES = new HashMap<Integer, String>();
		ErrorView.MESSAGES.put(ErrorView.DUPLICATED,  "Colores repetidos");
		ErrorView.MESSAGES.put(ErrorView.WRONG_CHARACTERS,  "Colores erróneos, tienen que ser: #initials");
		ErrorView.MESSAGES.put(ErrorView.WRONG_LENGTH,  "Error en la longitud de la combinación");
	}
	
	public ErrorView(int error) {
		this.message = ErrorView.MESSAGES.get(error);
		if (error == ErrorView.WRONG_CHARACTERS) {
			this.message = this.message.replaceFirst("#initials", ColorView.allInitials());
		}
		JOptionPane.showMessageDialog(null, this.message, "ERROR", JOptionPane.WARNING_MESSAGE);
	}

}
