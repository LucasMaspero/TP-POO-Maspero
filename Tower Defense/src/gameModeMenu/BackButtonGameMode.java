package gameModeMenu;

import java.awt.Image;
import selectMapPanel.*;
import main.Window;
import button.BorderButton;

public class BackButtonGameMode extends BorderButton {

	private static final long serialVersionUID = 1L;

	public BackButtonGameMode(int x, int y, int width, int height, Image icon) {
		super(x, y, width, height, icon);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void clickAction() {
		Window.getInstance().switchPanel(SelectMapPanel.PANEL_ID);
		Window.getInstance().getSelectGameModePanel().removeAll();
	}



}