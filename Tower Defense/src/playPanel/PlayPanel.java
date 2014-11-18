package playPanel;

import game.*;
import graphics.*;
import improveTowerMenu.*;
import javax.swing.*;
import bonusMenu.*;
import playMenu.*;
import main.Window;
import threats.*;
import towers.*;
import towersMenu.*;
import java.awt.*;
import java.awt.image.*;

public class PlayPanel extends JPanel implements Runnable {
		
	private static final long serialVersionUID = 1L;

	// ID
	public final static int PANEL_ID = 1;
	
	// Componentes del panel de juego.
	private ThreatDescriptionManager threatDescriptionManager;
	private TowerMenu improveTowerMenu;
	private Computer computer;
	private BonusStore bonusStore;
	private TowerStore towerStore;
	private PlayMenu menu;
	private Game game;
	private Point pointer; // Pointer (Mouse).
	private Thread thread;
	private GameManager gameManager;
	
	// Flag para fijarse si es la primera vez que cargamos.
	private boolean isFirstTimeLoading = true;
	
	// Dimensiones del panel.
	private int panelWidth;
	private int panelHeight;
	
	// Mouse
	private MouseHandlerPlay mouseHandler;
	
	// Imágenes que utiliza el panel de juego.
	private TileSet tileset_play_menu = new TileSet(10);
	private TileSet tileset_bonus = new TileSet(8);
	private TileSet tileset_map = new TileSet(21);
	private TileSet tileset_tower = new TileSet(24);
	private TileSet tileset_computer = new TileSet(6);
	private TileSet tileset_virus = new TileSet(4);
	private TileSet tileset_spam = new TileSet(8);
	private TileSet tileset_spy = new TileSet(9);
	private TileSet tileset_worm = new TileSet(5);
	private TileSet tileset_keylogger = new TileSet(8);
	private TileSet tileset_regular_threat = new TileSet(8);
	private TileSet tileset_hacker = new TileSet(8);
	private TileSet tileset_tower_menu = new TileSet(3);
	private TileSet tileset_marks_towers = new TileSet(9);
	private TileSet tileset_victory = new TileSet(2);
	private TileSet[] tileset_threat = { tileset_virus, tileset_spam, tileset_spy, tileset_worm, tileset_keylogger, tileset_regular_threat, tileset_hacker};
	private Image background;
	private Image saveGameImage;
	
	public PlayPanel() {
		
		mouseHandler = new MouseHandlerPlay();
		
		// Mouse listeners
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);
		
