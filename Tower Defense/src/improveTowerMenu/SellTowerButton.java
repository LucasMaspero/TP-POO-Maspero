package improveTowerMenu;

import java.awt.Image;
import button.EnablingButton;
import main.Window;
import game.Container;

public class SellTowerButton extends EnablingButton {

	private static final long serialVersionUID = 1L;

	public SellTowerButton(int x, int y, int width, int height, Image imageEnabled) {
		super(x, y, width, height, imageEnabled, imageEnabled);
	}

	@Override
	public void clickAction() {
		
		int x = Window.getInstance().getPlayPanel().getImproveTowerMenu().getSelectedTower().getxMap();
		int y = Window.getInstance().getPlayPanel().getImproveTowerMenu().getSelectedTower().getyMap();
		
		((Container)Window.getInstance().getPlayPanel().getGame().getMap().getMapRepresentation()[y][x]).deleteTower();
		
		Window.getInstance().getPlayPanel().getGame().getStats().setMoney(Window.getInstance().getPlayPanel().getGame().getStats().getMoney()+Window.getInstance().getPlayPanel().getImproveTowerMenu().getSelectedTower().getPrice()/2);
		
		Window.getInstance().getPlayPanel().getImproveTowerMenu().clear();
		
	}

	
	
}
