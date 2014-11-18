package game;

import graphics.AnimationDrawer;
import graphics.Drawable;

import java.awt.*;
import java.io.File;
import java.io.Serializable;

import threats.Threat;
import main.Window;

public class Game implements Serializable, Drawable, Runnable {
	
	private static final long serialVersionUID = 1L;
	
	// Dimensiones cartel de victoria
	public static final int VICTORY_HEIGHT = 215;
	public static final int VICTORY_WIDTH = 625;
	private static final int VICTORY_X = 106;
	private static final int VICTORY_Y = 425;
	
	// Dimensiones cartel de juego guardado
	public static final int SAVEGAME_HEIGHT = 216;
	public static final int SAVEGAME_WIDTH = 628;
	public static final int SAVEGAME_X = 107;
	public static final int SAVEGAME_Y = 420;

	// Gamemodes.
	public static final int NORMAL_MODE = 0;
	public static final int RICH_MODE = 1;
	public static final int HARDCORE_MODE = 2;
	
	// Maps.
	public static final int EASY_MAP = 0;
	public static final int NORMAL_MAP = 1;
	public static final int HARD_MAP = 2;
	
	// Recompensa inicial al matar una amenaza.
	private static final int BASE_MONEY_REWARD = 8;
	
	// Stats iniciales.
	private static final int REGULAR_STARTING_LIFES = 20;
	private static final int HARDCORE_STARTING_LIFES = 1;
	private static final int REGULAR_STARTING_MONEY = 375;
	private static final int RICH_STARTING_MONEY = 50000;
	private static final int STARTING_INTEREST = 3;
	private static final int REGULAR_STARTING_BONUS = 0;
	private static final int RICH_STARTING_BONUS = 10;
	public static final int STARTING_LEVEL = 0;
	private static final int STARTING_SCORE = 0;
	
	// Cantidad de niveles
	public static final int LEVELS = 50;
	
	// Elementos principales del juego
	private Map map;
	private Wave currentWave;
	private Stats stats;
	
	// Otros compomentes
	private int waveIDsOrder[] = { Wave.KEYLOGGER_WAVE, Wave.SPY_WAVE, Wave.WORM_WAVE, Wave.TROJAN_WAVE, Wave.BONUS_WAVE, Wave.TROJAN_WAVE, Wave.SPAM_WAVE, Wave.SPY_WAVE, Wave.WORM_WAVE, Wave.BONUS_WAVE, Wave.SPY_WAVE, Wave.WORM_WAVE, Wave.TROJAN_WAVE, Wave.KEYLOGGER_WAVE, Wave.BONUS_WAVE, Wave.KEYLOGGER_WAVE, Wave.SPY_WAVE, Wave.SPAM_WAVE, Wave.TROJAN_WAVE, Wave.BONUS_WAVE, Wave.WORM_WAVE, Wave.TROJAN_WAVE, Wave.KEYLOGGER_WAVE, Wave.SPY_WAVE, Wave.BONUS_WAVE, Wave.TROJAN_WAVE, Wave.SPAM_WAVE, Wave.WORM_WAVE, Wave.KEYLOGGER_WAVE, Wave.BONUS_WAVE, Wave.TROJAN_WAVE, Wave.WORM_WAVE, Wave.KEYLOGGER_WAVE, Wave.SPY_WAVE, Wave.BONUS_WAVE, Wave.WORM_WAVE, Wave.SPY_WAVE, Wave.SPAM_WAVE, Wave.KEYLOGGER_WAVE, Wave.BONUS_WAVE, Wave.SPAM_WAVE, Wave.TROJAN_WAVE, Wave.WORM_WAVE, Wave.SPY_WAVE, Wave.BONUS_WAVE, Wave.TROJAN_WAVE, Wave.KEYLOGGER_WAVE, Wave.WORM_WAVE, Wave.SPAM_WAVE, Wave.FINAL_WAVE};  
	private boolean gameOver;
	private boolean gameWin;
	private boolean isPaused;
	private boolean showGameHasBeenSaved;
	private boolean showGameCouldntBeSaved;
	private int gameMode;
	private transient AnimationDrawer victoryDrawer = new AnimationDrawer(80);

