package threats;

public class Trojan extends Threat {

	private static final long serialVersionUID = 1L;

	public static final int DEFAULT_HEALTH = Threat.NORMAL_HEALTH;
	public static final int DEFAULT_SPEED = Threat.MEDIUM_SPEED;
	
	public Trojan() {
		super(Threat.TROJAN,false,DEFAULT_HEALTH,DEFAULT_SPEED);
	}
	
}

