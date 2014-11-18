package principalMenu;

import java.awt.Image;
import button.SelectedImageButton;
import selectMapPanel.*;
import main.Window;

public class PlayButton extends SelectedImageButton {

	private static final long serialVersionUID = 1L;

	public PlayButton(int x, int y, int width, int height, Image icon, Image selectedImage) {
		super(x, y, width, height, icon, selectedImage);
	}

	@Override
	public void clickAction() {
		Window.getInstance().switchPanel(SelectMapPanel.PANEL_ID);
	}
	
}
