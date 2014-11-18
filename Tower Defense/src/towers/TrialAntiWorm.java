package towers;

public class TrialAntiWorm extends AntiWorm {
	
	private static final long serialVersionUID = -4316806004642356993L;
	
	public static final int DEFAULT_PRICE = 220;
	public static final String TITLE = "TRIAL ANTI-WORM";
	public static final String DESCRIPTION_TARGETS_ONE = "TONS OF DAMAGE IN EACH ATTACK.";
	public static final String DESCRIPTION_TARGETS_TWO = "  (1 TARGET AT A TIME)";
	
	public static final int DEFAULT_RANGE = SHORT_RANGE;
	private static final int DEFAULT_DAMAGE = 800;
	private static final int ATTACK_SPEED = REAL_SLOW_ATTACK_SPEED_THREE;
	private static final int NUMBER_OF_OBJECTIVES = 1;
	private static final int MARK_INDEX = 0; // Indice de la marca que la torre coloca a en la amenaza.
	
	public TrialAntiWorm(int x, int y, int xMap, int yMap) {
		super(x, y,xMap,yMap);
		this.setNumberOfObjectives(NUMBER_OF_OBJECTIVES);
		this.setAttackSpeed(ATTACK_SPEED);
		this.setTowerID(TRIAL_ANTIWORM);
		this.setRange(DEFAULT_RANGE);
		this.setDamage(DEFAULT_DAMAGE);
		this.setTitle(TITLE);
		this.setPrice(DEFAULT_PRICE);
		this.setMarkID(MARK_INDEX);
	}

}
