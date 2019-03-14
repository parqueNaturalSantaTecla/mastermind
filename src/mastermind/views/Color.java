package mastermind.views;

import mastermind.utils.ClosedInterval;

enum Color {
	RED('r'), 
	BLUE('b'), 
	YELLOW('y'), 
	GREEN('g'), 
	ORANGE('o'), 
	PURPLE('p');

	private char initial;

	private Color(char initial) {
		this.initial = initial;
	}

	static String allInitials() {
		String result = "";
		for(Color color: Color.values()) {
			result += color.initial;
		}
		return result;
	}

	static Color getInstance(int code) {
		assert new ClosedInterval(0, Color.values().length).includes(code);
		return Color.values()[code];
	}

	static Color getInstance(char character) {
		for (Color color : Color.values()) {
			if (color.initial == character) {
				return color;
			}
		}
		return null;
	}
	
	char getInitial() {
		return this.initial;
	}

}
