package mastermind.views.console;

import mastermind.controllers.SaveController;
import mastermind.controllers.PlayController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.views.View;

public class ConsoleView extends View {
	
	private StartView startView;
	
	private PlayView playView;
	
	private SaveView saveView;
	
	private ResumeView resumeView;
	
	public ConsoleView(){
		this.startView = new StartView();
		this.playView = new PlayView();
		this.saveView = new SaveView();
		this.resumeView = new ResumeView();
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);		
	}

	@Override
	public void visit(PlayController playController) {
		this.playView.interact(playController);
	}
	
	@Override
	public void visit(SaveController saveController) {
		this.saveView.interact(saveController);
	}

	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}

}
