package mapMenu;

import java.awt.Graphics;
import java.awt.Point;
import main.Window;
import button.BorderButton;
import graphics.Drawable;
import graphics.MouseUse;

public class MapMenu  implements Drawable, MouseUse {
	
	// Dimensiones de los botones.
	private final static int BACK_HEIGHT = 91;
	private final static int BACK_WIDTH = 211;
	private final static int MAP_BUTTON_HEIGHT = 241;	
	private final static int MAP_BUTTON_WIDTH = 306;
	
	// Posiciones de los botones.
	private final static int BACK_BUTTON_X = 480;
	private final static int BACK_BUTTON_Y = 760;
	private final static int MAP_BUTTON_X = 55;
	private final static int MAP_BUTTON_Y = 340;
	private final static int MAP_BUTTON_GAP = 74;
	
	// Botones
	private BorderButton[] mapsButtons = new BorderButton[3];
	private BorderButton backButton;
	
	public MapMenu() {
		
		backButton = new BackButtonMap(BACK_BUTTON_X,BACK_BUTTON_Y,BACK_WIDTH,BACK_HEIGHT,Window.getInstance().getSelectMapPanel().getBackButton());
		
		for(int i = 0 ; i < mapsButtons.length ; i++) {
			mapsButtons[i] = new SelectMapButton( (MAP_BUTTON_X+(MAP_BUTTON_WIDTH+MAP_BUTTON_GAP)*i), MAP_BUTTON_Y, MAP_BUTTON_WIDTH, MAP_BUTTON_HEIGHT, Window.getInstance().getSelectMapPanel().getTileset_map_buttons().getImage(i),i);
		}
		
	}

	@Override
	public void click(Point p, int button) {
		
		backButton.click(p, button);
		for(int i = 0 ; i < mapsButtons.length ; i++) {
			mapsButtons[i].click(p, button);
		}
		
	}

	@Override
	public void drag(Point p) {
		
		backButton.drag(p);
		for(int i = 0 ; i < mapsButtons.length ; i++) {
			mapsButtons[i].drag(p);
		}
		
	}

	@Override
	public void draw(Graphics g) {
		
		backButton.draw(g);
		for(int i = 0 ; i < mapsButtons.length ; i++) {
			mapsButtons[i].draw(g);
		}
		
	}
	
}
