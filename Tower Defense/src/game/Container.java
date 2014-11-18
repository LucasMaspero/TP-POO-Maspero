package game;

import graphics.Drawable;
import towers.*;
import java.awt.Graphics;
import java.io.Serializable;
import main.Window;
import towers.Tower;

public class Container extends Square implements Serializable, Drawable {
	
	private static final long serialVersionUID = 1L;

	public Container(int x, int y) {
		super(x, y);
		tower = null;
	}

	private Tower tower;
	
	public boolean hasTower() {
		if(tower == null) {
			return false;
		}
		return true;
	}

	public Tower getTower() {
		return tower;
	}
	
	public void deleteTower() {
		tower = null;
	}

	public void setTower(int towerID, int xMap, int yMap) {

		if(towerID == Tower.FREE_ANTIVIRUS) {
			tower = new FreeAntiVirus(x,y,xMap,yMap);
		} else if (towerID == Tower.HOME_ANTIVIRUS) {
			tower = new HomeAntiVirus(x,y,xMap,yMap);
		} else if (towerID == Tower.ENTERPRISE_ANTIVIRUS) {
			tower = new EnterpriseAntiVirus(x,y,xMap,yMap);
		} else if (towerID == Tower.TRIAL_ANTIWORM) {
			tower = new TrialAntiWorm(x,y,xMap,yMap);							
		} else if (towerID == Tower.STANDARD_ANTIWORM) {
			tower = new StandardAntiWorm(x,y,xMap,yMap);							
		} else if (towerID == Tower.PRO_ANTIWORM) {
			tower = new ProAntiWorm(x,y,xMap,yMap);						
		} else if (towerID == Tower.SYSTEM_FIREWALL) {
			tower = new SystemFirewall(x,y,xMap,yMap);							
		} else if (towerID == Tower.NONO_FIREWALL) {
			tower = new NoNoFirewall(x,y,xMap,yMap);							
		} else if (towerID == Tower.ACCESSDENIED_FIREWALL) {
			tower = new AccessDeniedFirewall(x,y,xMap,yMap);							
		} else if (towerID == Tower.SPY_SWEEPER) {
			tower = new SpySweeper(x,y,xMap,yMap);					
		} else if (towerID == Tower.SPY_TERMINATOR) {
			tower = new SpyTerminator(x,y,xMap,yMap);						
		} else if (towerID == Tower.SPY_BOT) {
			tower = new SpyBot(x,y,xMap,yMap);					
		}
		
	}

	@Override
	public void draw(Graphics g) {
		
		g.drawImage(Window.getInstance().getPlayPanel().getTileset_map().getImage(getImageID()),x,y,width,height,null);
		
		if(hasTower()) {
			g.drawImage(Window.getInstance().getPlayPanel().getTileset_tower().getImage(tower.getTowerID()+12),x,y,width,height,null);
		}
		
	}

}
