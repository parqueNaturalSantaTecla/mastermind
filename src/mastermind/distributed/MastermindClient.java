package mastermind.distributed;

import mastermind.Mastermind;

public class MastermindClient extends Mastermind{
	
	public MastermindClient() {
		Mastermind.logic = new LogicProxy();
	}
	
	@Override
	protected void play() {
		super.play();
		((LogicProxy) Mastermind.logic).close();
	}
	
	public static void main(String[] args) {
		new MastermindClient().play();
	}

}
