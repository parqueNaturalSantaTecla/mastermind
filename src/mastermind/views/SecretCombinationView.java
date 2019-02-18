package mastermind.views;

public class SecretCombinationView extends WithConsoleView {

	private static final String HIDDEN = "*";
	
	public SecretCombinationView() {
		super();
	}
	
	public void writeln(int length) {
		for (int i = 0; i < length; i++) {
			this.console.write(SecretCombinationView.HIDDEN);
		}
		this.console.writeln();
	}
	
}
