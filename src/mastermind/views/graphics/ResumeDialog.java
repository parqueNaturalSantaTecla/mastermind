package mastermind.views.graphics;

import javax.swing.JOptionPane;

import mastermind.views.Message;

class ResumeDialog {

	private boolean resume;
	
	ResumeDialog() {
		this.resume = (JOptionPane.showConfirmDialog(null, Message.RESUME.getMessage(), Message.TITLE.getMessage(),
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
	}
	
	boolean isResumed() {
		return this.resume;
	}

}
