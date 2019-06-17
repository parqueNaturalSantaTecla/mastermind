package mastermind.views;

class SecretCombinationView {

	SecretCombinationView() {
		super();
	}

	void writeln(int length) {
		for (int i = 0; i < length; i++) {
			MessageView.SECRET.write();
		}
		MessageView.NEW_LINE.writeln();
	}

}
