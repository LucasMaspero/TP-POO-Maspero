package button;

import java.awt.Graphics;
import java.awt.Image;

import main.Window;
import graphics.Description;

public abstract class DescriptiveButton extends EnablingButton {

	private static final long serialVersionUID = 1L;

	public DescriptiveButton(int x, int y, int width, int height,
			Image imageEnabled, Image imageDisabled,Description description) {
		super(x, y, width, height, imageEnabled, imageDisabled);
		this.description = description;
	}

	private Description description;
	
	public Description getDescription() {
		return description;
	}
	
	@Override
	public void draw(Graphics g) {
		
		super.draw(g);
		
		if(isDrag()) {
			Window.getInstance().getPlayPanel().clearConsole();
			getDescription().draw(g);
		}
		
	}
	
}
