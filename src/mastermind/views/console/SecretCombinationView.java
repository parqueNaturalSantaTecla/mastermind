package mastermind.views.console;

class SecretCombinationView extends WithConsoleView {

	private static final String HIDDEN = "*";
	
	SecretCombinationView() {
		super();
	}
	
	void writeln(int length) {
		for (int i = 0; i < length; i++) {
			this.console.write(SecretCombinationView.HIDDEN);
		}
		this.console.writeln();
	}
	
}
