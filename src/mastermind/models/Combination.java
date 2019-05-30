package mastermind.models;

import java.util.ArrayList;
import java.util.List;

import mastermind.types.Color;

abstract class Combination {
	
	private static final int WIDTH = 4;

	protected List<Color> colors;
	
	protected Combination (){
		this.colors = new ArrayList<Color>();
	}
	
	static int getWidth() {
		return Combination.WIDTH;
	}
	
	public List<Color> getColors(){
		return this.colors;
	}
	
}
