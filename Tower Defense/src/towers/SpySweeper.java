package towers;

public class SpySweeper extends AntiSpy {

	private static final long serialVersionUID = 923723654319613126L;

	public static final int DEFAULT_PRICE = 500;
	public static final String TITLE = "SPY SWEEPER";
	public static final String DESCRIPTION_TARGETS_ONE = "POISONS THE TARGET.";
	public static final String DESCRIPTION_TARGETS_TWO = "  (1 TARGET AT A TIME)";
	
	public static final int DEFAULT_RANGE = SHORT_RANGE;
	private static final int DEFAULT_DAMAGE = 100;
	private static final int ATTACK_SPEED = SLOW_ATTACK_SPEED;
	private static final int NUMBER_OF_OBJECTIVES = 1;
	private static final int MARK_INDEX = 6; // Indice de la marca que la torre coloca a en la amenaza.

	public SpySweeper(int x, int y, int xMap, int yMap) {
		super(x, y, xMap, yMap);
		this.setNumberOfObjectives(NUMBER_OF_OBJECTIVES);
		this.setAttackSpeed(ATTACK_SPEED);
		this.setTowerID(SPY_SWEEPER);
		this.setRange(DEFAULT_RANGE);
		this.setDamage(DEFAULT_DAMAGE);
		this.setTitle(TITLE);
		this.setPrice(DEFAULT_PRICE);
		this.setMarkID(MARK_INDEX);
	}
	
}
