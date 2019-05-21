package mastermind.controllers;

import java.util.List;

import mastermind.models.Combination;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;

class ProposalController extends Controller {

	ProposalController(Session session) {
		super(session);
	}

	Error addProposedCombination(List<Color> colors) {
		Error error = null;
		if (colors.size() != Combination.getWidth()) {
			error = Error.WRONG_LENGTH;
		} else {
			for (int i = 0; i < colors.size(); i++) {
				if (colors.get(i) == null) {
					error = Error.WRONG_CHARACTERS;
				} else {
					for (int j = i+1; j < colors.size(); j++) {
						if (colors.get(i) == colors.get(j)) {
							error = Error.DUPLICATED;
						}
					}
				}				
			}
		}
		if (error == null){
			this.session.addProposedCombination(colors);
			if (this.session.isWinner() || this.session.isLooser()) {
				this.session.next();
			}
		}
		return error;	
	}

	boolean isWinner() {
		return this.session.isWinner();
	}

	boolean isLooser() {
		return this.session.isLooser();
	}
	
	int getAttempts() {
		return this.session.getAttempts();
	}

	List<Color> getColors(int i) {
		return this.session.getColors(i);
	}

	int getBlacks(int i) {
		return this.session.getBlacks(i);
	}

	int getWhites(int i) {
		return this.session.getWhites(i);
	}

}
