package main;
import infoPanel.InfoPanel;

import java.awt.*;

import javax.swing.*;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

import playPanel.PlayPanel;
import principalPanel.PrincipalPanel;
import selectGameModePanel.*;
import selectMapPanel.SelectMapPanel;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;

	// Singleton
	private static Window instance;
	
	// Paneles.
	private JPanel currentPanel;
	private PlayPanel playPanel;
	private PrincipalPanel principalPanel;
	private SelectMapPanel selectMapPanel;
	private SelectGameModePanel selectGameModePanel;
	private InfoPanel infoPanel;

	// Dimensiones de la ventana.
	public final static int WIDTH = 1194;
	public final static int HEIGHT = 902;
	
	// Título de la ventana.
	private final static String gameTitle = "Computer Tower Defense";
	
	// Música de fondo
	private Music music;
	
	public Window() {
		
		// Configuraciones de la ventana.
		setTitle(gameTitle);
		setSize(new Dimension(WIDTH,HEIGHT));
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Música de fondo.
		try {
			music = new Music("res/Music/music.aif" );
			music.loop();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		// Paneles
		playPanel = new PlayPanel();
		principalPanel = new PrincipalPanel();
		selectMapPanel = new SelectMapPanel();
		selectGameModePanel = new SelectGameModePanel();
		infoPanel = new InfoPanel();
		
		setLayout(new GridLayout(1,1,0,0));
		setVisible(true);
		
	}
	
	public static Window getInstance() {
		if(instance == null) {
			instance = new Window();
		}
		return instance;
	}
	
	public PlayPanel getPlayPanel() {
		return playPanel;
	}

	public PrincipalPanel getPrincipalPanel() {
		return principalPanel;
	}

	public SelectMapPanel getSelectMapPanel() {
		return selectMapPanel;
	}

	public SelectGameModePanel getSelectGameModePanel() {
		return selectGameModePanel;
	}

	public InfoPanel getInfoPanel() {
		return infoPanel;
	}

	public Music getMusic() {
		return music;
	}
	
	public void addPanel(JPanel panel) {
		add(panel);
		currentPanel = panel;
	}
	
	public void switchPanel(int panelNumber) {
		
		remove(currentPanel);
		
		if(panelNumber == PlayPanel.PANEL_ID) {
			addPanel(playPanel);
		} else if(panelNumber == PrincipalPanel.PANEL_ID) {
			addPanel(principalPanel);
		} else if(panelNumber == SelectMapPanel.PANEL_ID) {
			addPanel(selectMapPanel);
		} else if(panelNumber == SelectGameModePanel.PANEL_ID) {
			addPanel(selectGameModePanel);
		} else {
			addPanel(infoPanel);
		}
		
        validate();
        repaint();
		
	}
	
}
