package towers;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import main.Window;
import threats.Threat;

public class AntiWorm extends Tower {
	
	private static final long serialVersionUID = -1485436680176590433L;
	
	public static final String DESCRIPTION_EFFECTIVENESS_ONE = "150% damage to worms.";
	public static final String DESCRIPTION_EFFECTIVENESS_TWO = "*  50% damage to trojans.";

	private int markID;
	
	public AntiWorm(int x, int y, int xMap, int yMap) {
		super(x, y, xMap, yMap);
		this.setEffectiveAgainstThreatID(Threat.WORM);
		this.setIneffectiveAgainstThreatID(Threat.TROJAN);
	}
	
	public int getMarkID() {
		return markID;
	}

	public void setMarkID(int markID) {
		this.markID = markID;
	}
	
	@Override
	public void especialFeature(Threat t) {
		
	}
	
	@Override
	public void draw(Graphics g) {
		
		ArrayList<Threat> objectives = new ArrayList<Threat>(getObjectives());
		
		if(this.isShooting()) {
			g.setColor(new Color(255,127,39));
			
			for(Threat objective : objectives) {
				if(objective != null) {
					g.drawLine(getGraphicTower().x+Tower.TOWER_DIMENSION/2,getGraphicTower().y+Tower.TOWER_DIMENSION/2,objective.getHitBox().x +objective.getHitBox().width/2,objective.getHitBox().y + objective.getHitBox().height/2);
					g.drawLine(1+getGraphicTower().x+Tower.TOWER_DIMENSION/2,1+getGraphicTower().y+Tower.TOWER_DIMENSION/2,1+objective.getHitBox().x +objective.getHitBox().width/2,1+objective.getHitBox().y + objective.getHitBox().height/2);
					g.drawLine(-1+getGraphicTower().x+Tower.TOWER_DIMENSION/2,-1+getGraphicTower().y+Tower.TOWER_DIMENSION/2,-1+objective.getHitBox().x +objective.getHitBox().width/2,-1+objective.getHitBox().y + objective.getHitBox().height/2);
					g.drawLine(2+getGraphicTower().x+Tower.TOWER_DIMENSION/2,2+getGraphicTower().y+Tower.TOWER_DIMENSION/2,2+objective.getHitBox().x +objective.getHitBox().width/2,2+objective.getHitBox().y + objective.getHitBox().height/2);
					g.drawLine(-2+getGraphicTower().x+Tower.TOWER_DIMENSION/2,-2+getGraphicTower().y+Tower.TOWER_DIMENSION/2,-2+objective.getHitBox().x +objective.getHitBox().width/2,-2+objective.getHitBox().y + objective.getHitBox().height/2);

					g.drawImage(Window.getInstance().getPlayPanel().getTileset_marks_towers().getImage(getMarkID()), objective.getHitBox().x, objective.getHitBox().y, objective.getHitBox().width,objective.getHitBox().height, null);
				}
			}

		}
		
	}
	
}
