package threats;

public class KeyLogger extends Threat {

	private static final long serialVersionUID = 1L;

	public static final int DEFAULT_HEALTH = Threat.NORMAL_HEALTH;
	public static final int DEFAULT_SPEED = Threat.MEDIUM_SPEED;
	
	public KeyLogger() {
		super(Threat.KEYLOGGER,false,DEFAULT_HEALTH,DEFAULT_SPEED);
	}
	
}
