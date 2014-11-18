package playMenu;

import java.awt.Image;
import java.io.IOException;
import button.EnablingButton;
import main.Window;

public class SaveGameButton extends EnablingButton {

	private static final long serialVersionUID = 1L;

	public SaveGameButton(int x, int y, int width, int height,
			Image imageEnabled, Image imageDisabled) {
		super(x, y, width, height, imageEnabled, imageDisabled);
	}

	@Override
	public void clickAction() {
		try {
			Window.getInstance().getPlayPanel().getGame().setShowGameHasBeenSaved(true);
			Window.getInstance().getPlayPanel().getGameManager().saveGame(Window.getInstance().getPlayPanel().getGame());
		} catch (IOException e) {
			e.printStackTrace();
			Window.getInstance().getPlayPanel().getGame().setShowGameCouldntBeSaved(true);
		}
	}
	
}
