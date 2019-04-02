package mastermind.views;

import mastermind.models.ProposedCombination;
import mastermind.utils.WithConsoleView;

public class ProposedCombinationView extends WithConsoleView {

	private ProposedCombination proposedCombination;

	public ProposedCombinationView(ProposedCombination proposedCombination) {
		this.proposedCombination = proposedCombination;
	}

	void write() {
		for (mastermind.models.Color color : this.proposedCombination.getColors()) {
			this.console.write(Color.getInstance(color.ordinal()).getInitial());
		}
	}

	public void read() {
		mastermind.models.Error error;
		mastermind.models.Color[] colors;
		do {
			String characters = this.console.readString(Message.PROPOSED_COMBINATION.getMessage());
			colors = new mastermind.models.Color[characters.length()];
			for (int i = 0; i < characters.length(); i++) {
				colors[i] = Color.getInstance(characters.charAt(i));
			}
			error = ProposedCombination.isValid(colors);
			if (error != null) {
				Error.values()[error.ordinal()].write();
			}
		} while (error != null);
		this.proposedCombination.set(colors);
	}
}
