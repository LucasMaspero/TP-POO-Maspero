package button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public abstract class BorderButton extends Button {
	
	private static final long serialVersionUID = 1L;

	public BorderButton(int x, int y, int width, int height, Image icon) {
		super(x, y, width, height, icon);
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(getIcon(),x,y,width,height,null);
		
		// Animación cuando el cursor pasa por encima del botón.
		if(isDrag()) {
			g.setColor(new Color(184,207,229));
			g.drawRect(x,y, width, height);
			g.drawRect(x+2,y+2, width-4, height-4);
			g.setColor(new Color(122,138,153));
			g.drawRect(x+1,y+1, width-2, height-2);
		}
	}

}
