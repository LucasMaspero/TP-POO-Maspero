package button;

import java.awt.Graphics;
import java.awt.Image;

public abstract class SelectedImageButton extends Button {
	
	private static final long serialVersionUID = 1L;
	
	private Image selectedImage;

	public SelectedImageButton(int x, int y, int width, int height, Image icon, Image selectedImage) {
		super(x, y, width, height, icon);
		this.selectedImage = selectedImage;
	}

	@Override
	public void draw(Graphics g) {
		if(isDrag()) {
			g.drawImage(getSelectedImage(),x,y,width,height,null);
		} else {
			g.drawImage(getIcon(),x,y,width,height,null);
		}
	}

	public Image getSelectedImage() {
		return selectedImage;
	}
	
}
