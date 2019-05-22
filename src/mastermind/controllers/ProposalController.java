package mastermind.controllers;

import java.util.List;

import mastermind.models.Combination;
import mastermind.models.Session;
import mastermind.models.SessionImplementation;
import mastermind.types.Color;
import mastermind.types.Error;

public class ProposalController extends Controller {

	public ProposalController(Session session) {
		super(session);
	}

	public Error addProposedCombination(List<Color> colors) {
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
			((SessionImplementation) this.session).addProposedCombination(colors);
			if (((SessionImplementation) this.session).isWinner()
					|| ((SessionImplementation) this.session).isLooser()) {
				((SessionImplementation) this.session).next();
			}
		}
		return error;
	}

	public boolean isWinner() {
		return ((SessionImplementation) this.session).isWinner();
	}

	public boolean isLooser() {
		return ((SessionImplementation) this.session).isLooser();
	}

	public int getAttempts() {
		return ((SessionImplementation) this.session).getAttempts();
	}

	public List<Color> getColors(int i) {
		return ((SessionImplementation) this.session).getColors(i);
	}

	public int getBlacks(int i) {
		return ((SessionImplementation) this.session).getBlacks(i);
	}

	public int getWhites(int i) {
		return ((SessionImplementation) this.session).getWhites(i);
	}

}
