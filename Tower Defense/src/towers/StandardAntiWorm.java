package towers;

public class StandardAntiWorm extends AntiWorm {
	
	private static final long serialVersionUID = -8309951838241145075L;
	
	public static final int DEFAULT_PRICE = 600;
	public static final String TITLE = "STANDARD ANTI-WORM";
	public static final String DESCRIPTION_TARGETS_ONE = "TONS OF DAMAGE IN EACH ATTACK.";
	public static final String DESCRIPTION_TARGETS_TWO = "  (2 TARGETS AT A TIME)";
	
	public static final int DEFAULT_RANGE = MEDIUM_RANGE;
	private static final int DEFAULT_DAMAGE = 1200;
	private static final int ATTACK_SPEED = REAL_SLOW_ATTACK_SPEED_TWO;
	private static final int NUMBER_OF_OBJECTIVES = 2;
	private static final int MARK_INDEX = 1; // Indice de la marca que la torre coloca a en la amenaza.
	
	public StandardAntiWorm(int x, int y, int xMap, int yMap) {
		super(x, y,xMap,yMap);
		this.setNumberOfObjectives(NUMBER_OF_OBJECTIVES);
		this.setAttackSpeed(ATTACK_SPEED);
		this.setTowerID(STANDARD_ANTIWORM);
		this.setRange(DEFAULT_RANGE);
		this.setDamage(DEFAULT_DAMAGE);
		this.setTitle(TITLE);
		this.setPrice(DEFAULT_PRICE);
		this.setMarkID(MARK_INDEX);
	}

}
