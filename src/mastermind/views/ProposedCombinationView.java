package mastermind.views;

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
		boolean ok = false;
		do {
			characters = this.console.readString(ProposedCombinationView.TITTLE);
			ok = ProposedCombinationView.isValid(characters);
		} while (!ok);
		return ProposedCombinationView.toCodes(characters);
	}

	private static boolean isValid(String characters) {
		for (char character : characters.toCharArray()) {
			if (!ColorView.isValid(character)) {
				return false;
			}
		}
		return true;
	}

	private static int[] toCodes(String characters) {
		assert ProposedCombinationView.isValid(characters);
		int[] codes = new int[characters.length()];
		for (int i=0; i<characters.length(); i++) {
			codes[i] = ColorView.getInstance(characters.charAt(i)).ordinal();
		}
		return codes;
	}

}
