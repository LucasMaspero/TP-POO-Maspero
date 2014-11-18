package towers;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import main.Window;
import threats.Threat;

public abstract class FireWall extends Tower {
	
	private static final long serialVersionUID = -2892889041281547180L;
	
	public static final String DESCRIPTION_EFFECTIVENESS_ONE = "150% damage to keyloggers.";
	public static final String DESCRIPTION_EFFECTIVENESS_TWO = "*  50% damage to worms.";
	
	private int markID;
	private int slowNumber;
	
	public FireWall(int x, int y, int xMap, int yMap) {
		super(x, y, xMap, yMap);
		this.setEffectiveAgainstThreatID(Threat.KEYLOGGER);
		this.setIneffectiveAgainstThreatID(Threat.WORM);
	}
	
	public int getMarkID() {
		return markID;
	}

	public void setMarkID(int markID) {
		this.markID = markID;
	}
	
	public int getSlowNumber() {
		return slowNumber;
	}

	public void setSlowNumber(int slowNumber) {
		this.slowNumber = slowNumber;
	}

	@Override
	public void especialFeature(Threat t) {
		t.slow(getSlowNumber());
	}
	
	@Override
	public void draw(Graphics g) {
		
		ArrayList<Threat> objectives = new ArrayList<Threat>(getObjectives());
		
		if(this.isShooting()) {
			g.setColor(new Color(255,255,255));
			
			for(Threat objective : objectives) {
				if(objective != null) {
					g.drawLine(getGraphicTower().x,getGraphicTower().y,objective.getHitBox().x +objective.getHitBox().width/2,objective.getHitBox().y + objective.getHitBox().height/2);
					g.drawLine(getGraphicTower().x+32,getGraphicTower().y+32,objective.getHitBox().x +objective.getHitBox().width/2,objective.getHitBox().y + objective.getHitBox().height/2);
					g.drawLine(getGraphicTower().x+32,getGraphicTower().y,objective.getHitBox().x +objective.getHitBox().width/2,objective.getHitBox().y + objective.getHitBox().height/2);
					g.drawLine(getGraphicTower().x,getGraphicTower().y+32,objective.getHitBox().x +objective.getHitBox().width/2,objective.getHitBox().y + objective.getHitBox().height/2);
					g.drawImage(Window.getInstance().getPlayPanel().getTileset_marks_towers().getImage(getMarkID()), objective.getHitBox().x, objective.getHitBox().y, objective.getHitBox().width,objective.getHitBox().height, null);
				}
			}

		}
		
	}

}	