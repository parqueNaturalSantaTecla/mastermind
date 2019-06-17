package mastermind.controllers;

import mastermind.views.ErrorView;

import java.util.List;

import mastermind.models.Session;
import mastermind.models.Combination;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.views.ProposedCombinationView;

class ProposalController extends InGameController {

	ProposalController(Session session) {
		super(session);
	}

	@Override
	public void inGameControl() {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView().read();
			error = this.addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
	}
	
	private Error addProposedCombination(List<Color> colors) {
		Error error = null;
		if (colors.size() != Combination.getWidth()) {
			error = Error.WRONG_LENGTH;
		} else {
			for (int i = 0; i < colors.size(); i++) {
				if (colors.get(i) == null) {
					error = Error.WRONG_CHARACTERS;
				} else {
					for (int j = i + 1; j < colors.size(); j++) {
						if (colors.get(i) == colors.get(j)) {
							error = Error.DUPLICATED;
						}
					}
				}
			}
		}
		if (error == null) {
			this.session.addProposedCombination(colors);
			if (this.session.isWinner()	|| this.session.isLooser()) {
				this.session.next();
			}
		}
		return error;
	}

}
