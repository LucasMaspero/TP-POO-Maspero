package gameModeMenu;

import java.awt.Image;

import main.Window;
import playPanel.PlayPanel;
import button.BorderButton;

public class SelectGameModeButton extends BorderButton {
	
	private static final long serialVersionUID = 1L;
	
	private int game_mode_number;

	public SelectGameModeButton(int x, int y, int width, int height, Image icon, int game_mode_number) {
		super(x, y, width, height, icon);
		this.game_mode_number = game_mode_number;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void clickAction() {
		Window.getInstance().getSelectGameModePanel().selectGameMode(game_mode_number);
		Window.getInstance().getPlayPanel().newGame();
		Window.getInstance().switchPanel(PlayPanel.PANEL_ID);
	}


}
