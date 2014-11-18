package bonusMenu;

import java.awt.Image;
import button.DescriptiveButton;
import game.Container;
import graphics.Description;
import main.Window;
import towers.Tower;

public class ExtraDamageBonus extends DescriptiveButton {
	
	private static final long serialVersionUID = 1L;

	public ExtraDamageBonus(int x, int y, int width, int height,
			Image imageEnabled, Image imageDisabled,Description description) {
		super(x, y, width, height, imageEnabled, imageDisabled, description);
	}

	@Override
	public void clickAction() {
		
		Tower t;
		
		for(int x = 0 ; x < Window.getInstance().getPlayPanel().getGame().getMap().getMapRepresentation().length ; x++) {
			for(int y = 0 ; y < Window.getInstance().getPlayPanel().getGame().getMap().getMapRepresentation()[0].length ; y++) {
				if(Window.getInstance().getPlayPanel().getGame().getMap().getMapRepresentation()[x][y] instanceof Container) {
					t = ((Container)Window.getInstance().getPlayPanel().getGame().getMap().getMapRepresentation()[x][y]).getTower();
					if( t != null) { 
						t.incrementDamage();
					}
				}
			}
		}
	
		Window.getInstance().getPlayPanel().getGame().getStats().setBonus(Window.getInstance().getPlayPanel().getGame().getStats().getBonus()-1);
	
		
	}

}
