package gameModeMenu;

import java.awt.Graphics;
import java.awt.Point;
import main.Window;
import button.BorderButton;
import graphics.*;

public class GameModeMenu implements Drawable, MouseUse {

	// Dimensiones de los botones.
	private final static int BACK_HEIGHT = 91;
	private final static int BACK_WIDTH = 211;
	private final static int GAMEMODE_BUTTON_HEIGHT = 241;	
	private final static int GAMEMODE_BUTTON_WIDTH = 306;
	
	// Posiciones de los botones.
	private final static int BACK_BUTTON_X = 480;
	private final static int BACK_BUTTON_Y = 760;
	private final static int GAMEMODE_BUTTON_X = 55;
	private final static int GAMEMODE_BUTTON_Y = 340;
	private final static int GAMEMODE_BUTTON_GAP = 74;
	
	// Cantidad de gamemodes.
	private final static int NUMBER_OF_GAMEMODES = 3;
	
	// Botones
	private BorderButton[] gameModeButtons = new BorderButton[NUMBER_OF_GAMEMODES];
	private BorderButton backButton;
	
	public GameModeMenu() {
		
		backButton = new BackButtonGameMode(BACK_BUTTON_X,BACK_BUTTON_Y,BACK_WIDTH,BACK_HEIGHT,Window.getInstance().getSelectGameModePanel().getBackButton());
		
		for(int i = 0 ; i < gameModeButtons.length ; i++) {
			gameModeButtons[i] = new SelectGameModeButton( (GAMEMODE_BUTTON_X+(GAMEMODE_BUTTON_WIDTH+GAMEMODE_BUTTON_GAP)*i), GAMEMODE_BUTTON_Y, GAMEMODE_BUTTON_WIDTH, GAMEMODE_BUTTON_HEIGHT, Window.getInstance().getSelectGameModePanel().getTileset_gamemode_buttons().getImage(i),i);
		}
		
	}
	
	@Override
	public void click(Point p, int button) {
	
		backButton.click(p, button);
		for(int i = 0 ; i < gameModeButtons.length ; i++) {
			gameModeButtons[i].click(p, button);
		}
		
	}

	@Override
	public void drag(Point p) {
		
		backButton.drag(p);
		for(int i = 0 ; i < gameModeButtons.length ; i++) {
			gameModeButtons[i].drag(p);
		}
		
	}

	@Override
	public void draw(Graphics g) {
		
		backButton.draw(g);
		for(int i = 0 ; i < gameModeButtons.length ; i++) {
			gameModeButtons[i].draw(g);
		}
		
	}
	
}
