package towers;

public class SpyTerminator extends AntiSpy {
	
	private static final long serialVersionUID = 8011210115674738798L;
	
	public static final int DEFAULT_PRICE = 1000;
	public static final String TITLE = "SPY TERMINATOR";
	public static final String DESCRIPTION_TARGETS_ONE = "POISONS THE TARGET.";
	public static final String DESCRIPTION_TARGETS_TWO = "  (2 TARGETS AT A TIME)";
	
	public static final int DEFAULT_RANGE = SHORT_RANGE;
	private static final int DEFAULT_DAMAGE = 250;
	private static final int ATTACK_SPEED = SLOW_ATTACK_SPEED;
	private static final int NUMBER_OF_OBJECTIVES = 2;
	private static final int MARK_INDEX = 7; // Indice de la marca que la torre coloca a en la amenaza.

	public SpyTerminator(int x, int y, int xMap, int yMap) {
		super(x, y, xMap, yMap);
		this.setNumberOfObjectives(NUMBER_OF_OBJECTIVES);
		this.setAttackSpeed(ATTACK_SPEED);
		this.setTowerID(SPY_TERMINATOR);
		this.setRange(DEFAULT_RANGE);
		this.setDamage(DEFAULT_DAMAGE);
		this.setTitle(TITLE);
		this.setPrice(DEFAULT_PRICE);
		this.setMarkID(MARK_INDEX);
	}
	
}
