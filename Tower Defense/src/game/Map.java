package game;

import graphics.Drawable;
import graphics.MouseUse;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;
import main.Window;

public class Map implements Serializable, Drawable, MouseUse {

	private static final long serialVersionUID = 1L;
	
	// Ubicación del mapa en pantalla.
	private static final int X_MARGIN = 5;
	private static final int Y_MARGIN = 224;
	
	// Todos los mapas tienen estas dimensiones (no se pueden cambiar).
	public static final int MAP_WIDTH = 26;
	public static final int MAP_HEIGHT = 20;
	
	// Array de contenedores.
	private Square[][] mapRepresentation;
	
	public Map() {
		mapRepresentation = new Square[MAP_HEIGHT][MAP_WIDTH];
	}

	public void loadMap(File loadPath) {
		
		try {
			
			Scanner loadScanner = new Scanner(loadPath);
			
			while(loadScanner.hasNext()) {
				
				for(int x = 0 ; x < MAP_HEIGHT ; x++) {
					for(int y = 0 ; y < MAP_WIDTH ; y++) {
						int cellID = loadScanner.nextInt();
						if(cellID == Square.WALL) {
							// Si es "una pared", creamos un contenedor de torres.
							mapRepresentation[x][y] = new Container(X_MARGIN + y * Square.BLOCK_SIZE, Y_MARGIN + x * Square.BLOCK_SIZE);
						} else {
							// Caso contrarario, es camino.
							mapRepresentation[x][y] = new Path(X_MARGIN + y * Square.BLOCK_SIZE, Y_MARGIN + x * Square.BLOCK_SIZE,cellID);
						}
					}
				}
				
				// Cargamos las ID de imagenes para cada celda del mapa.
				for(int x = 0 ; x < MAP_HEIGHT ; x++) {
					for(int y = 0 ; y < MAP_WIDTH ; y++) {
						mapRepresentation[x][y].setImageID(loadScanner.nextInt());
					}
				}
				
			}
			
			loadScanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public Square[][] getMapRepresentation() {
		return mapRepresentation;
	}
	
	// Dibuja mapa en pantalla.
	@Override
	public void draw(Graphics g) {
		
		for(int y = 0 ; y < MAP_HEIGHT ; y++) {
			for(int x = 0 ; x < MAP_WIDTH ; x++) {
				mapRepresentation[y][x].draw(g);
			}
		}
		
		if(Window.getInstance().getPlayPanel().getGame().getStats().getLevel() != Game.STARTING_LEVEL && !Window.getInstance().getPlayPanel().getGame().getWave().hasFinished() && !Window.getInstance().getPlayPanel().getGame().isPaused()) {
	 		for(int y = 0 ; y < MAP_HEIGHT ; y++) {
				for(int x = 0 ; x < MAP_WIDTH ; x++) {
					Square celda = mapRepresentation[y][x];
					if(celda instanceof Container && ((Container)celda).hasTower()) {
						((Container)mapRepresentation[y][x]).getTower().draw(g);
					}
				}
			}
		}
		
	}	

	@Override
	public void click(Point p, int button) {
		
		if(button == MouseUse.LEFT_CLICK) {
			
			// Si clickeamos al mapa con una torre del menú seleccionada (estamos colocando una torre)
			if(Window.getInstance().getPlayPanel().getTowerStore().getCurrentClickedButton() != null) {
				
		 		for(int y = 0 ; y < MAP_HEIGHT ; y++) {
					for(int x = 0 ; x < MAP_WIDTH ; x++) {
						
						Square celda = mapRepresentation[y][x];
						
						if(celda.contains(p) && celda instanceof Container && !((Container)celda).hasTower() ) {
							
							int currentMoney = Window.getInstance().getPlayPanel().getGame().getStats().getMoney();
							int towerID = Window.getInstance().getPlayPanel().getTowerStore().getCurrentClickedButton().getTowerID();
							int cost = Window.getInstance().getPlayPanel().getTowerStore().getCurrentClickedButton().getCost();
					
							((Container)celda).setTower(towerID,x,y); // Colocamos torre.
							Window.getInstance().getPlayPanel().getTowerStore().setCurrentClickedButton(null);
							
							// Restamos el coste de la torre al dinero actual
							Window.getInstance().getPlayPanel().getGame().getStats().setMoney(currentMoney-cost);
							
						}
					}
				}
				
			}
			
			// Si clickeamos a una torre ya posicionada en el mapa.
			for(int y = 0 ; y < MAP_HEIGHT ; y++) {
				for(int x = 0 ; x < MAP_WIDTH ; x++) {
					
					Square celda = mapRepresentation[y][x];
					
					if(celda.contains(p) && celda instanceof Container && ((Container)celda).hasTower() ) {
						
						
						// Mostramos menu de torre colocada en pantalla (mejorar daño, mejor rango y vender)
						Window.getInstance().getPlayPanel().getImproveTowerMenu().setSelectedTower(((Container)celda).getTower());
						return;
						
					}
				}
			}
			
		}
		
	}

	@Override
	public void drag(Point p) {
		
	}
	
}
