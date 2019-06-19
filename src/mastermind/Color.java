package mastermind;

import santaTecla.utils.Console;

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
		assert 0 <= code && code < Color.length();
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

	static int length() {
		return Color.values().length;
	}

	void write() {
		new Console().write(this.initial);
	}
	
}
