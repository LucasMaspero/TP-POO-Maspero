package towers;

import main.Window;
import graphics.Drawable;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

import threats.Threat;

public abstract class Tower implements Drawable, Serializable {
	
	private static final long serialVersionUID = 624435615904319987L;
	
	// Velocidades de ataque
	public static final int REAL_SLOW_ATTACK_SPEED_ONE = 1400;
	public static final int REAL_SLOW_ATTACK_SPEED_TWO = 1200;
	public static final int REAL_SLOW_ATTACK_SPEED_THREE = 1000;
	public static final int SLOW_ATTACK_SPEED = 600;
	public static final int NORMAL_ATTACK_SPEED = 50;
	public static final int FAST_ATTACK_SPEED = 1;
	
	// Rangos
	public static final int SHORT_RANGE = 30;
	public static final int MEDIUM_RANGE = 50;
	public static final int LARGE_RANGE = 80;
	
	// Tamaño imagen
	public static final int TOWER_DIMENSION = 32;
	
	// IDs.
	public static final int FREE_ANTIVIRUS = 0;
	public static final int HOME_ANTIVIRUS = 1;
	public static final int ENTERPRISE_ANTIVIRUS = 2;
	public static final int TRIAL_ANTIWORM = 3;
	public static final int STANDARD_ANTIWORM = 4;
	public static final int PRO_ANTIWORM = 5;
	public static final int SYSTEM_FIREWALL = 6;
	public static final int NONO_FIREWALL = 7;
	public static final int ACCESSDENIED_FIREWALL = 8;
	public static final int SPY_SWEEPER = 9;
	public static final int SPY_TERMINATOR = 10;
	public static final int SPY_BOT = 11;
	
	// Numero máximo de incrementos
	public static final int MAX_RANGE_INCREMENTS = 3;
	public static final int MAX_DAMAGE_INCREMENTS = 3;
	
	// Características de la torre
	private int attackSpeed;
	private int numberOfObjectives;
	private int damage;
	private int range;
	private int price;
	private int ineffectiveAgainstThreatID;
	private int effectiveAgainstThreatID;
	private int towerID;
	private String title;
	
	// Gráfico
	private Rectangle squareRange;
	private Rectangle graphicTower;
	
	// Variables para comportiento de las torres.
	private int speedCounter;
	private ArrayList<Threat> objectives;
	private boolean isShooting;
	public boolean isClick = false;
	private int xMap, yMap;
	private int usedRangeIncrements = 0;
	private int usedDamageIncrements = 0;
	
	public Tower(int x, int y, int xMap, int yMap) {
		graphicTower = new Rectangle(x,y,TOWER_DIMENSION,TOWER_DIMENSION);
		isShooting = false;
		speedCounter = 0;
		objectives = new ArrayList<Threat>();
		this.xMap = xMap;
		this.yMap = yMap;
	}
	
	public Tower(int xMap, int yMap) {
		graphicTower = new Rectangle();
		isShooting = false;
		speedCounter = 0;
		objectives = new ArrayList<Threat>();
		this.xMap = xMap;
		this.yMap = yMap;
	}

	public Rectangle getSquareRange() {
		return squareRange;
	}

	public int getTowerID() {
		return towerID;
	}

