package mastermind.views.console;

import mastermind.models.Error;
import mastermind.utils.ClosedInterval;
import mastermind.utils.Console;

enum ColorView {
	RED('r'), BLUE('b'), YELLOW('y'), GREEN('g'), ORANGE('o'), PURPLE('p');

	private char initial;

	private ColorView(char initial) {
		this.initial = initial;
	}

	void write() {
		new Console().write("" + this.initial);
	}
	
	static String allInitials() {
		String result = "";
		for(ColorView colorView: ColorView.values()) {
			result += colorView.initial;
		}
		return result;
	}

	static ColorView getInstance(int code) {
		assert new ClosedInterval(0, ColorView.values().length).includes(code);
		return ColorView.values()[code];
	}

	static ColorView getInstance(char character) {
		for (ColorView colorView : ColorView.values()) {
			if (colorView.initial == character) {
				return colorView;
			}
		}
		return null;
	}

	static Error isValid(char character) {
		if (ColorView.getInstance(character) == null) {
			return Error.WRONG_CHARACTERS;
		}
		return null;
	}

}
