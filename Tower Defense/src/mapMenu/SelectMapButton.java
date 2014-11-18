package mapMenu;

import java.awt.Image;
import selectGameModePanel.*;
import main.Window;
import button.BorderButton;

public class SelectMapButton extends BorderButton {
	
	private static final long serialVersionUID = 1L;
	
	private int map_number;

	public SelectMapButton(int x, int y, int width, int height, Image icon, int map_number) {
		super(x, y, width, height, icon);
		this.map_number = map_number;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void clickAction() {
		Window.getInstance().getSelectMapPanel().selectMap(map_number);
		Window.getInstance().switchPanel(SelectGameModePanel.PANEL_ID);
	}



}
