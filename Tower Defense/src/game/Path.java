package game;

import graphics.Drawable;

import java.awt.Graphics;
import java.io.Serializable;

import main.Window;

public class Path extends Square implements Serializable, Drawable {

	private static final long serialVersionUID = 1L;
	
	public static final int LEFT_ROAD = 1;
	public static final int RIGHT_ROAD = 2;
	public static final int LEFT_FINISH = 3;
	public static final int RIGHT_FINISH = 4;
	
	private int pathID;

	public Path(int x, int y, int pathID) {
		super(x, y);
		this.pathID = pathID;
	}

	public int getPathID() {
		return pathID;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(Window.getInstance().getPlayPanel().getTileset_map().getImage(getImageID()),x,y,width,height,null);
	}

}
