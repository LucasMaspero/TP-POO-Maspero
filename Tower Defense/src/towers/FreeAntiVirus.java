package towers;

import java.awt.*;
import java.util.ArrayList;

import threats.Threat;

public class FreeAntiVirus extends AntiVirus {
	
	private static final long serialVersionUID = 1706181174801610418L;
	
	// Gr�ficos
	private static final int[] yTrail = {4,5,5,6,7,8,8,9,10,10,11,12,12,13,14,14,15,15,16,17,18,19,20,21,22,23,24,24,25,25,26,26,26,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,5,4};
	private static final int[] xTrail = {25,25,26,26,26,26,25,25,25,24,24,24,23,23,23,22,22,21,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,5,5,6,6,7,7,8,9,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
	private int drawFrame = 6, drawSpeed = 0;
	private int i = 0;
	
	public static final int DEFAULT_PRICE = 100;
	public static final String TITLE = "FREE ANTI-VIRUS";
	public static final String DESCRIPTION_TARGETS_ONE = "EACH RING SHOOTS A TARGET.";
	public static final String DESCRIPTION_TARGETS_TWO = "  (1 TARGET AT A TIME)";
	
	public static final int DEFAULT_RANGE = SHORT_RANGE;
	private static final int DEFAULT_DAMAGE = 1;
	private static final int ATTACK_SPEED = FAST_ATTACK_SPEED;
	private static final int NUMBER_OF_OBJECTIVES = 1;
	
	public FreeAntiVirus(int x, int y, int xMap, int yMap) {
		super(x, y,xMap,yMap);
		this.setNumberOfObjectives(NUMBER_OF_OBJECTIVES);
		this.setAttackSpeed(ATTACK_SPEED);
		this.setTowerID(FREE_ANTIVIRUS);
		this.setRange(DEFAULT_RANGE);
		this.setDamage(DEFAULT_DAMAGE);
		this.setTitle(TITLE);
		this.setPrice(DEFAULT_PRICE);
	}
	
	@Override
	public void draw(Graphics g) {
		
		ArrayList<Threat> objectives = new ArrayList<Threat>(getObjectives());
		
		if(this.isShooting()) {
			g.setColor(new Color(133,255,28));
			
			if(drawFrame < drawSpeed) {
				drawSpeed = 0;
				if(i+1 >= xTrail.length) {
					i = 0;
				}

				i++;
			} else {
				drawSpeed += 1;
			}
			
			for(Threat objective : objectives) {
				if(objective != null) {
					g.drawLine(getGraphicTower().x+xTrail[i],getGraphicTower().y+yTrail[i],objective.getHitBox().x +objective.getHitBox().width/2,objective.getHitBox().y + objective.getHitBox().height/2);
				}
			}

		}
		
	}
	
}