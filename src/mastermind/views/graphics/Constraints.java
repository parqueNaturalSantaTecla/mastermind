package mastermind.views.graphics;

import java.awt.GridBagConstraints;

public class Constraints {

	private GridBagConstraints gridBagConstrains;

	public Constraints(int gridX, int gridY, int gridWidth, int gridHeight) {
		this.gridBagConstrains = new GridBagConstraints();
		this.gridBagConstrains.gridx = gridX;
		this.gridBagConstrains.gridy = gridY;
		this.gridBagConstrains.gridwidth = gridWidth;
		this.gridBagConstrains.gridheight = gridHeight;
		this.gridBagConstrains.fill = 1;
	}
	
	public GridBagConstraints getConstraints() {
		return this.gridBagConstrains;
	}
}
