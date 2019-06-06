package mastermind.views;

import mastermind.models.Color;
import santaTecla.utils.WithConsoleView;

class ColorView extends WithConsoleView{
	
	private static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p'};

	static String allInitials() {
		String result = "";
		for(char character: ColorView.INITIALS) {
			result += character;
		}
		return result;
	}

	static Color getInstance(char character) {
		for (int i = 0; i < ColorView.INITIALS.length; i++) {
			if (ColorView.INITIALS[i] == character) {
				return Color.values()[i];
			}
		}
		return null;
	}
	
	void write(Color color) {
		this.console.write(ColorView.INITIALS[color.ordinal()]);
	}

}
