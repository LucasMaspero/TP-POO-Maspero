package button;

import graphics.MouseUse;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

public abstract class EnablingButton extends Button {
	
	private static final long serialVersionUID = 1L;
	
	private boolean isEnabled = true;
	private Image imageDisabled;

	public EnablingButton(int x, int y, int width, int height, Image imageEnabled, Image imageDisabled) {
		super(x, y, width, height, imageEnabled);
		this.imageDisabled = imageDisabled;
	}

	@Override
	public void click(Point p, int button) {
		if(isEnabled()) {
			if(contains(p) && button == MouseUse.LEFT_CLICK) {
				clickAction();
			}
		}
	}
	
	public abstract void clickAction();
	
	public void disable() {
		isEnabled = false;
	}

	public void enable() {
		isEnabled = true;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	@Override
	public void draw(Graphics g) {

		if(isEnabled()) {
			g.drawImage(getIcon(), x, y, width, height, null);

		} else{
			g.drawImage(imageDisabled, x, y, width, height, null);
		}
		
		// Animación cuando el cursor pasa por encima del botón.
		if(isDrag()) {
			g.setColor(new Color(184,207,229));
			g.drawRect(x,y, width, height);
			g.drawRect(x+2,y+2, width-4, height-4);
			g.setColor(new Color(122,138,153));
			g.drawRect(x+1,y+1, width-2, height-2);
		}
		
	}

	public Image getImageDisabled() {
		return imageDisabled;
	}

	public void setImageDisabled(Image imageDisabled) {
		this.imageDisabled = imageDisabled;
	}
	
}