	public void setTowerID(int towerID) {
		this.towerID = towerID;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
		this.squareRange = new Rectangle(graphicTower.x-range,graphicTower.y-range,Tower.TOWER_DIMENSION+range*2,Tower.TOWER_DIMENSION+range*2);
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public boolean isShooting() {
		return isShooting;
	}

	public ArrayList<Threat> getObjectives() {
		return objectives;
	}
	
	public int getNumberOfObjectives() {
		return numberOfObjectives;
	}

	public void setNumberOfObjectives(int numberOfObjectives) {
		this.numberOfObjectives = numberOfObjectives;
	}
	
	public int getIneffectiveAgainstThreatID() {
		return ineffectiveAgainstThreatID;
	}

	public void setIneffectiveAgainstThreatID(int ineffectiveAgainstThreatID) {
		this.ineffectiveAgainstThreatID = ineffectiveAgainstThreatID;
	}

	public int getEffectiveAgainstThreatID() {
		return effectiveAgainstThreatID;
	}

	public void setEffectiveAgainstThreatID(int effectiveAgainstThreatID) {
		this.effectiveAgainstThreatID = effectiveAgainstThreatID;
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getxMap() {
		return xMap;
	}

	public int getyMap() {
		return yMap;
	}

	// Seleccionar objetivos.
	public void selectObjectives() {
		
		Threat selectedObjective;
		isShooting = false;
		// Limpiar.
		objectives.clear();
		
		for(int i = 0, selectedObjectives = 0 ; i < Window.getInstance().getPlayPanel().getGame().getWave().getThreats().length && selectedObjectives < getNumberOfObjectives(); i++) {
			if(Window.getInstance().getPlayPanel().getGame().getWave().getThreats()[i].isInGame()) {
				
				// Si una amenaza intersecta el cuadrado de rango de la torre, la agregamos como objetivo.
				if(squareRange.intersects(Window.getInstance().getPlayPanel().getGame().getWave().getThreats()[i].getHitBox())) {

					isShooting = true;
					selectedObjective = Window.getInstance().getPlayPanel().getGame().getWave().getThreats()[i];
					
					if(selectedObjective != null && !objectives.contains(selectedObjective)) {
						objectives.add(selectedObjective);
						selectedObjectives++;
					}

				
				}
			}
		}

	}
	
	// La torre ataca a sus objetivos.
	public void attack() {

		Threat objective;
		
		selectObjectives();
		
		if(speedCounter >= getAttackSpeed()) {
			speedCounter = 0;

			for(int i = 0 ; i < getObjectives().size() ; i++) {
				objective = getObjectives().get(i); 

				if(getEffectiveAgainstThreatID() == objective.getThreatID()) {
					objective.setHealth((int)(objective.getHealth() - (1.5)*this.getDamage()));
				} else if(getIneffectiveAgainstThreatID() == objective.getThreatID()){
					objective.setHealth((int)(objective.getHealth() - (0.5)*this.getDamage()));
				} else {
					objective.setHealth((int)(objective.getHealth() - this.getDamage()));
				}
				
				especialFeature(objective);
				
			}
		} else {
			speedCounter += 1;
		}
		
	}

	public int getIncrementedDamage() {
		return getDamage()+(int)Math.floor(10.0*(double)this.getDamage()/100.0)+1;
	}
	
	public int getIncrementedRange() {
		return getRange()+(int)(33.0*(double)this.getRange()/100.0);
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setClick(boolean isClick) {
		this.isClick = isClick;
	}
	
	public void incrementRange() {
		if(usedRangeIncrements < MAX_RANGE_INCREMENTS) {
			this.setRange(getIncrementedRange());
			this.usedRangeIncrements++;	
		}
	}
	
	public void incrementDamage() {
		if(usedDamageIncrements < MAX_DAMAGE_INCREMENTS) {
			this.setDamage(getIncrementedDamage());
			this.usedDamageIncrements++;	
		}
	}
		
	public int getUsedRangeIncrements() {
		return usedRangeIncrements;
	}

	public void setUsedRangeIncrements(int usedRangeIncrements) {
		this.usedRangeIncrements = usedRangeIncrements;
	}

	public int getUsedDamageIncrements() {
		return usedDamageIncrements;
	}

	public void setUsedDamageIncrements(int usedDamageIncrements) {
		this.usedDamageIncrements = usedDamageIncrements;
	}

	public Rectangle getGraphicTower() {
		return graphicTower;
	}

	public void setGraphicTower(Rectangle graphicTower) {
		this.graphicTower = graphicTower;
	}

	// Dibuja la animación de disparo.
	public abstract void draw(Graphics g); 
	
	// Ataque especial.
	public abstract void especialFeature(Threat t);
		
}