		pointer = new Point(0,0);
		gameManager = new GameManager();
		computer = new Computer();
		threatDescriptionManager = new ThreatDescriptionManager();
		
	}
		
	// Cargando recursos.
	private void loadResources() {
		
		// Cargando imágenes.
		background = new ImageIcon("res/Background/background.png").getImage();
		saveGameImage = new ImageIcon("res/SaveGame/saveGame.png").getImage();
		
		// Carga de TileSets.
		for(int i = 0 ; i < tileset_bonus.getLength() ; i++) {
			tileset_bonus.setImage(createImage(new FilteredImageSource(new ImageIcon("res/BonusButtons/tileset_bonus.png").getImage().getSource(),new CropImageFilter(0,BonusStore.BONUS_BUTTON_DIMENSION*i,BonusStore.BONUS_BUTTON_DIMENSION,BonusStore.BONUS_BUTTON_DIMENSION))),i);
		}
		
		for(int i = 0 ; i < tileset_computer.getLength() ; i++) {
			tileset_computer.setImage(createImage(new FilteredImageSource(new ImageIcon("res/Computer/tileset_computer.png").getImage().getSource(),new CropImageFilter(0,i*Computer.HEIGHT_COMPUTER,Computer.WIDTH_COMPUTER,Computer.HEIGHT_COMPUTER))),i);
		}
		
		for(int i = 0 ; i < tileset_map.getLength() ; i++) {
			tileset_map.setImage(createImage(new FilteredImageSource(new ImageIcon("res/Map/tileset_map.png").getImage().getSource(),new CropImageFilter(0,Square.BLOCK_SIZE*i,Square.BLOCK_SIZE,Square.BLOCK_SIZE))),i);
		}
		
		for(int i = 0 ; i < tileset_tower.getLength() ; i++) {
			tileset_tower.setImage(createImage(new FilteredImageSource(new ImageIcon("res/Towers/tileset_towers.png").getImage().getSource(),new CropImageFilter(0,Tower.TOWER_DIMENSION*i,Tower.TOWER_DIMENSION,Tower.TOWER_DIMENSION))),i);
		}
		
		for(int i = 0 ; i < tileset_virus.getLength() ; i++) {
			tileset_virus.setImage(createImage(new FilteredImageSource(new ImageIcon("res/Threats/tileset_virus.png").getImage().getSource(),new CropImageFilter(0,Threat.THREAT_DIMENSION*i,Threat.THREAT_DIMENSION,Threat.THREAT_DIMENSION))), i);
		}
		
		for(int i = 0 ; i < tileset_spam.getLength() ; i++) {
			tileset_spam.setImage(createImage(new FilteredImageSource(new ImageIcon("res/Threats/tileset_spam.png").getImage().getSource(),new CropImageFilter(0,Threat.THREAT_DIMENSION*i,Threat.THREAT_DIMENSION,Threat.THREAT_DIMENSION))), i);
		}
		
		for(int i = 0 ; i < tileset_spy.getLength() ; i++) {
			tileset_spy.setImage(createImage(new FilteredImageSource(new ImageIcon("res/Threats/tileset_spy.png").getImage().getSource(),new CropImageFilter(0,Threat.THREAT_DIMENSION*i,Threat.THREAT_DIMENSION,Threat.THREAT_DIMENSION))), i);
		}
		
		for(int i = 0 ; i < tileset_worm.getLength() ; i++) {
			tileset_worm.setImage(createImage(new FilteredImageSource(new ImageIcon("res/Threats/tileset_worm.png").getImage().getSource(),new CropImageFilter(0,Threat.THREAT_DIMENSION*i,Threat.THREAT_DIMENSION,Threat.THREAT_DIMENSION))), i);
		}
		
		for(int i = 0 ; i < tileset_keylogger.getLength() ; i++) {
			tileset_keylogger.setImage(createImage(new FilteredImageSource(new ImageIcon("res/Threats/tileset_keylogger.png").getImage().getSource(),new CropImageFilter(0,Threat.THREAT_DIMENSION*i,Threat.THREAT_DIMENSION,Threat.THREAT_DIMENSION))), i);
		}
		
		for(int i = 0 ; i < tileset_regular_threat.getLength() ; i++) {
			tileset_regular_threat.setImage(createImage(new FilteredImageSource(new ImageIcon("res/Threats/tileset_regular_threat.png").getImage().getSource(),new CropImageFilter(0,Threat.THREAT_DIMENSION*i,Threat.THREAT_DIMENSION,Threat.THREAT_DIMENSION))), i);
		}
		
		for(int i = 0 ; i < tileset_hacker.getLength() ; i++) {
			tileset_hacker.setImage(createImage(new FilteredImageSource(new ImageIcon("res/Threats/tileset_hacker.png").getImage().getSource(),new CropImageFilter(0,Threat.THREAT_DIMENSION*i,Threat.THREAT_DIMENSION,Threat.THREAT_DIMENSION))), i);
		}
				
		for(int i = 0 ; i < tileset_play_menu.getLength() ; i++) {
			tileset_play_menu.setImage(createImage(new FilteredImageSource(new ImageIcon("res/Menu/tileset_play_menu.png").getImage().getSource(),new CropImageFilter(0,PlayMenu.HEIGHT_BUTTONS*i,PlayMenu.WIDTH_BUTTONS,PlayMenu.HEIGHT_BUTTONS))), i);
		}
		
		for(int i = 0 ; i < tileset_tower_menu.getLength() ; i++) {
			tileset_tower_menu.setImage(createImage(new FilteredImageSource(new ImageIcon("res/TowerMenu/tileset_tower_menu.png").getImage().getSource(),new CropImageFilter(0,TowerMenu.BUTTON_HEIGHT*i,TowerMenu.BUTTON_WIDTH,TowerMenu.BUTTON_HEIGHT))), i);
		}
		
		for(int i = 0 ; i < tileset_marks_towers.getLength() ; i++) {
			tileset_marks_towers.setImage(createImage(new FilteredImageSource(new ImageIcon("res/Towers/tileset_marks_towers.png").getImage().getSource(),new CropImageFilter(0,28*i,28,28))), i);
		}
		
		for(int i = 0 ; i < tileset_victory.getLength() ; i++) {
			tileset_victory.setImage(createImage(new FilteredImageSource(new ImageIcon("res/Victory/tileset_victory.png").getImage().getSource(),new CropImageFilter(0,Game.VICTORY_HEIGHT*i,Game.VICTORY_WIDTH,Game.VICTORY_HEIGHT))), i);
		}
		
		// Cargando menúes.
		bonusStore = new BonusStore();
		menu = new PlayMenu();
		improveTowerMenu = new TowerMenu();
		towerStore = new TowerStore();
		
		// Cargando slider para volúmen de la música de fondo.
		menu.addVolumeSlider();
		
	}
	
	public void paintComponent(Graphics g) {
		
		// Si es la primera vez que cargamos
		if(isFirstTimeLoading) {
			panelWidth = getWidth(); 	// Cargamos las dimensiones del panel.
			panelHeight = getHeight();
			loadResources();			// Cargamos recursos.
			isFirstTimeLoading = false;
		}
		
		// Background.
		g.drawImage(background, 0, 0, panelWidth, panelHeight, null);
		
		// Pintamos.
		menu.draw(g);
		bonusStore.draw(g);
		computer.draw(g);
		threatDescriptionManager.draw(g);
		game.draw(g);
		towerStore.draw(g);
		improveTowerMenu.draw(g);
		
	}
	
	@Override
	public void run() {
		
		// Game loop.
		while(true) {
			
			if(!isFirstTimeLoading) {
				
				// Setear volumen de musica de acuerdo al slider.
				Window.getInstance().getMusic().setVolume((float)menu.getVolume().getValue()/100f);
				
				
				// Actualizamos estado de los botones.
				if(game.isGameOver() || game.isGameWin()) {
					menu.getSendThreatsButton().disable();
					menu.getSaveGameButton().disable();
					menu.getPauseButton().disable();
				}
				
				if(!game.isPaused() && !game.isGameWin() && !game.isGameOver()) {
					
					// Actualizamos estado de los botones.
					bonusStore.checkBonusStates();
					towerStore.checkTowerStates();
					improveTowerMenu.checkButtonsStates();
					
					if(game.getWave() != null && game.getWave().hasFinished()) {
						menu.getSendThreatsButton().enable();
						menu.getSaveGameButton().enable();
					}	
					
					// Corremos el juego.
					game.run();
					
				}
				
				
				repaint();
				
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
						
			}
			
		}
		
	}
	
	// Comenzar una partida.
	public void newGame() {
		
		game = new Game(Window.getInstance().getSelectGameModePanel().getSelectedGameMode(),Window.getInstance().getSelectMapPanel().getSelectedMap());
		thread = new Thread(this);
		thread.start();
		isFirstTimeLoading = true;
		
	}
	
	// Cargar una partida
	public void loadGame() {
		
		try {
			game = gameManager.loadGame();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		thread = new Thread(this);
		thread.start();
		isFirstTimeLoading = true;
		
	}
	
	public ThreatDescriptionManager getThreatDescriptionManager() {
		return threatDescriptionManager;
	}

	public Game getGame() {
		return game;
	}

	public int getPanelWidth() {
		return panelWidth;
	}
	
	public int getPanelHeight() {
		return panelHeight;
	}

	public TileSet getTileset_map() {
		return tileset_map;
	}

	public TileSet[] getTileset_threat() {
		return tileset_threat;
	}

	public TileSet getTileset_tower() {
		return tileset_tower;
	}
	
	public TileSet getTileset_bonus() {
		return tileset_bonus;
	}
	
	public TileSet getTileset_computer() {
		return tileset_computer;
	}

	public TileSet getTileset_play_menu() {
		return tileset_play_menu;
	}

	public TileSet getTileset_tower_menu() {
		return tileset_tower_menu;
	}
	
	public TileSet getTileset_marks_towers() {
		return tileset_marks_towers;
	}

	public TileSet getTileset_victory() {
		return tileset_victory;
	}

	public Point getPointer() {
		return pointer;
	}

	public void setPointer(Point pointer) {
		this.pointer = pointer;
	}
	
	public TowerStore getTowerStore() {
		return towerStore;
	}

	public BonusStore getBonusStore() {
		return bonusStore;
	}

	public PlayMenu getMenu() {
		return menu;
	}

	public TowerMenu getImproveTowerMenu() {
		return improveTowerMenu;
	}

	public GameManager getGameManager() {
		return gameManager;
	}
	
	public Thread getThread() {
		return thread;
	}
	
	public void clearConsole() {
		improveTowerMenu.clear();
	}

	public Image getSaveGameImage() {
		return saveGameImage;
	}

}
