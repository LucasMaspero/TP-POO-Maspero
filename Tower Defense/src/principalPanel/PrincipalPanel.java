package principalPanel;

import graphics.TileSet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;

import principalMenu.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PrincipalPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	// ID
	public final static int PANEL_ID = 0;
	
	// Imágenes que utiliza el panel.
	private Image background;
	private TileSet tileset_exit_buttons;
	private TileSet tileset_play_buttons;
	private TileSet tileset_load_buttons;
	private TileSet tileset_info_buttons;
	
	// Dimensiones
	private static final int EXIT_BUTTON_HEIGHT = 68;
	private static final int EXIT_BUTTON_WIDTH = 98;
	private static final int PLAY_BUTTON_HEIGHT = 118;
	private static final int PLAY_BUTTON_WIDTH = 205;
	private static final int LOAD_BUTTON_HEIGHT = 105;
	private static final int LOAD_BUTTON_WIDTH = 285;
	private static final int INFO_BUTTON_HEIGHT = 66;
	private static final int INFO_BUTTON_WIDTH = 134;
	
	// Flag para fijarse si es la primera vez que estamos cargando.
	private boolean isFirstTimeLoading = true;
	
	// Dimensiones del panel.
	private int panelWidth;
	private int panelHeight;
	
	// Menu
	private PrincipalMenu menu;
	
	// Mouse
	MouseHandlerPrincipal mouseHandler;
	
	public PrincipalPanel() {
		
		mouseHandler = new MouseHandlerPrincipal();
		
		tileset_exit_buttons = new TileSet(2);
		tileset_play_buttons = new TileSet(2);
		tileset_load_buttons = new TileSet(2);
		tileset_info_buttons = new TileSet(2);
		
	}
	
	// Cargando recursos.
	private void loadResources() {
	
		for(int i = 0 ; i < tileset_exit_buttons.getLength() ; i++) {
			tileset_exit_buttons.setImage(createImage(new FilteredImageSource(new ImageIcon("res/MenuPrincipal/tileset_exit_button.png").getImage().getSource(),new CropImageFilter(0,EXIT_BUTTON_HEIGHT*i,EXIT_BUTTON_WIDTH,EXIT_BUTTON_HEIGHT))), i);
		}
		
		for(int i = 0 ; i < tileset_play_buttons.getLength() ; i++) {
			tileset_play_buttons.setImage(createImage(new FilteredImageSource(new ImageIcon("res/MenuPrincipal/tileset_play_button.png").getImage().getSource(),new CropImageFilter(0,PLAY_BUTTON_HEIGHT*i,PLAY_BUTTON_WIDTH,PLAY_BUTTON_HEIGHT))), i);
		}
		
		for(int i = 0 ; i < tileset_load_buttons.getLength() ; i++) {
			tileset_load_buttons.setImage(createImage(new FilteredImageSource(new ImageIcon("res/MenuPrincipal/tileset_load_button.png").getImage().getSource(),new CropImageFilter(0,LOAD_BUTTON_HEIGHT*i,LOAD_BUTTON_WIDTH,LOAD_BUTTON_HEIGHT))), i);
		}
		
		for(int i = 0 ; i < tileset_info_buttons.getLength() ; i++) {
			tileset_info_buttons.setImage(createImage(new FilteredImageSource(new ImageIcon("res/MenuPrincipal/tileset_info_button.png").getImage().getSource(),new CropImageFilter(0,INFO_BUTTON_HEIGHT*i,INFO_BUTTON_WIDTH,INFO_BUTTON_HEIGHT))), i);
		}
			
		background = new ImageIcon("res/MenuPrincipal/menuBackground.png").getImage();
		
		menu = new PrincipalMenu();
		
		// Mouse Listeners.
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);
			
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
		menu.draw(g);
		
		repaint();
		
	}
	
	public PrincipalMenu getMenu() {
		return menu;
	}

	public TileSet getTileset_exit_buttons() {
		return tileset_exit_buttons;
	}

	public TileSet getTileset_play_buttons() {
		return tileset_play_buttons;
	}

	public TileSet getTileset_load_buttons() {
		return tileset_load_buttons;
	}

	public TileSet getTileset_info_buttons() {
		return tileset_info_buttons;
	}
	
}
