package threats;

public class Spam extends Threat {
	
	private static final long serialVersionUID = 1L;
	
	public static final int DEFAULT_HEALTH = Threat.WEAK_HEALTH;
	public static final int DEFAULT_SPEED = FAST_SPEED;
	
	public Spam() {
		super(Threat.SPAM,false,DEFAULT_HEALTH,DEFAULT_SPEED);
	}

}
