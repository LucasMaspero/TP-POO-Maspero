package principalMenu;

import java.awt.Image;
import button.SelectedImageButton;

public class ExitButton extends SelectedImageButton {

	private static final long serialVersionUID = 1L;

	public ExitButton(int x, int y, int width, int height, Image icon, Image selectedImage) {
		super(x, y, width, height, icon, selectedImage);
	}

	@Override
	public void clickAction() {
		System.exit(0);
	}
	
}