	public Game(int gamemode, int selectedMap) {
		
		victoryDrawer.setAnimation(Window.getInstance().getPlayPanel().getTileset_victory());
		victoryDrawer.setPosition(VICTORY_X,VICTORY_Y,VICTORY_WIDTH,VICTORY_HEIGHT);
		
		map = new Map();
		currentWave = null;
		gameOver = false;
		isPaused = false;
		gameWin = false;
		showGameHasBeenSaved = false;
		showGameCouldntBeSaved = false;
		this.gameMode = gamemode;
		
		// Cargamos stats iniciales de acuerdo al gamemode seleccionado
		if(gamemode == HARDCORE_MODE) {
			stats = new Stats(HARDCORE_STARTING_LIFES,REGULAR_STARTING_MONEY,STARTING_INTEREST,REGULAR_STARTING_BONUS,STARTING_LEVEL,STARTING_SCORE);
		} else if(gamemode == RICH_MODE) {
			stats = new Stats(REGULAR_STARTING_LIFES,RICH_STARTING_MONEY,STARTING_INTEREST,RICH_STARTING_BONUS,STARTING_LEVEL,STARTING_SCORE);
		} else {
			stats = new Stats(REGULAR_STARTING_LIFES,REGULAR_STARTING_MONEY,STARTING_INTEREST,REGULAR_STARTING_BONUS,STARTING_LEVEL,STARTING_SCORE);
		}
		
		// Cargamos mapa seleccionado;
		if(selectedMap == EASY_MAP) {
			map.loadMap(new File("maps/map1.map"));
		} else if(selectedMap == NORMAL_MAP) {
			map.loadMap(new File("maps/map3.map"));
		} else {
			map.loadMap(new File("maps/map2.map"));
		}
		
	}
	
	@Override
	public void run() {
		
		if(stats.getLifes() == 0) {
			gameOver = true;
		}

		if(currentWave != null && !currentWave.hasFinished()) {
			
			towerAttacks(); // Ordenamos a las torres que ataquen
			currentWave.move(); // Y a las amenazas de la oleada acutal que se muevan por el mapa
			
			// Spawn de amenazas
			if(currentWave.isSpawning()) {
				currentWave.spawnThreats();
			}
			
		}
		
	}

	public void towerAttacks() {
		
		for(int y = 0 ; y < Map.MAP_HEIGHT ; y++) {
			for(int x = 0 ; x < Map.MAP_WIDTH ; x++) {
				Square celda = map.getMapRepresentation()[y][x];
				if(celda instanceof Container && ((Container)celda).hasTower()) {
					((Container)map.getMapRepresentation()[y][x]).getTower().attack();;
				}
			}
		}
		
	}
	
	@Override
	public void draw(Graphics g) {
		
		map.draw(g);
		stats.draw(g);
		
		if(currentWave != null){
			currentWave.draw(g);
		}
		
		if(gameWin) {
			victoryDrawer.draw(g);
		}
		
		if(showGameHasBeenSaved) {
			g.drawImage(Window.getInstance().getPlayPanel().getSaveGameImage(),SAVEGAME_X, SAVEGAME_Y, SAVEGAME_WIDTH, SAVEGAME_HEIGHT, null);
		}
		
		if(showGameCouldntBeSaved) {
			g.setColor(Color.white);
			g.setFont(new Font("Consolas",0,36));
			g.drawString("FAIL TO SAVE THE GAME",SAVEGAME_X, SAVEGAME_Y);
		}
		
	}
	
	public void increaseLevel() {
		if(stats.getLevel() == LEVELS) {
			gameWin = true;
		} else {
			sendWave();
			stats.setLevel(stats.getLevel()+1);		
		}
	}
	
	// Obtener la recompensa
	public void getReward(Threat t) {
		
		if(t.isBonus()) {
			stats.setBonus(stats.getBonus()+1);
		}
		
		stats.setMoney(stats.getMoney() + getCurrentMoneyReward() + (int)(stats.getInterest()*getCurrentMoneyReward()/100));
		stats.setScore(stats.getScore()+(int)(100* Math.exp(-0.0005*t.getSteps())));
		
	}
	
	public void sendWave() {
		currentWave = new Wave(waveIDsOrder[stats.getLevel()]);
	}
	
	public Wave getWave() {
		return currentWave;
	}

	public void setWave(Wave wave) {
		this.currentWave = wave;
	}

	public Map getMap() {
		return map;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public int getCurrentWaveID() {
		return waveIDsOrder[Window.getInstance().getPlayPanel().getGame().getStats().getLevel()-1];
	}
	
	public int getNextWaveID() {
		return waveIDsOrder[Window.getInstance().getPlayPanel().getGame().getStats().getLevel()];
	}

	public int getCurrentMoneyReward() {
		return BASE_MONEY_REWARD + stats.getLevel()-1;
	}
	
	public int getNextMoneyReward() {
		return BASE_MONEY_REWARD + stats.getLevel();
	}
	
	public boolean isPaused() {
		return isPaused;
	}

	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}

	public boolean isGameWin() {
		return gameWin;
	}

	public void setGameWin(boolean gameWin) {
		this.gameWin = gameWin;
	}

	public int getGameMode() {
		return gameMode;
	}

	public void setShowGameHasBeenSaved(boolean showGameHasBeenSaved) {
		this.showGameHasBeenSaved = showGameHasBeenSaved;
	}

	public void setShowGameCouldntBeSaved(boolean showGameCouldntBeSaved) {
		this.showGameCouldntBeSaved = showGameCouldntBeSaved;
	}
	
	public void looseLife() {
		stats.setLifes(stats.getLifes()-1);
	}
	
	public void cleanSaveMessages() {
		showGameHasBeenSaved = false;
		showGameCouldntBeSaved = false;
	}
	
}
