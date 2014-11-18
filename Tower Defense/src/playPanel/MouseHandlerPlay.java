package playPanel;

import java.awt.Point;
import java.awt.event.*;
import main.Window;

public class MouseHandlerPlay implements MouseMotionListener, MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {

	}
	
	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		Point p = new Point(e.getX(), e.getY());
		
		Window.getInstance().getPlayPanel().getMenu().click(p,e.getButton());
		
		if(!Window.getInstance().getPlayPanel().getGame().isGameWin() && !Window.getInstance().getPlayPanel().getGame().isGameOver()) { 

			if(!Window.getInstance().getPlayPanel().getGame().isPaused()) {
					
				Window.getInstance().getPlayPanel().getTowerStore().click(p,e.getButton());
				Window.getInstance().getPlayPanel().getBonusStore().click(p,e.getButton());
				Window.getInstance().getPlayPanel().getGame().getMap().click(p,e.getButton());
				Window.getInstance().getPlayPanel().getImproveTowerMenu().click(p,e.getButton());
				
			}
		
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		Point p = new Point(e.getX(), e.getY());
		
		Window.getInstance().getPlayPanel().setPointer(p);
		
		Window.getInstance().getPlayPanel().getTowerStore().drag(p);
		Window.getInstance().getPlayPanel().getBonusStore().drag(p);
		Window.getInstance().getPlayPanel().getMenu().drag(p);
		Window.getInstance().getPlayPanel().getImproveTowerMenu().drag(p);
		
	}
	
}