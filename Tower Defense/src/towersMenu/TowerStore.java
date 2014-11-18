package towersMenu;

import graphics.Description;
import graphics.Drawable;
import graphics.MouseUse;
import java.awt.*;
import main.Window;
import towers.*;

public class TowerStore implements Drawable, MouseUse {
		
	private static final int X_STORE = 890;
	private static final int Y_STORE = 118;
	private static final int X_CELL_SPACE = 30;
	private static final int Y_CELL_SPACE = 40;
		
	private final int BUTTON_SIZE = 32;
	private final static int SHOP_WIDTH = 3;
	private final static int SHOP_HEIGHT = 4;
	
	private final static String TITLE_ONE = "EFFECTIVENESS:";
	private final static String TITLE_TWO = "PRICE:"; 
	private final static String TITLE_THREE = "SPECIAL FEATURE:"; 
	
	private TowerButton[][] buttons = new TowerButton[SHOP_HEIGHT][SHOP_WIDTH];
	private TowerButton currentClickedButton = null;
	
	public TowerStore() {
		
		buttons[0][0] = new TowerButton(X_STORE,Y_STORE,BUTTON_SIZE,BUTTON_SIZE,Window.getInstance().getPlayPanel().getTileset_tower().getImage(12),Window.getInstance().getPlayPanel().getTileset_tower().getImage(0),new Description(FreeAntiVirus.TITLE,TITLE_ONE,FreeAntiVirus.DESCRIPTION_EFFECTIVENESS_ONE,FreeAntiVirus.DESCRIPTION_EFFECTIVENESS_TWO,TITLE_TWO,"Costs: $ " + FreeAntiVirus.DEFAULT_PRICE + ".",TITLE_THREE,FreeAntiVirus.DESCRIPTION_TARGETS_ONE,FreeAntiVirus.DESCRIPTION_TARGETS_TWO),FreeAntiVirus.DEFAULT_PRICE,Tower.FREE_ANTIVIRUS,FreeAntiVirus.DEFAULT_RANGE);
		buttons[0][1] = new TowerButton(X_STORE+X_CELL_SPACE+BUTTON_SIZE,Y_STORE,BUTTON_SIZE,BUTTON_SIZE,Window.getInstance().getPlayPanel().getTileset_tower().getImage(13),Window.getInstance().getPlayPanel().getTileset_tower().getImage(1),new Description(HomeAntiVirus.TITLE,TITLE_ONE,HomeAntiVirus.DESCRIPTION_EFFECTIVENESS_ONE,HomeAntiVirus.DESCRIPTION_EFFECTIVENESS_TWO,TITLE_TWO,"Costs: $ " + HomeAntiVirus.DEFAULT_PRICE + ".",TITLE_THREE,HomeAntiVirus.DESCRIPTION_TARGETS_ONE,HomeAntiVirus.DESCRIPTION_TARGETS_TWO),HomeAntiVirus.DEFAULT_PRICE,Tower.HOME_ANTIVIRUS,HomeAntiVirus.DEFAULT_RANGE);
		buttons[0][2] = new TowerButton(X_STORE+(X_CELL_SPACE+BUTTON_SIZE)*2,Y_STORE,BUTTON_SIZE,BUTTON_SIZE,Window.getInstance().getPlayPanel().getTileset_tower().getImage(14),Window.getInstance().getPlayPanel().getTileset_tower().getImage(2),new Description(EnterpriseAntiVirus.TITLE,TITLE_ONE,EnterpriseAntiVirus.DESCRIPTION_EFFECTIVENESS_ONE,EnterpriseAntiVirus.DESCRIPTION_EFFECTIVENESS_TWO,TITLE_TWO,"Costs: $ " + EnterpriseAntiVirus.DEFAULT_PRICE + ".",TITLE_THREE,EnterpriseAntiVirus.DESCRIPTION_TARGETS_ONE,EnterpriseAntiVirus.DESCRIPTION_TARGETS_TWO),EnterpriseAntiVirus.DEFAULT_PRICE,Tower.ENTERPRISE_ANTIVIRUS,EnterpriseAntiVirus.DEFAULT_RANGE);
		
		buttons[1][0] = new TowerButton(X_STORE,Y_STORE+Y_CELL_SPACE,BUTTON_SIZE,BUTTON_SIZE,Window.getInstance().getPlayPanel().getTileset_tower().getImage(15),Window.getInstance().getPlayPanel().getTileset_tower().getImage(3),new Description(TrialAntiWorm.TITLE,TITLE_ONE,TrialAntiWorm.DESCRIPTION_EFFECTIVENESS_ONE,TrialAntiWorm.DESCRIPTION_EFFECTIVENESS_TWO,TITLE_TWO,"Costs: $ " + TrialAntiWorm.DEFAULT_PRICE + ".",TrialAntiWorm.DESCRIPTION_TARGETS_ONE,TITLE_THREE,TrialAntiWorm.DESCRIPTION_TARGETS_TWO),TrialAntiWorm.DEFAULT_PRICE,Tower.TRIAL_ANTIWORM,TrialAntiWorm.DEFAULT_RANGE);
		buttons[1][1] = new TowerButton(X_STORE+X_CELL_SPACE+BUTTON_SIZE,Y_STORE+Y_CELL_SPACE,BUTTON_SIZE,BUTTON_SIZE,Window.getInstance().getPlayPanel().getTileset_tower().getImage(16),Window.getInstance().getPlayPanel().getTileset_tower().getImage(4),new Description(StandardAntiWorm.TITLE,TITLE_ONE,StandardAntiWorm.DESCRIPTION_EFFECTIVENESS_ONE,StandardAntiWorm.DESCRIPTION_EFFECTIVENESS_TWO,TITLE_TWO,"Costs: $ " + StandardAntiWorm.DEFAULT_PRICE + ".",TITLE_THREE,StandardAntiWorm.DESCRIPTION_TARGETS_ONE,StandardAntiWorm.DESCRIPTION_TARGETS_TWO),StandardAntiWorm.DEFAULT_PRICE,Tower.STANDARD_ANTIWORM,StandardAntiWorm.DEFAULT_RANGE);
		buttons[1][2] = new TowerButton(X_STORE+(X_CELL_SPACE+BUTTON_SIZE)*2,Y_STORE+Y_CELL_SPACE,BUTTON_SIZE,BUTTON_SIZE,Window.getInstance().getPlayPanel().getTileset_tower().getImage(17),Window.getInstance().getPlayPanel().getTileset_tower().getImage(5),new Description(ProAntiWorm.TITLE,TITLE_ONE,ProAntiWorm.DESCRIPTION_EFFECTIVENESS_ONE,ProAntiWorm.DESCRIPTION_EFFECTIVENESS_TWO,TITLE_TWO,"Costs: $ " + ProAntiWorm.DEFAULT_PRICE + ".",TITLE_THREE,ProAntiWorm.DESCRIPTION_TARGETS_ONE,ProAntiWorm.DESCRIPTION_TARGETS_TWO),ProAntiWorm.DEFAULT_PRICE,Tower.PRO_ANTIWORM,ProAntiWorm.DEFAULT_RANGE);
		
		buttons[2][0] = new TowerButton(X_STORE,Y_STORE+Y_CELL_SPACE*2,BUTTON_SIZE,BUTTON_SIZE,Window.getInstance().getPlayPanel().getTileset_tower().getImage(18),Window.getInstance().getPlayPanel().getTileset_tower().getImage(6),new Description(SystemFirewall.TITLE,TITLE_ONE,SystemFirewall.DESCRIPTION_EFFECTIVENESS_ONE,SystemFirewall.DESCRIPTION_EFFECTIVENESS_TWO,TITLE_TWO,"Costs: $ " + SystemFirewall.DEFAULT_PRICE + ".",TITLE_THREE,SystemFirewall.DESCRIPTION_TARGETS_ONE,SystemFirewall.DESCRIPTION_TARGETS_TWO),SystemFirewall.DEFAULT_PRICE,Tower.SYSTEM_FIREWALL,SystemFirewall.DEFAULT_RANGE);
		buttons[2][1] = new TowerButton(X_STORE+X_CELL_SPACE+BUTTON_SIZE,Y_STORE+Y_CELL_SPACE*2,BUTTON_SIZE,BUTTON_SIZE,Window.getInstance().getPlayPanel().getTileset_tower().getImage(19),Window.getInstance().getPlayPanel().getTileset_tower().getImage(7),new Description(NoNoFirewall.TITLE,TITLE_ONE,NoNoFirewall.DESCRIPTION_EFFECTIVENESS_ONE,NoNoFirewall.DESCRIPTION_EFFECTIVENESS_TWO,TITLE_TWO,"Costs: $ " + NoNoFirewall.DEFAULT_PRICE + ".",TITLE_THREE,NoNoFirewall.DESCRIPTION_TARGETS_ONE,NoNoFirewall.DESCRIPTION_TARGETS_TWO),NoNoFirewall.DEFAULT_PRICE,Tower.NONO_FIREWALL,NoNoFirewall.DEFAULT_RANGE);
		buttons[2][2] = new TowerButton(X_STORE+(X_CELL_SPACE+BUTTON_SIZE)*2,Y_STORE+Y_CELL_SPACE*2,BUTTON_SIZE,BUTTON_SIZE,Window.getInstance().getPlayPanel().getTileset_tower().getImage(20),Window.getInstance().getPlayPanel().getTileset_tower().getImage(8),new Description(AccessDeniedFirewall.TITLE,TITLE_ONE,AccessDeniedFirewall.DESCRIPTION_EFFECTIVENESS_ONE,AccessDeniedFirewall.DESCRIPTION_EFFECTIVENESS_TWO,TITLE_TWO,"Costs: $ " + AccessDeniedFirewall.DEFAULT_PRICE + ".",TITLE_THREE,AccessDeniedFirewall.DESCRIPTION_TARGETS_ONE,AccessDeniedFirewall.DESCRIPTION_TARGETS_TWO),AccessDeniedFirewall.DEFAULT_PRICE,Tower.ACCESSDENIED_FIREWALL,AccessDeniedFirewall.DEFAULT_RANGE);
		
		buttons[3][0] = new TowerButton(X_STORE,Y_STORE+Y_CELL_SPACE*3,BUTTON_SIZE,BUTTON_SIZE,Window.getInstance().getPlayPanel().getTileset_tower().getImage(21),Window.getInstance().getPlayPanel().getTileset_tower().getImage(9),new Description(SpySweeper.TITLE,TITLE_ONE,SpySweeper.DESCRIPTION_EFFECTIVENESS_ONE,SpySweeper.DESCRIPTION_EFFECTIVENESS_TWO,TITLE_TWO,"Costs: $ " + SpySweeper.DEFAULT_PRICE + ".",TITLE_THREE,SpySweeper.DESCRIPTION_TARGETS_ONE,SpySweeper.DESCRIPTION_TARGETS_TWO),SpySweeper.DEFAULT_PRICE,Tower.SPY_SWEEPER,SpySweeper.DEFAULT_RANGE);
		buttons[3][1] = new TowerButton(X_STORE+X_CELL_SPACE+BUTTON_SIZE,Y_STORE+Y_CELL_SPACE*3,BUTTON_SIZE,BUTTON_SIZE,Window.getInstance().getPlayPanel().getTileset_tower().getImage(22),Window.getInstance().getPlayPanel().getTileset_tower().getImage(10),new Description(SpyTerminator.TITLE,TITLE_ONE,SpyTerminator.DESCRIPTION_EFFECTIVENESS_ONE,SpyTerminator.DESCRIPTION_EFFECTIVENESS_TWO,TITLE_TWO,"Costs: $ " + SpyTerminator.DEFAULT_PRICE + ".",TITLE_THREE,SpyTerminator.DESCRIPTION_TARGETS_ONE,SpyTerminator.DESCRIPTION_TARGETS_TWO),SpyTerminator.DEFAULT_PRICE,Tower.SPY_TERMINATOR,SpyTerminator.DEFAULT_RANGE);
		buttons[3][2] = new TowerButton(X_STORE+(X_CELL_SPACE+BUTTON_SIZE)*2,Y_STORE+Y_CELL_SPACE*3,BUTTON_SIZE,BUTTON_SIZE,Window.getInstance().getPlayPanel().getTileset_tower().getImage(23),Window.getInstance().getPlayPanel().getTileset_tower().getImage(11),new Description(SpyBot.TITLE,TITLE_ONE,SpyBot.DESCRIPTION_EFFECTIVENESS_ONE,SpyBot.DESCRIPTION_EFFECTIVENESS_TWO,TITLE_TWO,"Costs: $ " + SpyBot.DEFAULT_PRICE + ".",TITLE_THREE,SpyBot.DESCRIPTION_TARGETS_ONE,SpyBot.DESCRIPTION_TARGETS_TWO),SpyBot.DEFAULT_PRICE,Tower.SPY_BOT,SpyBot.DEFAULT_RANGE);
		
	}
	
