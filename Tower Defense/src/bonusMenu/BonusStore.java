package bonusMenu;

import game.Game;
import graphics.Description;
import graphics.Drawable;
import graphics.MouseUse;
import java.awt.Graphics;
import java.awt.Point;
import main.Window;
import button.DescriptiveButton;

public class BonusStore implements Drawable, MouseUse {

	// Coordenadas para los botones de bonus. 
	public static final int BONUS_BUTTON_DIMENSION = 32;
	private static final int X_STORE = 1100;
	private static final int Y_STORE = 118;
	private static final int Y_CELL_SPACE = 40;
	
	// Cantidad de bonus
	private static final int NUMBER_OF_BONUS = 4;
	
	// Botones representando a los bonus
	private DescriptiveButton[] buttons = new DescriptiveButton[NUMBER_OF_BONUS];
	
	public BonusStore() {
		 
		buttons[0] = new ExtraLifesBonus(X_STORE,Y_STORE,BONUS_BUTTON_DIMENSION,BONUS_BUTTON_DIMENSION,Window.getInstance().getPlayPanel().getTileset_bonus().getImage(4),Window.getInstance().getPlayPanel().getTileset_bonus().getImage(0),new Description("EXTRA LIFES BONUS","BONUS:","This bonus will give you","  five extra lifes.","PRICE:","Costs: 1 bonus point","GET BONUS POINTS:","Kill a Hacker in order to get","  a bonus point !"));
		buttons[1] = new InterestBonus(X_STORE,Y_STORE+Y_CELL_SPACE,BONUS_BUTTON_DIMENSION,BONUS_BUTTON_DIMENSION,Window.getInstance().getPlayPanel().getTileset_bonus().getImage(5),Window.getInstance().getPlayPanel().getTileset_bonus().getImage(1),new Description("MONEY BONUS","BONUS:","This bonus will increase the","  interest rate by 3%.","PRICE:","Costs: 1 bonus point.","GET BONUS POINTS:","Kill a Hacker in order to get","  a bonus point !"));
		buttons[2] = new ExtraRangeBonus(X_STORE,Y_STORE+Y_CELL_SPACE*2,BONUS_BUTTON_DIMENSION,BONUS_BUTTON_DIMENSION,Window.getInstance().getPlayPanel().getTileset_bonus().getImage(6),Window.getInstance().getPlayPanel().getTileset_bonus().getImage(2),new Description("EXTRA RANGE BONUS","BONUS:","Increase range of all placed","  towers without any money cost.","PRICE:","Costs: 1 bonus point.","GET BONUS POINTS:","Kill a Hacker in order to get","  a bonus point !"));
		buttons[3] = new ExtraDamageBonus(X_STORE,Y_STORE+Y_CELL_SPACE*3,BONUS_BUTTON_DIMENSION,BONUS_BUTTON_DIMENSION,Window.getInstance().getPlayPanel().getTileset_bonus().getImage(7),Window.getInstance().getPlayPanel().getTileset_bonus().getImage(3),new Description("EXTRA DAMAGE BONUS","BONUS:","Increase damage of all placed","  towers without any money cost.","PRICE:","Costs: 1 bonus point.","GET BONUS POINTS:","Kill a Hacker in order to get","  a bonus point !"));
		
	}
	
	// Actualizar estado de los botones (ver si tienen que estar habilitados o no)
	public void checkBonusStates() {
		
		if(Window.getInstance().getPlayPanel().getGame().getGameMode() == Game.HARDCORE_MODE)
			buttons[0].disable();
		
		if(Window.getInstance().getPlayPanel().getGame().getStats().getBonus() >= 1) {
			for(int x = 0 ; x < buttons.length ; x++) {
				if(!(Window.getInstance().getPlayPanel().getGame().getGameMode() == Game.HARDCORE_MODE && x == 0))
					buttons[x].enable();	
			}
		} else {
			for(int x = 0 ; x < buttons.length ; x++) {
				buttons[x].disable();
			}
		}
		
	}
	
	@Override
	public void draw(Graphics g) {
		
		for(int x = 0 ; x < buttons.length ; x++) {
			buttons[x].draw(g);
		}
		
	}

	@Override
	public void click(Point p, int button) {
		for(int x = 0 ; x < buttons.length ; x++) {
			buttons[x].click(p, button);;
		}
	}

	@Override
	public void drag(Point p) {
		for(int x = 0 ; x < buttons.length ; x++) {
			buttons[x].drag(p);
		}
	}
	
	
}