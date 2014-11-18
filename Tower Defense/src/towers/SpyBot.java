package towers;

public class SpyBot extends AntiSpy {
	
	private static final long serialVersionUID = 4013434741340908250L;
	
	public static final int DEFAULT_PRICE = 1700;
	public static final String TITLE = "SPYBOT ANTI-SPYWARE";
	public static final String DESCRIPTION_TARGETS_ONE = "POISONS THE TARGET.";
	public static final String DESCRIPTION_TARGETS_TWO = "  (3 TARGETS AT A TIME)";
	
	public static final int DEFAULT_RANGE = SHORT_RANGE;
	private static final int DEFAULT_DAMAGE = 500;
	private static final int ATTACK_SPEED = SLOW_ATTACK_SPEED;
	private static final int NUMBER_OF_OBJECTIVES = 3;
	private static final int MARK_INDEX = 8; // Indice de la marca que la torre coloca a en la amenaza.

	public SpyBot(int x, int y, int xMap, int yMap) {
		super(x, y, xMap, yMap);
		this.setNumberOfObjectives(NUMBER_OF_OBJECTIVES);
		this.setAttackSpeed(ATTACK_SPEED);
		this.setTowerID(SPY_BOT);
		this.setRange(DEFAULT_RANGE);
		this.setDamage(DEFAULT_DAMAGE);
		this.setTitle(TITLE);
		this.setPrice(DEFAULT_PRICE);
		this.setMarkID(MARK_INDEX);
	}
	
}
