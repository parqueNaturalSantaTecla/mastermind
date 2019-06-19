package mastermind;

import santaTecla.utils.WithConsoleModel;

abstract class Combination extends WithConsoleModel{
	
	private static final int WIDTH = 4;

	protected Color[] colors;
	
	protected Combination (){
		this.colors = new Color[Combination.WIDTH];
	}
	
	static int getWidth() {
		return Combination.WIDTH;
	}
	
}
