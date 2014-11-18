package graphics;

import java.awt.Point;

public interface MouseUse {
	
	public static final int LEFT_CLICK = 1;
	public static final int RIGHT_CLICK = 3;
	
	public void click(Point p, int button);
	public void drag(Point p);

}
