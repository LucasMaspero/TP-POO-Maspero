package button;

import graphics.Drawable;
import graphics.MouseUse;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Button extends Rectangle implements Drawable, MouseUse {
	
	private static final long serialVersionUID = 1L;
	
	private Image icon;
	private boolean isDrag = false;
	
	public Button(int x, int y, int width, int height, Image icon) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.icon = icon;
	}
	
	@Override
	public void drag(Point p) {
		if(contains(p)) {
			isDrag = true;
		} else {
			isDrag = false;
		}
	}
	
	@Override
	public void click(Point p, int button) {
		if(button == MouseUse.LEFT_CLICK && contains(p)) {
			clickAction();
		}
	}
	
	public abstract void clickAction();

	public Image getIcon() {
		return icon;
	}

	public void setIcon(Image icon) {
		this.icon = icon;
	}

	public boolean isDrag() {
		return isDrag;
	}

}
