package bonusMenu;

import java.awt.Image;

import graphics.Description;
import button.DescriptiveButton;
import main.Window;

public class InterestBonus extends DescriptiveButton {

	private static final long serialVersionUID = 1L;

	public InterestBonus(int x, int y, int width, int height,
			Image imageEnabled, Image imageDisabled,Description description) {
		super(x, y, width, height, imageEnabled, imageDisabled, description);
	}

	@Override
	public void clickAction() {
		Window.getInstance().getPlayPanel().getGame().getStats().setInterest(Window.getInstance().getPlayPanel().getGame().getStats().getInterest()+3);
		Window.getInstance().getPlayPanel().getGame().getStats().setBonus(Window.getInstance().getPlayPanel().getGame().getStats().getBonus()-1);
	}
	
}
