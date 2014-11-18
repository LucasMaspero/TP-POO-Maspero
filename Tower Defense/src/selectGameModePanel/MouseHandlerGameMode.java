package selectGameModePanel;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Window;

public class MouseHandlerGameMode implements MouseMotionListener, MouseListener {

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
		Window.getInstance().getSelectGameModePanel().getGameModeMenu().click(new Point(e.getX(),e.getY()), e.getButton());
	
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {
		
		Window.getInstance().getSelectGameModePanel().getGameModeMenu().drag(new Point(e.getX(),e.getY()));
		
	}
	
}