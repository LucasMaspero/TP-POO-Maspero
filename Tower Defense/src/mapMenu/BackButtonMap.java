package mapMenu;

import java.awt.Image;

import principalPanel.PrincipalPanel;
import main.Window;
import button.BorderButton;

public class BackButtonMap extends BorderButton {

	private static final long serialVersionUID = 1L;

	public BackButtonMap(int x, int y, int width, int height, Image icon) {
		super(x, y, width, height, icon);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void clickAction() {
		Window.getInstance().switchPanel(PrincipalPanel.PANEL_ID);
		Window.getInstance().getSelectMapPanel().removeAll();
	}



}
