package selectMapPanel;

import graphics.TileSet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import mapMenu.MapMenu;

public class SelectMapPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	// ID
	public final static int PANEL_ID = 2;

	// Mapa seleccionado.
	private int selectedMap;
	
	// Flag para fijarse si es la primera vez que estamos cargando.
	private boolean isFirstTimeLoading = true;
	
	// Dimensiones del panel.
	private int panelWidth;
	private int panelHeight;
	
	// Imágenes que utiliza el panel.
	private Image background;
	private Image backButton;
	private TileSet tileset_map_buttons;
	
	private MapMenu mapMenu;
	
	// Dimensiones de los botones.
	private final static int MAP_BUTTON_HEIGHT = 241;	
	private final static int MAP_BUTTON_WIDTH = 306;
	
	// Mouse
	MouseHandlerMap mouseHandler;
	
	public SelectMapPanel() {
		
		tileset_map_buttons = new TileSet(3);
		
		// Mouse Listeners.
		mouseHandler = new MouseHandlerMap();

	}
	
	// Cargando recursos.
	private void loadResources() {
		
		background = new ImageIcon("res/SelectAMap/selectAMap.png").getImage();
		backButton = new ImageIcon("res/Back/buttonBack.png").getImage();
		
		for(int i = 0; i < tileset_map_buttons.getLength() ; i++) {
			tileset_map_buttons.setImage(createImage(new FilteredImageSource(new ImageIcon("res/Maps/tileset_maps.png").getImage().getSource(),new CropImageFilter(0,MAP_BUTTON_HEIGHT*i,MAP_BUTTON_WIDTH,MAP_BUTTON_HEIGHT))), i);
		}
			
		mapMenu = new MapMenu();
		
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);
		
	}

	public int getSelectedMap() {
		return selectedMap;
	}
	
	public void selectMap(int map) {
		this.selectedMap = map;
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
		mapMenu.draw(g);
		
		repaint();
		
	}
	
	public Image getBackButton() {
		return backButton;
	}

	public TileSet getTileset_map_buttons() {
		return tileset_map_buttons;
	}

	public MapMenu getMapMenu() {
		return mapMenu;
	}

}
