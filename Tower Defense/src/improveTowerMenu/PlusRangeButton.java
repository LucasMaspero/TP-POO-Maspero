package improveTowerMenu;

import java.awt.Image;
import button.EnablingButton;
import towers.Tower;
import main.Window;

public class PlusRangeButton extends EnablingButton {
	
	private static final long serialVersionUID = 1L;

	public PlusRangeButton(int x, int y, int width, int height, Image imageEnabled, Image imageDisabled) {
		super(x, y, width, height, imageEnabled, imageDisabled);
	}

	@Override
	public void clickAction() {
		
		Tower t = Window.getInstance().getPlayPanel().getImproveTowerMenu().getSelectedTower();
		
		t.incrementRange();
		
		t.setPrice(t.getPrice() + Window.getInstance().getPlayPanel().getImproveTowerMenu().getIncrementRangeCost());
		
		Window.getInstance().getPlayPanel().getGame().getStats().setMoney(Window.getInstance().getPlayPanel().getGame().getStats().getMoney()-Window.getInstance().getPlayPanel().getImproveTowerMenu().getIncrementRangeCost());
			
	}

}
