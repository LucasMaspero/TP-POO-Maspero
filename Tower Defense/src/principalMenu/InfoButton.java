package principalMenu;

import infoPanel.InfoPanel;
import java.awt.Image;
import main.Window;
import button.SelectedImageButton;

public class InfoButton extends SelectedImageButton {

	private static final long serialVersionUID = 1L;

	public InfoButton(int x, int y, int width, int height, Image icon, Image selectedImage) {
		super(x, y, width, height, icon, selectedImage);
	}

	@Override
	public void clickAction() {
		Window.getInstance().switchPanel(InfoPanel.PANEL_ID);
	}

}
