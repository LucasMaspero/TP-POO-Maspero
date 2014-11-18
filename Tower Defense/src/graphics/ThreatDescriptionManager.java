package graphics;

import game.Game;
import game.Wave;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import main.Window;
import threats.Hacker;
import threats.KeyLogger;
import threats.Spam;
import threats.Spy;
import threats.Threat;
import threats.Trojan;
import threats.Worm;

public class ThreatDescriptionManager implements Drawable {
	
	// Coordeanadas
	private static final int X_TITLES = 882;
	private static final int Y_TITLE_ONE_DESCRIPTION = 701;
	private static final int Y_TITLE_TWO_DESCRIPTION = 790;
	private static final int Y_CURRENT_SLOT_ONE = 695; 
	private static final int Y_CURRENT_SLOT_TWO = 712; 
	private static final int Y_CURRENT_SLOT_THREE = 729; 
	private static final int Y_CURRENT_SLOT_FOUR = 746; 
	private static final int Y_NEXT_SLOT_ONE = 788;
	private static final int Y_NEXT_SLOT_TWO = 812;
	private static final int Y_NEXT_SLOT_THREE = 836;
	private static final int X_SLOTS = 960;
	private static final int X_ANIMATION = 903;
	private static final int Y_ANIMATION_ONE = 713;
	private static final int Y_ANIMATION_TWO = 801;
	
	// Índices para imágenes
	private static final int TILESET_TROJAN_INDEX = 0;
	private static final int TILESET_SPAM_INDEX = 1;
	private static final int TILESET_SPY_INDEX = 2;
	private static final int TILESET_WORM_INDEX = 3;
	private static final int TILESET_KEYLOGGER_INDEX = 4;
	private static final int TILESET_HACKER_INDEX = 6;
	
	// Velocidad de animacion
	private static final int ANI_RATE = 20;
	
	private AnimationDrawer animationDrawerOne = new AnimationDrawer(ANI_RATE);
	private AnimationDrawer animationDrawerTwo = new AnimationDrawer(ANI_RATE);
	
	int nextWaveID = -1;
	int currentWaveID = -1;
	
	public ThreatDescriptionManager() {
		
		animationDrawerOne = new AnimationDrawer(20);
		animationDrawerTwo = new AnimationDrawer(20);
		
		animationDrawerOne.setPosition(X_ANIMATION, Y_ANIMATION_ONE, Threat.THREAT_DIMENSION, Threat.THREAT_DIMENSION);
		animationDrawerTwo.setPosition(X_ANIMATION, Y_ANIMATION_TWO, Threat.THREAT_DIMENSION, Threat.THREAT_DIMENSION);
		
	}
	
	@Override
	public void draw(Graphics g) {
		
		if(Window.getInstance().getPlayPanel().getGame().getStats().getLevel() != Game.STARTING_LEVEL) {
			if(Window.getInstance().getPlayPanel().getGame().getStats().getLevel() == Game.LEVELS) {
				drawCurrent(g);
			}
			else{
				drawCurrent(g);
				drawNext(g);
			}		
		}
		
	}
	
	public void setTitleColor(Graphics g, int waveID) {
		if(waveID == Threat.TROJAN) {
			g.setColor(Color.white);
		} else if(waveID == Threat.SPAM) {
			g.setColor(Color.yellow);	
		} else if(waveID == Threat.SPY) {
			g.setColor(Color.blue);	
		} else if(waveID == Threat.WORM) {
			g.setColor(new Color(155,0,226));	
		} else if(waveID == Wave.KEYLOGGER_WAVE) {
			g.setColor(new Color(155,228,255));
		} else {
			g.setColor(Color.lightGray);
		}
	}
	
	public String getWaveSpeed(int waveID) {
		
		int speed;
		
		if(waveID == Wave.SPAM_WAVE) {
			speed = Spam.DEFAULT_SPEED;
		} else if(waveID == Wave.WORM_WAVE) {
			speed = Worm.DEFAULT_SPEED;
		} else if(waveID == Wave.TROJAN_WAVE){
			speed = Trojan.DEFAULT_SPEED;
		} else if(waveID == Wave.SPY_WAVE){
			speed = Spy.DEFAULT_SPEED;
		} else if(waveID == Wave.KEYLOGGER_WAVE) {
			speed = KeyLogger.DEFAULT_SPEED;
		} else {
			speed = Hacker.DEFAULT_SPEED;;
		}
		
		if(speed == Threat.FAST_SPEED) {
			return "Fast";
		} else if(speed == Threat.MEDIUM_SPEED) {
			return "Medium";
		} else {
			return "Slow";
		}
		
	}
	
	public int getWaveHealth(int level, int waveID) {
		
		int plusHealth = Threat.getPlusHealth(level);
		int defaultHealth;
		
		if(waveID == Wave.SPAM_WAVE) {
			defaultHealth = Spam.DEFAULT_HEALTH;
		} else if(waveID == Wave.WORM_WAVE) {
			defaultHealth = Worm.DEFAULT_HEALTH;
		} else if(waveID == Wave.TROJAN_WAVE){
			defaultHealth = Trojan.DEFAULT_HEALTH;
		} else if(waveID == Wave.SPY_WAVE){
			defaultHealth = Spy.DEFAULT_HEALTH;
		} else if(waveID == Wave.KEYLOGGER_WAVE) {
			defaultHealth = KeyLogger.DEFAULT_HEALTH;
		} else {
			defaultHealth = Hacker.DEFAULT_HEALTH;
		}
		
		return (defaultHealth + plusHealth);
		
	}
	
