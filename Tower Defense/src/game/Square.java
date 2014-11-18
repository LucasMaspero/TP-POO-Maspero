package game;

import graphics.Drawable;
import java.awt.Rectangle;
import java.io.Serializable;

public abstract class Square extends Rectangle implements Drawable, Serializable {

	private static final long serialVersionUID = 1L;

	public static final int WALL = 0;
	public static final int BLOCK_SIZE = 32;
	
	private int imageID;

	public Square(int x, int y) {
		setBounds(x,y,BLOCK_SIZE,BLOCK_SIZE);
	}

	public int getImageID() {
		return imageID;
	}

	public void setImageID(int imageID) {
		this.imageID = imageID;
	}

}
