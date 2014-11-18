package graphics;

import java.awt.Graphics;

public class AnimationDrawer implements Drawable {
	
	private TileSet animation;
	
	private int aniFrame;
	private int aniRate;	// Velocidad de animación
	private int aniIndex;
	
	private int x,y,width,height;
	
	public AnimationDrawer(int aniRate) {
		this.aniRate = aniRate;
		this.aniIndex = 0;
		this.aniFrame = 0;
	}
	
	public TileSet getAnimation() {
		return animation;
	}

	public void setAnimation(TileSet animation) {
		this.animation = animation;
	}

	@Override
	public void draw(Graphics g) {
				
		if(aniFrame >= aniRate) {
			aniFrame = 0;
			if(aniIndex+1 >= animation.getLength()) {
				aniIndex = 0;
			} else{
				aniIndex++;
			}
		} else {
			aniFrame++;
		}
		g.drawImage(animation.getImage(aniIndex), x, y, width, height, null);
		
	}
	
	public void reset() {
		aniIndex = 0;
	}
	
	public void setPosition(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}	

}
