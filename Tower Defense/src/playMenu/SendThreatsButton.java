package playMenu;

import java.awt.Image;
import button.EnablingButton;
import main.Window;

public class SendThreatsButton extends EnablingButton {

	private static final long serialVersionUID = 1L;

	public SendThreatsButton(int x, int y, int width, int height,
			Image imageEnabled, Image imageDisabled) {
		super(x, y, width, height, imageEnabled, imageDisabled);
	}

	@Override
	public void clickAction() {
		Window.getInstance().getPlayPanel().getGame().cleanSaveMessages();
		Window.getInstance().getPlayPanel().getGame().increaseLevel();
		Window.getInstance().getPlayPanel().getMenu().getSendThreatsButton().disable();
		Window.getInstance().getPlayPanel().getMenu().getSaveGameButton().disable();
	}
	
}
