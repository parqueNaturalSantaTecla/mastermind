package mastermind.distributed;

import mastermind.ConsoleMastermind;
import mastermind.controllers.Logic;

public class ConsoleMastermindClient extends ConsoleMastermind{
	
	private LogicProxy logicProxy;
	
	@Override
	protected Logic createLogic() {
		this.logicProxy = new LogicProxy();
		return this.logicProxy;
	}
	
	@Override
	protected void play() {
		super.play();
		this.logicProxy.close();
	}
	
	public static void main(String[] args) {
		new ConsoleMastermindClient().play();
	}

}
