package mastermind.views.console;

import mastermind.types.Color;
import santaTecla.utils.Console;

class ColorView extends mastermind.views.ColorView {

	ColorView(Color color) {
		super(color);
	}
	
	void write() {
		new Console().write(ColorView.INITIALS[this.color.ordinal()]);
	}

}