	public TileSet getTileSetAnimation(int waveID) {
		
		TileSet animation;
		
		if(waveID == Wave.SPAM_WAVE) {
			animation = Window.getInstance().getPlayPanel().getTileset_threat()[TILESET_SPAM_INDEX];
		} else if(waveID == Wave.WORM_WAVE) {
			animation = Window.getInstance().getPlayPanel().getTileset_threat()[TILESET_WORM_INDEX];
		} else if(waveID == Wave.TROJAN_WAVE){
			animation = Window.getInstance().getPlayPanel().getTileset_threat()[TILESET_TROJAN_INDEX];
		} else if(waveID == Wave.SPY_WAVE){
			animation = Window.getInstance().getPlayPanel().getTileset_threat()[TILESET_SPY_INDEX];
		} else if(waveID == Wave.KEYLOGGER_WAVE) {
			animation = Window.getInstance().getPlayPanel().getTileset_threat()[TILESET_KEYLOGGER_INDEX];
		} else {
			animation = Window.getInstance().getPlayPanel().getTileset_threat()[TILESET_HACKER_INDEX];
		}
		
		return animation;
		
	}
	
	public String getWaveTitle(int waveID) {
		
		String title;
		
		if(waveID == Wave.SPAM_WAVE) {
			title = "  SPAM";
		} else if(waveID == Wave.WORM_WAVE) {
			title = "  WORM";
		} else if(waveID == Wave.TROJAN_WAVE){
			title = " TROJAN";
		} else if(waveID == Wave.SPY_WAVE){
			title = "   SPY";
		} else if(waveID == Wave.KEYLOGGER_WAVE) {
			title = "KEYLOGGER";
		} else if(waveID == Wave.BONUS_WAVE){
			title = " HACKER";
		} else {
			title = "  FINAL";
		}
		
		return title;
		
	}
	
	public void drawNext(Graphics g) {
		
		int previous = nextWaveID;
		nextWaveID = Window.getInstance().getPlayPanel().getGame().getNextWaveID();
		
		setTitleColor(g,nextWaveID);
		g.setFont(new Font("Consolas",0,14));
		g.drawString(getWaveTitle(nextWaveID),X_TITLES,Y_TITLE_TWO_DESCRIPTION);
		
		animationDrawerTwo.setAnimation(getTileSetAnimation(nextWaveID));
		if(nextWaveID != previous) {
			animationDrawerTwo.reset();
		}
		animationDrawerTwo.draw(g);
		
		g.setColor(new Color(243,121,37));
		g.setFont(new Font("Consolas",0,14));
		g.drawString("* Threat health : " + getWaveHealth(Window.getInstance().getPlayPanel().getGame().getStats().getLevel()+1,nextWaveID),X_SLOTS,Y_NEXT_SLOT_ONE);
		
		g.setColor(new Color(195,195,195));
		g.drawString("* Threat speed : " + getWaveSpeed(nextWaveID),X_SLOTS,Y_NEXT_SLOT_TWO);
		
		g.setColor(new Color(239,201,112));
		g.drawString("* Reward : $ " + Window.getInstance().getPlayPanel().getGame().getNextMoneyReward(),X_SLOTS,Y_NEXT_SLOT_THREE);
	
	}
	
	public void drawCurrent(Graphics g) {
		
		int previous = currentWaveID;
		currentWaveID = Window.getInstance().getPlayPanel().getGame().getCurrentWaveID();
		
		setTitleColor(g,currentWaveID);
		g.setFont(new Font("Consolas",0,14));
		g.drawString(getWaveTitle(currentWaveID),X_TITLES,Y_TITLE_ONE_DESCRIPTION);
		
		animationDrawerOne.setAnimation(getTileSetAnimation(currentWaveID));
		if(currentWaveID != previous) {
			animationDrawerOne.reset();
		}
		animationDrawerOne.draw(g);
		
		g.setColor(new Color(133,255,28));
		g.setFont(new Font("Consolas",0,14));
		
		g.drawString("* Alive threats:  " + Window.getInstance().getPlayPanel().getGame().getWave().aliveThreats(),X_SLOTS,Y_CURRENT_SLOT_ONE);
		
		g.setColor(new Color(243,121,37));
		g.drawString("* Threat health:  " + getWaveHealth(Window.getInstance().getPlayPanel().getGame().getStats().getLevel(),currentWaveID),X_SLOTS,Y_CURRENT_SLOT_TWO);
		
		g.setColor(new Color(195,195,195));
		g.drawString("* Threat speed : " + getWaveSpeed(currentWaveID),X_SLOTS,Y_CURRENT_SLOT_THREE);
		
		g.setColor(new Color(239,201,112));
		g.drawString("* Reward : $ " + Window.getInstance().getPlayPanel().getGame().getCurrentMoneyReward(),X_SLOTS,Y_CURRENT_SLOT_FOUR);
		
	}



	public AnimationDrawer getAnimationDrawerOne() {
		return animationDrawerOne;
	}

	public AnimationDrawer getAnimationDrawerTwo() {
		return animationDrawerTwo;
	}
	
}
