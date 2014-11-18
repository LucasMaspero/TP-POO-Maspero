package playMenu;

import java.awt.Image;
import button.EnablingButton;
import main.Window;

public class PauseButton extends EnablingButton {

	private static final long serialVersionUID = 1L;

	public PauseButton(int x, int y, int width, int height,
			Image imageEnabled, Image imageDisabled) {
		super(x, y, width, height, imageEnabled, imageDisabled);
	}

	@Override
	public void clickAction() {
		
		Window.getInstance().getPlayPanel().getGame().cleanSaveMessages();

		// Si estaba en pausa, retomamos el juego.
		if(Window.getInstance().getPlayPanel().getGame().isPaused()) {
			Window.getInstance().getPlayPanel().getGame().setPaused(false);
			if(Window.getInstance().getPlayPanel().getGame().getWave() == null || Window.getInstance().getPlayPanel().getGame().getWave().hasFinished()) {
				Window.getInstance().getPlayPanel().getMenu().getSendThreatsButton().enable();
				Window.getInstance().getPlayPanel().getMenu().getSaveGameButton().enable();
			}
		} else {
			// Si no estaba en pausa, pausamos.
			Window.getInstance().getPlayPanel().getGame().setPaused(true);
			Window.getInstance().getPlayPanel().getMenu().getSendThreatsButton().disable();
			Window.getInstance().getPlayPanel().getMenu().getSaveGameButton().disable();
		}
	}
	
}
