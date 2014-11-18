package towers;

import threats.Threat;

public class SystemFirewall extends FireWall {
	
	private static final long serialVersionUID = -2287512698778039564L;
	
	public static final int DEFAULT_PRICE = 310;
	public static final String TITLE = "SYSTEM FIREWALL";
	public static final String DESCRIPTION_TARGETS_ONE = "SLOWS THE TARGET.";
	public static final String DESCRIPTION_TARGETS_TWO = "  (1 TARGET AT A TIME)";
	
	public static final int DEFAULT_RANGE = SHORT_RANGE;
	private static final int DEFAULT_DAMAGE = 28;
	private static final int ATTACK_SPEED = Tower.NORMAL_ATTACK_SPEED;
	private static final int NUMBER_OF_OBJECTIVES = 1;
	private static final int MARK_INDEX = 3; // Indice de la marca que la torre coloca a en la amenaza.

	public SystemFirewall(int x, int y, int xMap, int yMap) {
		super(x, y, xMap, yMap);
		this.setNumberOfObjectives(NUMBER_OF_OBJECTIVES);
		this.setAttackSpeed(ATTACK_SPEED);
		this.setTowerID(SYSTEM_FIREWALL);
		this.setRange(DEFAULT_RANGE);
		this.setDamage(DEFAULT_DAMAGE);
		this.setTitle(TITLE);
		this.setPrice(DEFAULT_PRICE);
		this.setMarkID(MARK_INDEX);
		this.setSlowNumber(Threat.LOW_SLOW);
	}
	
}
