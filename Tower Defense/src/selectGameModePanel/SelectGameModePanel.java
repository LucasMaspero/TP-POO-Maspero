package selectGameModePanel;

import graphics.TileSet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import gameModeMenu.*;

public class SelectGameModePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	// ID
	public final static int PANEL_ID = 3;

	// Flag para fijarse si es la primera vez que estamos cargando.
	private boolean isFirstTimeLoading = true;
		
	// GameMode seleccionado.
	private int selectedGameMode;
	
	// Dimensiones del panel.
	private int panelWidth;
	private int panelHeight;
		
	// Imágenes que utiliza el panel.
	private Image background;
	private Image backButton;
	private TileSet tileset_gamemode_buttons;
	
	// Dimensiones de los botones.
	private final static int GAMEMODE_BUTTON_HEIGHT = 241;	
	private final static int GAMEMODE_BUTTON_WIDTH = 306;
	
	private GameModeMenu gameModeMenu;
	
	private MouseHandlerGameMode mouseHandler;
	
	public SelectGameModePanel() {
		
		tileset_gamemode_buttons = new TileSet(3);
		
		// Mouse Listeners.
		mouseHandler = new MouseHandlerGameMode();
		
	}
	
	// Cargando recursos.
	private void loadResources() {
		
		background = new ImageIcon("res/SelectAGame/selectAGameMode.png").getImage();
		backButton = new ImageIcon("res/Back/buttonBack.png").getImage();
		
		for(int i = 0; i < tileset_gamemode_buttons.getLength() ; i++) {
			tileset_gamemode_buttons.setImage(createImage(new FilteredImageSource(new ImageIcon("res/GameModes/tileset_game_modes.png").getImage().getSource(),new CropImageFilter(0,GAMEMODE_BUTTON_HEIGHT*i,GAMEMODE_BUTTON_WIDTH,GAMEMODE_BUTTON_HEIGHT))), i);
		}
		
		gameModeMenu = new GameModeMenu();
		
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);
		
	}
	
	public int getSelectedGameMode() {
		return selectedGameMode;
	}

	public void selectGameMode(int selectedGameMode) {
		this.selectedGameMode = selectedGameMode;
	}

	public void paintComponent(Graphics g) {
		
		if(isFirstTimeLoading) {
			panelWidth = getWidth();
			panelHeight = getHeight();
			loadResources();
			isFirstTimeLoading = false;
		}
		
		// Background.
		g.drawImage(background, 0, 0, panelWidth, panelHeight, null);
		gameModeMenu.draw(g);
		
		repaint();
		
	}

	public Image getBackButton() {
		return backButton;
	}

	public TileSet getTileset_gamemode_buttons() {
		return tileset_gamemode_buttons;
	}

	public GameModeMenu getGameModeMenu() {
		return gameModeMenu;
	}

}
