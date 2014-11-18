package towers;

public class ProAntiWorm extends AntiWorm {
	
	private static final long serialVersionUID = 4954575107315575266L;
	
	public static final int DEFAULT_PRICE = 3000;
	public static final String TITLE = "PRO ANTI-WORM";
	public static final String DESCRIPTION_TARGETS_ONE = "TONS OF DAMAGE IN EACH ATTACK.";
	public static final String DESCRIPTION_TARGETS_TWO = "  (3 TARGETS AT A TIME)";
	
	public static final int DEFAULT_RANGE = LARGE_RANGE;
	private static final int DEFAULT_DAMAGE = 2000;
	private static final int ATTACK_SPEED = REAL_SLOW_ATTACK_SPEED_ONE;
	private static final int NUMBER_OF_OBJECTIVES = 3;
	private static final int MARK_INDEX = 2; // Indice de la marca que la torre coloca a en la amenaza.
	
	public ProAntiWorm(int x, int y, int xMap, int yMap) {
		super(x, y,xMap,yMap);
		this.setNumberOfObjectives(NUMBER_OF_OBJECTIVES);
		this.setAttackSpeed(ATTACK_SPEED);
		this.setTowerID(PRO_ANTIWORM);
		this.setRange(DEFAULT_RANGE);
		this.setDamage(DEFAULT_DAMAGE);
		this.setTitle(TITLE);
		this.setPrice(DEFAULT_PRICE);
		this.setMarkID(MARK_INDEX);
	}

}
