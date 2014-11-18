package playMenu;

import graphics.*;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JSlider;
import button.EnablingButton;
import main.Window;

public class PlayMenu implements Drawable, MouseUse {
	
	private static final int NUMBER_OF_MENU_BUTTONS = 4;
	
	// Coordenadas para los botones del menú.
	public static final int WIDTH_BUTTONS = 238;
	public static final int HEIGHT_BUTTONS = 30;
	private static final int X_BUTTONS = 263;
	private static final int Y_BUTTONS = 15;
	private static final int Y_CELL_SPACE = 40;
	
	// Indices
	private static final int SEND_THREATS_INDEX = 0;
	private static final int SAVE_GAME_INDEX = 1;
	private static final int PAUSE_INDEX = 2;
	private static final int QUIT_INDEX = 3;
	
	private JSlider volume = new JSlider();
	private EnablingButton[] menuButtons = new EnablingButton[NUMBER_OF_MENU_BUTTONS];
	
	public PlayMenu() {
		
		menuButtons[SEND_THREATS_INDEX] = new SendThreatsButton(X_BUTTONS,Y_BUTTONS, WIDTH_BUTTONS, HEIGHT_BUTTONS, Window.getInstance().getPlayPanel().getTileset_play_menu().getImage(0) ,Window.getInstance().getPlayPanel().getTileset_play_menu().getImage(1));
		menuButtons[SAVE_GAME_INDEX] = new SaveGameButton(X_BUTTONS,Y_BUTTONS+2*Y_CELL_SPACE, WIDTH_BUTTONS, HEIGHT_BUTTONS,Window.getInstance().getPlayPanel().getTileset_play_menu().getImage(2) ,Window.getInstance().getPlayPanel().getTileset_play_menu().getImage(3));
		menuButtons[PAUSE_INDEX] = new PauseButton(X_BUTTONS,Y_BUTTONS+3*Y_CELL_SPACE, WIDTH_BUTTONS, HEIGHT_BUTTONS,Window.getInstance().getPlayPanel().getTileset_play_menu().getImage(4) ,Window.getInstance().getPlayPanel().getTileset_play_menu().getImage(4));
		menuButtons[QUIT_INDEX] = new QuitButton(X_BUTTONS,Y_BUTTONS+4*Y_CELL_SPACE, WIDTH_BUTTONS, HEIGHT_BUTTONS,Window.getInstance().getPlayPanel().getTileset_play_menu().getImage(6) ,Window.getInstance().getPlayPanel().getTileset_play_menu().getImage(5));
	
	}
	
	@Override
	public void draw(Graphics g) {
		
		volume.setBounds(X_BUTTONS+100,60,130,20);
		
		for(int x = 0 ; x < menuButtons.length ; x++) {
			if( x == PAUSE_INDEX ) {
				if(Window.getInstance().getPlayPanel().getGame().isPaused()) {
					menuButtons[x].setIcon(Window.getInstance().getPlayPanel().getTileset_play_menu().getImage(8));
				} else {
					menuButtons[x].setIcon(Window.getInstance().getPlayPanel().getTileset_play_menu().getImage(4));
				}
			}
			menuButtons[x].draw(g);
		}
		
	}
	
	@Override
	public void click(Point p, int button) {
		
		for(int x = 0 ; x < menuButtons.length ; x++) {
			menuButtons[x].click(p, button);;
		}
		
	}

	@Override
	public void drag(Point p) {
		
		for(int x = 0 ; x < menuButtons.length ; x++) {
			menuButtons[x].drag(p);
		}
		
	}
	
	public void addVolumeSlider() {
		Window.getInstance().getPlayPanel().add(volume);
	}

	public JSlider getVolume() {
		return volume;
	}
	
	public EnablingButton getSendThreatsButton() {
		return menuButtons[SEND_THREATS_INDEX];
	}
	
	public EnablingButton getSaveGameButton() {
		return menuButtons[SAVE_GAME_INDEX];
	}
	
	public EnablingButton getPauseButton() {
		return menuButtons[PAUSE_INDEX];
	}
	
	public EnablingButton getQuitButton() {
		return menuButtons[QUIT_INDEX];
	}
	
}
