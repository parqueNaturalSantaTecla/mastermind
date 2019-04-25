package mastermind.views;

import mastermind.utils.WithConsoleView;

class ProposedCombinationView extends WithConsoleView {

	private static final int ERROR_CODE = -1;

	void write(int[] codes) {
		for (int code : codes) {
			this.console.write(ColorView.getInstance(code).getInitial());
		}
	}

	int[] read() {
		String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
		int[] codes = new int[characters.length()];
		for (int i = 0; i < characters.length(); i++) {
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
