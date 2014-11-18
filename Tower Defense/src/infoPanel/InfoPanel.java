package infoPanel;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import button.BorderButton;

public class InfoPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	// ID
	public final static int PANEL_ID = 4;
			
	// Dimensiones
	private int back_height = 91;
	private int back_width = 211;
	
	// Flag para fijarse si es la primera vez que estamos cargando.
	private boolean isFirstTimeLoading = true;
	
	// Dimensiones del panel.
	private int panelWidth;
	private int panelHeight;
			
	// Imágenes que utiliza el panel.
	private Image background;
			
	// Botones
	private BorderButton backButton;
	
	// Mouse
	MouseHandlerInfo mouseHandler;
	
	public InfoPanel() {
		
		mouseHandler = new MouseHandlerInfo();
	
	}
	
	// Cargando recursos.
	private void loadResources() {
			
		backButton = new BackButtonInfo(480,770,back_width,back_height,new ImageIcon("res/Back/buttonBack.png").getImage());
					
		background = new ImageIcon("res/Info/info.png").getImage();
		
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);
				
	}
	
	public void paintComponent(Graphics g) {
		
		if(isFirstTimeLoading) {
			panelWidth = getWidth();
			panelHeight = getHeight();
			loadResources();
			isFirstTimeLoading = false;
		}
		
		// Background.
		g.drawImage(background, 0, 0, panelWidth, panelHeight, null);
		backButton.draw(g);
		
		repaint();
		
	}
	
	public BorderButton getButton() {
		return backButton;
	}

}
