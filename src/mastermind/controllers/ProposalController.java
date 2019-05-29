package mastermind.controllers;

import mastermind.views.ErrorView;

import java.util.List;

import mastermind.models.Session;
import mastermind.models.Combination;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.views.ProposedCombinationView;

public class ProposalController extends InGameController {

	public static final int NO_ERROR = -1;

	public ProposalController(Session session) {
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
			this.session.addProposedCombination(colors);
			if (this.session.isWinner()	|| this.session.isLooser()) {
				this.session.next();
			}
		}
		return error;
	}

//	public int proposeCombination(int[] codes) {
//		mastermind.types.Error error = ProposedCombination.isValid(codes);
//		if (error != null) {
//			return error.ordinal();
//		}
//		ProposedCombination proposedCombination = ProposedCombination.getInstance(codes);
//		this.session.addProposedCombination(proposedCombination);
//		if (this.session.isWinner() || this.session.isLooser()) {
//			this.session.next();
//		}
//		return ProposalController.NO_ERROR;
//	}

	public List<Color> getColors(int position) {
		return this.session.getColors(position);
	}

	public int getTurn() {
		return this.session.getAttempts();
	}

	public boolean isWinner() {
		return this.session.isWinner();
	}

	public boolean isLooser() {
		return this.session.isLooser();
	}

}
