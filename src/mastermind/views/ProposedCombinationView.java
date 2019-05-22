package mastermind.views;

import java.util.ArrayList;
import java.util.List;

import mastermind.controllers.GameController;
import mastermind.types.Color;
import mastermind.utils.WithConsoleView;
import mastermind.views.menus.ColorView;
import mastermind.views.menus.MessageView;

public class ProposedCombinationView extends WithConsoleView {
	
	private GameController gameController;
	
	public ProposedCombinationView(GameController gameController) {
		this.gameController = gameController;
	}
	
	void write(int i) {
		for (Color color : this.gameController.getColors(i)) {
			new ColorView(color).write();
		}
	}

	public List<Color> read() {
		String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<characters.length(); i++) {
			colors.add(ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
	}
	
}
