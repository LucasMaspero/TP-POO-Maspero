package graphics;

import java.awt.Graphics;

import main.Window;

public class Computer implements Drawable {

	// Dimensiones y coordenadas
	private static final int X_COMPUTER = 7;
	private static final int Y_COMPUTER = 2;
	public static final int WIDTH_COMPUTER = 249;
	public static final int HEIGHT_COMPUTER = 221;
	
	// Índices para las imágenes de la computadora
	private static final int COMPUTER_SAFE_INDEX = 0;
	private static final int COMPUTER_INFECTED_INDEX = 1;
	private static final int COMPUTER_SERIOUSLY_INFECTED_INDEX = 2;
	private static final int COMPUTER_BROKEN_INDEX = 3;
	private static final int COMPUTER_CRASHED_INDEX = 4;
	private static final int GAME_OVER_INDEX = 5;
	
	// Etapas de la computadora
	private static final int COMPUTER_SAFE = 20;
	private static final int COMPUTER_INFECTED = 15;
	private static final int COMPUTER_SERIOUSLY_INFECTED = 10;
	private static final int COMPUTER_BROKEN = 5;
	private static final int COMPUTER_CRASHED = 1;
	
	@Override
	public void draw(Graphics g) {
		
		if(Window.getInstance().getPlayPanel().getGame().getStats().getLifes() >= COMPUTER_SAFE) {
			g.drawImage(Window.getInstance().getPlayPanel().getTileset_computer().getImage(COMPUTER_SAFE_INDEX), X_COMPUTER, Y_COMPUTER, WIDTH_COMPUTER, HEIGHT_COMPUTER, null);
		} else if(Window.getInstance().getPlayPanel().getGame().getStats().getLifes() < COMPUTER_SAFE && Window.getInstance().getPlayPanel().getGame().getStats().getLifes() >= COMPUTER_INFECTED) {
			g.drawImage(Window.getInstance().getPlayPanel().getTileset_computer().getImage(COMPUTER_INFECTED_INDEX), X_COMPUTER, Y_COMPUTER, WIDTH_COMPUTER, HEIGHT_COMPUTER, null);
		} else if(Window.getInstance().getPlayPanel().getGame().getStats().getLifes() < COMPUTER_INFECTED && Window.getInstance().getPlayPanel().getGame().getStats().getLifes() >= COMPUTER_SERIOUSLY_INFECTED) {
			g.drawImage(Window.getInstance().getPlayPanel().getTileset_computer().getImage(COMPUTER_SERIOUSLY_INFECTED_INDEX), X_COMPUTER, Y_COMPUTER, WIDTH_COMPUTER, HEIGHT_COMPUTER, null);
		} else if(Window.getInstance().getPlayPanel().getGame().getStats().getLifes() < COMPUTER_SERIOUSLY_INFECTED && Window.getInstance().getPlayPanel().getGame().getStats().getLifes() >= COMPUTER_BROKEN) {
			g.drawImage(Window.getInstance().getPlayPanel().getTileset_computer().getImage(COMPUTER_BROKEN_INDEX), X_COMPUTER, Y_COMPUTER, WIDTH_COMPUTER, HEIGHT_COMPUTER, null);
		} else if(Window.getInstance().getPlayPanel().getGame().getStats().getLifes() < COMPUTER_BROKEN && Window.getInstance().getPlayPanel().getGame().getStats().getLifes() >= COMPUTER_CRASHED) {
			g.drawImage(Window.getInstance().getPlayPanel().getTileset_computer().getImage(COMPUTER_CRASHED_INDEX), X_COMPUTER, Y_COMPUTER, WIDTH_COMPUTER, HEIGHT_COMPUTER, null);
		} else {
			g.drawImage(Window.getInstance().getPlayPanel().getTileset_computer().getImage(GAME_OVER_INDEX), X_COMPUTER, Y_COMPUTER, WIDTH_COMPUTER, HEIGHT_COMPUTER, null);
		}
	}

}
