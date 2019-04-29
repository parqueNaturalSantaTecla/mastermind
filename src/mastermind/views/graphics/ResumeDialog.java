package mastermind.views.graphics;

import javax.swing.JOptionPane;

import mastermind.views.MessageView;

class ResumeDialog {

	private boolean resume;

	ResumeDialog() {
		this.resume = (JOptionPane.showConfirmDialog(null, MessageView.RESUME.getMessage(), MessageView.TITLE.getMessage(),
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
	}

	boolean isResumed() {
		return this.resume;
	}

}
