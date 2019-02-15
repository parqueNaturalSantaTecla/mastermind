package mastermind.views;

import mastermind.controllers.Error;

public class ProposedCombinationView extends WithConsoleView {

	private static final String TITTLE = "Propón una combinación: ";
	
	public void write(int[] codes) {
		for (int code : codes) {
			ColorView.getInstance(code).write();
		}
		this.console.writeln();
	}

	public int[] read() {
		String characters;
		Error error = null;
		do {
			characters = this.console.readString(ProposedCombinationView.TITTLE);
			error = ProposedCombinationView.isValid(characters);
			if(error!=null) {
				new ErrorView().write(error);
			}
		} while (error!=null);
		return ProposedCombinationView.toCodes(characters);
	}

	private static Error isValid(String characters) {
		for (char character : characters.toCharArray()) {
			Error error = ColorView.isValid(character);
			if (error!=null) {
				return error;
			}
		}
		return null;
	}

	private static int[] toCodes(String characters) {
		int[] codes = new int[characters.length()];
		for (int i=0; i<characters.length(); i++) {
			codes[i] = ColorView.getInstance(characters.charAt(i)).ordinal();
		}
		return codes;
	}

}
