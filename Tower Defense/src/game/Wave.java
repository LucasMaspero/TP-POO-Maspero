package game;

import graphics.Drawable;
import java.awt.Graphics;
import java.io.Serializable;
import threats.*;

public class Wave implements Serializable, Drawable {
	
	private static final long serialVersionUID = 1L;
	
	// Waves IDs.
	public static final int TROJAN_WAVE = 0;
	public static final int SPAM_WAVE = 1;
	public static final int SPY_WAVE = 2;
	public static final int WORM_WAVE = 3;
	public static final int KEYLOGGER_WAVE = 4;
	public static final int BONUS_WAVE = 5;
	public static final int FINAL_WAVE = 6;
	
	// Cantidad de amenazas por oleada.
	public static final int WAVE_SIZE = 20;
	
	// Velocidades de spawn
	private static final int SPAWN_TIME_FAST = 285;
	private static final int SPAWN_TIME_MEDIUM = 1275;
	private static final int SPAWN_TIME_SLOW = 2000;
	
	// Intervalo de spawn
	private int spawn_time;
	private int spawnFrame = 0;
	
	private boolean isSpawning = false;

	private int numberOfSpawnedThreats;
	
	// Amenazas
	private Threat[] threats = new Threat[WAVE_SIZE];
	
	public Wave(int waveID) {
		
		numberOfSpawnedThreats = 0;
		isSpawning = true;
		
		// Creamos las amenazas dependiendo el ID de la oleada.
		if(waveID == Wave.TROJAN_WAVE) {
			for(int i = 0 ; i < threats.length ; i++) {
				threats[i] = new Trojan();
			}	
		} else if(waveID == Wave.SPAM_WAVE) {
			for(int i = 0 ; i < threats.length ; i++) {
				threats[i] = new Spam();
			}
		} else if(waveID == Wave.SPY_WAVE) {
			for(int i = 0 ; i < threats.length ; i++) {
				threats[i] = new Spy();
			}
		} else if(waveID == Wave.WORM_WAVE) {
			for(int i = 0 ; i < threats.length ; i++) {
				threats[i] = new Worm();
			}
		} else if(waveID == BONUS_WAVE) {
			for(int i = 0 ; i < threats.length-1 ; i++) {
				threats[i] = new RegularThreat();
			}
			threats[19] = new Hacker();
		} else if(waveID == KEYLOGGER_WAVE) {
			for(int i = 0 ; i < threats.length ; i++) {
				threats[i] = new KeyLogger();
			}
		} else if(waveID == FINAL_WAVE) {
			for(int i = 0 ; i < threats.length ; i++) {
				if(i<3) {
					threats[i] = new Trojan();
				} else if(i<6) {
					threats[i] = new Spy();
				} else if(i<9) {
					threats[i] = new Worm();
				} else if(i<12) {
					threats[i] = new Spam();
				} else if(i<15) {
					threats[i] = new KeyLogger();
				} else if(i<18) {
					threats[i] = new RegularThreat();
				} else {
					threats[i] = new Hacker();
				}
			}
		}
		
		// Seteamos la velocidad de spawn de las amenazas dependiendo su velocidad.
		if(threats[0].getSpeed() == Threat.FAST_SPEED) {
			spawn_time = SPAWN_TIME_FAST;	
		} else if (threats[0].getSpeed() == Threat.MEDIUM_SPEED) {
			spawn_time = SPAWN_TIME_MEDIUM;	
		} else {
			spawn_time = SPAWN_TIME_SLOW;	
		}
		
	}
	
	// Amenazas vivas en juego.
	public int aliveThreats() {
		int result = 0;
		for(int i = 0 ; i < threats.length ; i++) {
			if(threats[i].isInGame()) {
				result++;
			}
		}
		return result;
	}
	
	@Override
	public void draw(Graphics g) {
		// Dibujando las amenazas.
		for(int i = 0 ; i < threats.length ; i++) {
			if(threats[i].isInGame()) {
				threats[i].draw(g);
			}
		}
	}
	
	// Mover las amenazas de la oleada por el mapa.
	public void move() {
		for(int i = 0 ; i < threats.length ; i++) {
			if(threats[i].isInGame()) {
				threats[i].move();
			}
		}
	}
	
	// Spawnear amenazas
	public void spawnThreats() {
		
		if(spawnFrame >= spawn_time) {

			if(numberOfSpawnedThreats < WAVE_SIZE) {
				if((numberOfSpawnedThreats % 2) == 0) {
					threats[numberOfSpawnedThreats].spawnThreatRight();
				} else {
					threats[numberOfSpawnedThreats].spawnThreatLeft();
					spawnFrame = 0;
				}
				numberOfSpawnedThreats++;
			} else {
				isSpawning = false;
			}

		} else {
			spawnFrame += 1;
		}
	}
	
	public Threat[] getThreats() {
		return threats;
	}

	public boolean isSpawning() {
		return isSpawning;
	}

	public void setSpawning(boolean isSpawning) {
		this.isSpawning = isSpawning;
	}
	
	// Termino la oleada (termino de spawnear, y ninguna amenaza esta ingame).
	public boolean hasFinished() {
		
		if(isSpawning) {
			return false;
		}
		
		for(int i = 0 ; i < WAVE_SIZE ; i++) {
			if(threats[i].isInGame() == true) {
				return false;
			}
		}
		
		return true;
	}
	
}
