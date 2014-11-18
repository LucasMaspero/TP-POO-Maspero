package threats;

public class Worm extends Threat {
	
	private static final long serialVersionUID = 1L;
	
	public static final int DEFAULT_HEALTH = Threat.STRONG_HEALTH;
	public static final int DEFAULT_SPEED = Threat.SLOW_SPEED;
	
	public Worm() {
		super(Threat.WORM,false,DEFAULT_HEALTH,DEFAULT_SPEED);
	}

}
