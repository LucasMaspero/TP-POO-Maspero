package towers;

import threats.Threat;

public class NoNoFirewall extends FireWall {
	
	private static final long serialVersionUID = 6470730850228872114L;
	
	public static final int DEFAULT_PRICE = 1150;
	public static final String TITLE = "NONO FIREWALL";
	public static final String DESCRIPTION_TARGETS_ONE = "SLOWS THE TARGET.";
	public static final String DESCRIPTION_TARGETS_TWO = "  (1 TARGET AT A TIME)";
	
	public static final int DEFAULT_RANGE = MEDIUM_RANGE;
	private static final int DEFAULT_DAMAGE = 140;
	private static final int ATTACK_SPEED = Tower.NORMAL_ATTACK_SPEED;
	private static final int NUMBER_OF_OBJECTIVES = 1;
	private static final int MARK_INDEX = 4; // Indice de la marca que la torre coloca a en la amenaza.

	public NoNoFirewall(int x, int y, int xMap, int yMap) {
		super(x, y, xMap, yMap);
		this.setNumberOfObjectives(NUMBER_OF_OBJECTIVES);
		this.setAttackSpeed(ATTACK_SPEED);
		this.setTowerID(NONO_FIREWALL);
		this.setRange(DEFAULT_RANGE);
		this.setDamage(DEFAULT_DAMAGE);
		this.setTitle(TITLE);
		this.setPrice(DEFAULT_PRICE);
		this.setMarkID(MARK_INDEX);
		this.setSlowNumber(Threat.MEDIUM_SLOW);
	}

}
