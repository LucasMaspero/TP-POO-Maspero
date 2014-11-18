package playMenu;

import java.awt.Image;

import button.EnablingButton;
import principalPanel.PrincipalPanel;
import main.Window;

public class QuitButton extends EnablingButton {

	private static final long serialVersionUID = 1L;

	public QuitButton(int x, int y, int width, int height,
			Image imageEnabled, Image imageDisabled) {
		super(x, y, width, height, imageEnabled, imageDisabled);
	}

	@Override
	public void clickAction() {
		Window.getInstance().getPlayPanel().getGame().cleanSaveMessages();
		Window.getInstance().switchPanel(PrincipalPanel.PANEL_ID);
		Window.getInstance().getPlayPanel().getThread().stop();
		Window.getInstance().getPlayPanel().removeAll();
	}
	
}
