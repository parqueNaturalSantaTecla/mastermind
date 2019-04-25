package mastermind.views;

import mastermind.models.Color;
import mastermind.utils.ClosedInterval;
import mastermind.utils.WithConsoleView;

class ColorView extends WithConsoleView{
	
	private static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p'};

	private Color color;

	private ColorView(Color color) {
		this.color = color;
	}

	static String allInitials() {
		String result = "";
		for(char character: ColorView.INITIALS) {
			result += character;
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
	
	char getInitial() {
		return this.initial;
	}
	
	void write() {
		this.console.write(ColorView.INITIALS[this.color.ordinal()]);
	}

}
