package mastermind.views;

import mastermind.types.Color;
import santaTecla.utils.Console;

public class ColorView {

	static final char[] INITIALS = { 'r', 'b', 'y', 'g', 'o', 'p' };

	protected Color color;

	public ColorView(Color color) {
		this.color = color;
	}

	static String allInitials() {
		String result = "";
		for (char character : ColorView.INITIALS) {
			result += character;
		}
		return result;
	}

	char getInitial() {
		return ColorView.INITIALS[this.color.ordinal()];
	}

	public static Color getInstance(char character) {
		for (int i = 0; i < ColorView.INITIALS.length; i++) {
			if (ColorView.INITIALS[i] == character) {
				return Color.values()[i];
			}
		}
		return null;
	}

	public void write() {
		new Console().write(ColorView.INITIALS[this.color.ordinal()]);
	}

}
