package towers;

import threats.Threat;

public abstract class AntiVirus extends Tower {
	
	private static final long serialVersionUID = 8270286474279262644L;
	
	public static final String DESCRIPTION_EFFECTIVENESS_ONE = "150% damage to trojans.";
	public static final String DESCRIPTION_EFFECTIVENESS_TWO = "*  50% damage to spies.";

	public AntiVirus(int x, int y, int xMap, int yMap) {
		super(x, y, xMap, yMap);
		this.setEffectiveAgainstThreatID(Threat.TROJAN);
		this.setIneffectiveAgainstThreatID(Threat.SPY);
	}

	@Override
	public void especialFeature(Threat t) {
		
	}

}
