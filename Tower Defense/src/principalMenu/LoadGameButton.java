package principalMenu;

import java.awt.Image;
import button.*;
import main.Window;
import playPanel.PlayPanel;

public class LoadGameButton extends SelectedImageButton {

	private static final long serialVersionUID = 1L;

	public LoadGameButton(int x, int y, int width, int height, Image icon, Image selectedImage) {
		super(x, y, width, height, icon, selectedImage);
	}

	@Override
	public void clickAction() {
		Window.getInstance().switchPanel(PlayPanel.PANEL_ID);
		Window.getInstance().getPlayPanel().loadGame();
		Window.getInstance().getPlayPanel().getGame().setShowGameHasBeenSaved(false);
	}
	
}
