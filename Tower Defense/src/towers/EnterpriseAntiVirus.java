package towers;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

import threats.Threat;

public class EnterpriseAntiVirus extends AntiVirus {

	private static final long serialVersionUID = -1396242643675219241L;

	// Gráficos
	private static final int[] yTrailOne = {4,5,5,6,7,8,8,9,10,10,11,12,12,13,14,14,15,15,16,17,18,19,20,21,22,23,24,24,25,25,26,26,26,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,5,4};
	private static final int[] xTrailOne = {25,25,26,26,26,26,25,25,25,24,24,24,23,23,23,22,22,21,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,5,5,6,6,7,7,8,9,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
	private static final int[] yTrailTwo = {4,5,5,6,7,8,9,10,11,12,12,13,14,15,16,17,18,19,20,21,22,23,24,25,25,26,26,26,26,26,25,24,23,22,21,20,19,18,18,17,16,15,14,13,12,11,10,9 ,8, 8, 7, 6, 6, 5,5,5,4};
	private static final int[] xTrailTwo = {5,5,4,4,4,4,5, 5, 6, 6, 7, 7, 8, 9,10,11,12,13,14,15,16,17,19,20,21,22,23,24,25,26,26,26,26,26,25,25,24,24,23,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6};
	private static final int[] yTrailThree = { 3, 3, 4, 4, 5, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,26,27,28,28,27,26,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10, 9, 8, 7, 6, 5, 4, 4};
	private static final int[] xTrailThree = {16,15,15,14,14,13,13,13,13,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,13,13,14,14,15,16,17,17,18,18,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,18,18,18,17,17,16};
	private static final int[] yTrailFour = {16,15,17,17,17,18,18,18,18,18,19,19,19,19,19,19,19,19,19,18,18,18,18,18,17,17,17,16,15,14,14,15,16,15,14,13,13,13,13,12,12,12,12,12,12,12,12,12,12,13,13,13,13,13,14,14,14};
	private static final int[] xTrailFour = {28,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10, 9, 8, 7, 6, 5, 4, 3, 3, 3, 4, 3, 4, 4, 5, 6, 7, 8, 9,10,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27};
	private int drawFrame = 6, drawSpeed = 0;
	private int i = 0;
	
	public static final int DEFAULT_PRICE = 2000;
	public static final String TITLE = "ENTERPRISE ANTI-VIRUS";
	public static final String DESCRIPTION_TARGETS_ONE = "EACH RING SHOOTS A TARGET.";
	public static final String DESCRIPTION_TARGETS_TWO = "  (4 TARGETS AT A TIME)";
	
	private static final int ATTACK_SPEED = FAST_ATTACK_SPEED;
	public static final int DEFAULT_RANGE = LARGE_RANGE;
	private static final int DEFAULT_DAMAGE = 1;
	private static final int NUMBER_OF_OBJECTIVES = 4;
	
	public EnterpriseAntiVirus(int x, int y, int xMap, int yMap) {
		super(x, y,xMap,yMap);
		this.setNumberOfObjectives(NUMBER_OF_OBJECTIVES);
		this.setAttackSpeed(ATTACK_SPEED);
		this.setTowerID(ENTERPRISE_ANTIVIRUS);
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
				if(i+1 >= xTrailOne.length) {
					i = 0;
				}

				i++;
			} else {
				drawSpeed += 1;
			}
		
			for(Threat objective : objectives) {
				if(objective != null) {
					if(objectives.indexOf(objective) == 0) {
						g.drawLine(getGraphicTower().x+xTrailOne[i],getGraphicTower().y+yTrailOne[i],objective.getHitBox().x +objective.getHitBox().width/2,objective.getHitBox().y + objective.getHitBox().height/2);
					} else if(objectives.indexOf(objective) == 1) {
						g.drawLine(getGraphicTower().x+xTrailTwo[i],getGraphicTower().y+yTrailTwo[i],objective.getHitBox().x +objective.getHitBox().width/2,objective.getHitBox().y + objective.getHitBox().height/2);
					} else if(objectives.indexOf(objective) == 2) {
						g.drawLine(getGraphicTower().x+xTrailThree[i],getGraphicTower().y+yTrailThree[i],objective.getHitBox().x +objective.getHitBox().width/2,objective.getHitBox().y + objective.getHitBox().height/2);
					} else {
						g.drawLine(getGraphicTower().x+xTrailFour[i],getGraphicTower().y+yTrailFour[i],objective.getHitBox().x +objective.getHitBox().width/2,objective.getHitBox().y + objective.getHitBox().height/2);
					}	
				}
			}
		}
		
	}
	
}
