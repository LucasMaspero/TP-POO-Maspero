package improveTowerMenu;

import java.awt.Image;
import button.EnablingButton;
import main.Window;
import towers.Tower;

public class PlusDamageButton extends EnablingButton {
	
	private static final long serialVersionUID = 1L;

	public PlusDamageButton(int x, int y, int width, int height, Image imageEnabled, Image imageDisabled) {
		super(x, y, width, height, imageEnabled, imageDisabled);
	}

	@Override
	public void clickAction() {
		
		Tower t = Window.getInstance().getPlayPanel().getImproveTowerMenu().getSelectedTower();
		
		t.incrementDamage();
		
		t.setPrice(t.getPrice() + Window.getInstance().getPlayPanel().getImproveTowerMenu().getIncrementDamageCost());
		
		Window.getInstance().getPlayPanel().getGame().getStats().setMoney(Window.getInstance().getPlayPanel().getGame().getStats().getMoney()-Window.getInstance().getPlayPanel().getImproveTowerMenu().getIncrementDamageCost());
			
	}

}
