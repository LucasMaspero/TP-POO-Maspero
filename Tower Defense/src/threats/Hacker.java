package threats;

public class Hacker extends Threat {

	private static final long serialVersionUID = 1L;

	public static final int DEFAULT_HEALTH = Threat.BOSS_HEALTH;
	public static final int DEFAULT_SPEED = Threat.MEDIUM_SPEED;
	
	public Hacker() {
		super(Threat.HACKER,true,DEFAULT_HEALTH,DEFAULT_SPEED);
	}
	
}
