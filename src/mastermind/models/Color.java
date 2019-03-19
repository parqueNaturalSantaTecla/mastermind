package mastermind.models;

public enum Color {
	RED, 
	BLUE, 
	YELLOW, 
	GREEN, 
	ORANGE, 
	PURPLE;

	public static Color getInstance(int code) {
		assert 0 <= code && code < Color.length();
		return Color.values()[code];
	}

	static int length() {
		return Color.values().length;
	}
	
}