	// Ver si se puede comprar la torre con el dinero actual.
	public boolean canAfford(TowerButton b) {
		
		int currentMoney = Window.getInstance().getPlayPanel().getGame().getStats().getMoney();
		
		if(currentMoney-b.getCost() >= 0) {
			return true;
		}
		return false;
	
	}
	
	// Actualizar estado de los botones
	public void checkTowerStates() {
		for(int x = 0 ; x < buttons.length ; x++) {
			for(int y = 0 ; y < buttons[0].length ; y++) {
				if(canAfford(buttons[x][y])) {
					buttons[x][y].enable();
				} else {
					buttons[x][y].disable();
				}
			}
		}
	}
	
	@Override
	public void draw(Graphics g) {
		
		for(int x = 0 ; x < buttons.length ; x++) {
			for(int y = 0 ; y < buttons[0].length ; y++) {
				buttons[x][y].draw(g);
			}
		}
		
		if(currentClickedButton != null) {
			
			Window.getInstance().getPlayPanel().getImproveTowerMenu().clear();
			
			// Arrastrar torre
			g.drawImage(currentClickedButton.getIcon(), Window.getInstance().getPlayPanel().getPointer().x-(BUTTON_SIZE/2), Window.getInstance().getPlayPanel().getPointer().y-(BUTTON_SIZE/2), BUTTON_SIZE, BUTTON_SIZE, null);
		
			// Rango.
			g.setColor(Color.LIGHT_GRAY);
			g.drawRect(Window.getInstance().getPlayPanel().getPointer().x-(BUTTON_SIZE/2)-currentClickedButton.getRango(), Window.getInstance().getPlayPanel().getPointer().y-(BUTTON_SIZE/2)-currentClickedButton.getRango(), Tower.TOWER_DIMENSION+2*currentClickedButton.getRango(),Tower.TOWER_DIMENSION+2*currentClickedButton.getRango());
			
		}
		
	}

	@Override
	public void click(Point p, int button) {
		
		if(button == MouseUse.RIGHT_CLICK) {
			currentClickedButton = null;
			return;
		}
		
		for(int x = 0 ; x < buttons.length ; x++) {
			for(int y = 0 ; y < buttons[0].length ; y++) {
				buttons[x][y].click(p, button);
			}
		}
		
	}

	@Override
	public void drag(Point p) {
		
		for(int x = 0 ; x < buttons.length ; x++) {
			for(int y = 0 ; y < buttons[0].length ; y++) {
				buttons[x][y].drag(p);
			}
		}
		
	}
	
	public TowerButton getCurrentClickedButton() {
		return currentClickedButton;
	}

	public void setCurrentClickedButton(TowerButton currentClickedButton) {
		this.currentClickedButton = currentClickedButton;
	}

}
