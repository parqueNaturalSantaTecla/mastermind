package mastermind.views;

import mastermind.models.Session;

public abstract class Command extends santaTecla.utils.Command {
	
	protected Session session;
	
	protected Command(String title, Session session) {
		super(title);
		this.session = session;
	}

	@Override
	public abstract void updateIsActive();

}
