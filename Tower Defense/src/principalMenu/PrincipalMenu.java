package principalMenu;

import java.awt.Graphics;
import java.awt.Point;
import main.Window;
import graphics.Drawable;
import graphics.MouseUse;

public class PrincipalMenu implements Drawable, MouseUse {

	// Dimensiones
	private static final int EXIT_BUTTON_HEIGHT = 68;
	private static final int EXIT_BUTTON_WIDTH = 98;
	private static final int PLAY_BUTTON_HEIGHT = 118;
	private static final int PLAY_BUTTON_WIDTH = 205;
	private static final int LOAD_BUTTON_HEIGHT = 105;
	private static final int LOAD_BUTTON_WIDTH = 285;
	private static final int INFO_BUTTON_HEIGHT = 66;
	private static final int INFO_BUTTON_WIDTH = 134;
	
	// Coordenadas
	private static final int EXIT_BUTTON_X = 67;
	private static final int EXIT_BUTTON_Y = 413;
	private static final int PLAY_BUTTON_X = 512;
	private static final int PLAY_BUTTON_Y = 572;
	private static final int LOAD_BUTTON_X = 856;
	private static final int LOAD_BUTTON_Y = 613;
	private static final int INFO_BUTTON_X = 277;
	private static final int INFO_BUTTON_Y = 471;
	
	// Botones
	private ExitButton exitButton;
	private LoadGameButton loadGameButton;
	private PlayButton playButton;
	private InfoButton infoButton;
	
	public PrincipalMenu() {
		
		exitButton = new ExitButton(EXIT_BUTTON_X,EXIT_BUTTON_Y,EXIT_BUTTON_WIDTH,EXIT_BUTTON_HEIGHT,Window.getInstance().getPrincipalPanel().getTileset_exit_buttons().getImage(0),Window.getInstance().getPrincipalPanel().getTileset_exit_buttons().getImage(1));
		loadGameButton = new LoadGameButton(LOAD_BUTTON_X,LOAD_BUTTON_Y,LOAD_BUTTON_WIDTH,LOAD_BUTTON_HEIGHT,Window.getInstance().getPrincipalPanel().getTileset_load_buttons().getImage(0),Window.getInstance().getPrincipalPanel().getTileset_load_buttons().getImage(1));
		playButton = new PlayButton(PLAY_BUTTON_X,PLAY_BUTTON_Y,PLAY_BUTTON_WIDTH,PLAY_BUTTON_HEIGHT,Window.getInstance().getPrincipalPanel().getTileset_play_buttons().getImage(0),Window.getInstance().getPrincipalPanel().getTileset_play_buttons().getImage(1));
		infoButton = new InfoButton(INFO_BUTTON_X,INFO_BUTTON_Y,INFO_BUTTON_WIDTH,INFO_BUTTON_HEIGHT,Window.getInstance().getPrincipalPanel().getTileset_info_buttons().getImage(0),Window.getInstance().getPrincipalPanel().getTileset_info_buttons().getImage(1));
		
	}

	@Override
	public void click(Point p, int button) {
		
		exitButton.click(p, button);
		loadGameButton.click(p, button);
		playButton.click(p, button);
		infoButton.click(p, button);

	}

	@Override
	public void drag(Point p) {
		
		exitButton.drag(p);
		loadGameButton.drag(p);
		playButton.drag(p);
		infoButton.drag(p);
		
	}

	@Override
	public void draw(Graphics g) {

		exitButton.draw(g);
		loadGameButton.draw(g);
		playButton.draw(g);
		infoButton.draw(g);
		
	}
	
}
