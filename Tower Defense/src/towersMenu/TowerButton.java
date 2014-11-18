package towersMenu;

import graphics.Description;
import java.awt.Image;
import button.DescriptiveButton;
import main.Window;

public class TowerButton extends DescriptiveButton {
	
	private static final long serialVersionUID = 1L;
	
	private Description description;
	private int cost;
	private int towerID;
	private int rango;

	public TowerButton(int x, int y, int width, int height,
			Image imageEnabled, Image imageDisabled,Description description, int cost, int towerID, int rango) {
		
		super(x, y, width, height, imageEnabled, imageDisabled, description);
		this.description = description;
		this.cost = cost;
		this.towerID = towerID;
		this.rango = rango;
	
	}
	
	@Override
	public void clickAction() {
		
		Window.getInstance().getPlayPanel().getTowerStore().setCurrentClickedButton(this);
		
	}

	public Description getDescription() {
		return description;
	}

	public int getCost() {
		return cost;
	}

	public int getTowerID() {
		return towerID;
	}

	public int getRango() {
		return rango;
	}
	
}
