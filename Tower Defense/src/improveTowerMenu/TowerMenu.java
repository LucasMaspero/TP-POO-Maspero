package improveTowerMenu;

import graphics.Description;
import graphics.Drawable;
import graphics.MouseUse;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import button.EnablingButton;
import main.Window;
import towers.Tower;

public class TowerMenu implements Drawable, MouseUse {
	
	// Dimensiones y Coordenadas.
	private static final int TOWER_BUTTONS_SIZE = 3;
	public static final int BUTTON_HEIGHT = 24;
	public static final int BUTTON_WIDTH = 110;
	private static final int X_BUTTONS = 1028;
	private static final int Y_BUTTONS = 420;
	private static final int Y_CELL_SPACE = 70;

	private Tower selectedTower = null;

	private Description description = new Description("IMPROVE DAMAGE:","IMPROVE RANGE:","OTHER OPERATIONS:");
	
	private EnablingButton[] buttons = new EnablingButton[TOWER_BUTTONS_SIZE];
	
	public TowerMenu() {
		
		buttons[0] = new PlusDamageButton(X_BUTTONS,Y_BUTTONS,BUTTON_WIDTH,BUTTON_HEIGHT,Window.getInstance().getPlayPanel().getTileset_tower_menu().getImage(0),Window.getInstance().getPlayPanel().getTileset_tower_menu().getImage(2));
		buttons[1] = new PlusRangeButton(X_BUTTONS,Y_BUTTONS+Y_CELL_SPACE,BUTTON_WIDTH,BUTTON_HEIGHT,Window.getInstance().getPlayPanel().getTileset_tower_menu().getImage(0),Window.getInstance().getPlayPanel().getTileset_tower_menu().getImage(2));
		buttons[2] = new SellTowerButton(X_BUTTONS,Y_BUTTONS+2*Y_CELL_SPACE-2,BUTTON_WIDTH,BUTTON_HEIGHT,Window.getInstance().getPlayPanel().getTileset_tower_menu().getImage(1));
		
	}
	
	// Actualiza estado de los botones.
	public void checkButtonsStates() {
		
		if(selectedTower != null) {
			
			if( (selectedTower.getUsedRangeIncrements() >= Tower.MAX_RANGE_INCREMENTS) || ((Window.getInstance().getPlayPanel().getGame().getStats().getMoney() - getIncrementRangeCost()) < 0) ) {
				buttons[1].disable();
			} else {
				buttons[1].enable();
			}
			if( (selectedTower.getUsedDamageIncrements() >= Tower.MAX_DAMAGE_INCREMENTS) || ((Window.getInstance().getPlayPanel().getGame().getStats().getMoney() - getIncrementDamageCost()) < 0) ) {
				buttons[0].disable();
			} else {
				buttons[0].enable();
			}
			
		}
		
	}
	
	@Override
	public void draw(Graphics g) {
		
		if(selectedTower != null) {
			
			for(int i = 0 ; i < buttons.length ; i++) {
				buttons[i].draw(g);
			}
			
			g.setColor(Color.lightGray);
			g.drawRect(selectedTower.getGraphicTower().x-selectedTower.getRange(), selectedTower.getGraphicTower().y-selectedTower.getRange(), selectedTower.getSquareRange().width, selectedTower.getSquareRange().height);
		
			description.setTitle(selectedTower.getTitle());
			description.setSlotOneFirstText("Current: " + selectedTower.getDamage() + " , After: " + selectedTower.getIncrementedDamage());
			description.setSlotOneSecondText("* Costs: $" + getIncrementDamageCost());
			description.setSlotTwoFirstText("Current: " + selectedTower.getRange() + " , After: " + selectedTower.getIncrementedRange());
			description.setSlotTwoSecondText("* Costs: $" + getIncrementRangeCost());
			description.setSlotThreeFirstText("Sells for %50 of its value");
			description.setSlotThreeSecondText("* Sell: $" + selectedTower.getPrice()/2);
			
			description.draw(g);
			
		}	
		
	}
	
	public int getIncrementDamageCost() {
		return (int)(30.0*(double)selectedTower.getPrice()/100.0);
	}
	
	public int getIncrementRangeCost() {
		return (int)(20.0*(double)selectedTower.getPrice()/100.0);
	}

	public void clear() {
		this.selectedTower = null;
	}

	public Tower getSelectedTower() {
		return selectedTower;
	}

	public void setSelectedTower(Tower selectedTower) {
		this.selectedTower = selectedTower;
	}

	@Override
	public void click(Point p, int button) {
		
		if(button == MouseUse.RIGHT_CLICK) {
			clear();
			return;
		}

		if(selectedTower != null) {
			for( int i = 0 ; i < buttons.length ; i++ ) {
				buttons[i].click(p, button);
			}
		}
		
	}

	@Override
	public void drag(Point p) {

		if(selectedTower != null) {
			for( int i = 0 ; i < buttons.length ; i++ ) {
				buttons[i].drag(p);
			}
		}
		
	}	
	
}
