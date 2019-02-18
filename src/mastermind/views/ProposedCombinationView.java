package mastermind.views;

class ProposedCombinationView extends WithConsoleView {

	private static final String TITTLE = "Propón una combinación: ";
	
	public static final int ERROR_CODE = -1;
	
	public void write(int[] codes) {
		for (int code : codes) {
			ColorView.getInstance(code).write();
		}
	}

	public int[] read() {
		String characters = this.console.readString(ProposedCombinationView.TITTLE);
		int[] codes = new int[characters.length()];
		for (int i=0; i<characters.length(); i++) {
			ColorView colorView = ColorView.getInstance(characters.charAt(i));
			if (colorView == null) {
				codes[i] = ProposedCombinationView.ERROR_CODE;
			} else {
				codes[i] = colorView.ordinal();
			}
		}
		return codes;
	}
	
}
