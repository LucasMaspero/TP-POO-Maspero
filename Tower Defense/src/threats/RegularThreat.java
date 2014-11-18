package threats;

public class RegularThreat extends Threat {

	private static final long serialVersionUID = 1L;

	public static final int DEFAULT_HEALTH = Threat.NORMAL_HEALTH;
	public static final int DEFAULT_SPEED = Threat.MEDIUM_SPEED;
	
	public RegularThreat() {
		super(Threat.REGULAR_THREAT,false,DEFAULT_HEALTH,DEFAULT_SPEED);
	}
	
}
