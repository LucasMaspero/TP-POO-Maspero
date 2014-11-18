package towers;

import threats.Threat;

public class AccessDeniedFirewall extends FireWall {
	
	private static final long serialVersionUID = 1449039640187552232L;
	
	public static final int DEFAULT_PRICE = 2500;
	public static final String TITLE = "ACCESS DENIED FIREWALL";
	public static final String DESCRIPTION_TARGETS_ONE = "SLOWS THE TARGET.";
	public static final String DESCRIPTION_TARGETS_TWO = "  (1 TARGET AT A TIME)";
	
	private static final int ATTACK_SPEED = Tower.SLOW_ATTACK_SPEED;
	public static final int DEFAULT_RANGE = LARGE_RANGE;
	private static final int DEFAULT_DAMAGE = 250;
	private static final int NUMBER_OF_OBJECTIVES = 1;
	private static final int MARK_INDEX = 5; // Indice de la marca que la torre coloca a en la amenaza.

	public AccessDeniedFirewall(int x, int y, int xMap, int yMap) {
		super(x, y, xMap, yMap);
		this.setNumberOfObjectives(NUMBER_OF_OBJECTIVES);
		this.setAttackSpeed(ATTACK_SPEED);
		this.setTowerID(ACCESSDENIED_FIREWALL);
		this.setRange(DEFAULT_RANGE);
		this.setDamage(DEFAULT_DAMAGE);
		this.setTitle(TITLE);
		this.setPrice(DEFAULT_PRICE);
		this.setMarkID(MARK_INDEX);
		this.setSlowNumber(Threat.HIGH_SLOW);
	}

}
