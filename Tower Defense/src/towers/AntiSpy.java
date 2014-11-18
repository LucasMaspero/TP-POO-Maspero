package towers;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import main.Window;
import threats.Threat;

public abstract class AntiSpy extends Tower {
	
	private static final long serialVersionUID = -5108289915128295509L;
	
	public static final String DESCRIPTION_EFFECTIVENESS_ONE = "150% damage to spies.";
	public static final String DESCRIPTION_EFFECTIVENESS_TWO = "*  50% damage to keyloggers.";

	private int markID;

	// Gráficos
	private int xTrail[] = { 13,16,19,22,25,27,28,28,27,25,22,19,16,13,10, 7, 5, 4, 4, 5, 7, 10 } ;
	private int yTrail[] = {  4, 4, 4, 6, 8,11,14,17,20,23,25,27,27,27,25,23,20,17,14,11, 8, 6 };

	public AntiSpy(int x, int y, int xMap, int yMap) {
		super(x, y, xMap, yMap);
		this.setEffectiveAgainstThreatID(Threat.SPY);
		this.setIneffectiveAgainstThreatID(Threat.KEYLOGGER);
	}

	public int getMarkID() {
		return markID;
	}

	public void setMarkID(int markID) {
		this.markID = markID;
	}
	
	@Override
	public void especialFeature(Threat t) {
		t.poison();
	}
	
	@Override
	public void draw(Graphics g) {
		
		ArrayList<Threat> objectives = new ArrayList<Threat>(getObjectives());
		
		if(this.isShooting()) {
			g.setColor(new Color(0,0,255));
			
			for(Threat objective : objectives) {
				if(objective != null) {
					for(int i = 0 ; i < xTrail.length ; i++) {
						g.drawLine(getGraphicTower().x+xTrail[i],getGraphicTower().y+yTrail[i],objective.getHitBox().x +objective.getHitBox().width/2,objective.getHitBox().y + objective.getHitBox().height/2);						
					}
					g.drawImage(Window.getInstance().getPlayPanel().getTileset_marks_towers().getImage(getMarkID()), objective.getHitBox().x, objective.getHitBox().y, objective.getHitBox().width,objective.getHitBox().height, null);
				}
			}

		}
		
	}
	
	
}
