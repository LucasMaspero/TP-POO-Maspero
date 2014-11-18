package threats;

import graphics.AnimationDrawer;
import graphics.Drawable;
import game.*;
import game.Game;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import main.Window;

public class Threat implements Drawable, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Velocidades de Movimiento.
	public static final int FAST_SPEED = 95;
	public static final int MEDIUM_SPEED = 75;
	public static final int SLOW_SPEED = 60;
	
	// Niveles de vida
	public static final int BOSS_HEALTH = 5000;
	public static final int STRONG_HEALTH = 3200;
	public static final int NORMAL_HEALTH = 1000;
	public static final int WEAK_HEALTH = 700;
	
	// Niveles de slow.
	public static final int HIGH_SLOW = 40;
	public static final int MEDIUM_SLOW = 28;
	public static final int LOW_SLOW = 17;
	
	// Envenanamiento
	private static final int POISON_TICKS = 100;
	private static final int POISON_DAMAGE = 5;
	
	// IDs.
	public static final int TROJAN = 0;
	public static final int SPAM = 1;
	public static final int SPY = 2;
	public static final int WORM = 3;
	public static final int KEYLOGGER = 4;
	public static final int REGULAR_THREAT = 5;
	public static final int HACKER = 6;
	
	// Constantes.
	private static final int HEALTHBAR_SPACE = 0;
	private static final int HEALTHBAR_HEIGHT = 2;
	public static final int THREAT_DIMENSION = 28;
	private static final int CRITICAL_HEALTH_PIXELS = 8;
	private static final int DOWN = 0;
	private static final int UP = 1;
	private static final int RIGHT = 2;
	private static final int LEFT = 3;
	private static final int WALK_RATE = 100;
	
	// Características de la amenaza.
	private int health;
	private int speed;
	private boolean isBonus;
	
	// Gráficos
	private static final int ANI_RATE = 20;
	private transient AnimationDrawer animationDrawer = new AnimationDrawer(ANI_RATE);
	private Rectangle hitBox;
	
	// Variables para comportamiento de las amenazas.
	private int steps = 0; // Cantidad de pasos que realizo la amenaza
	private int xMap, yMap; // Coordenadas en el mapa.
	private boolean inGame;
	private int direction;
	private int walkFrame;
	private int threatID;
	private int maxHealth;
	public int threatWalk = THREAT_DIMENSION;
	private int slowCountDown = 0;
	private int poisonCountDown = 0;
	private boolean isPoisoned = false;
	
	public Threat(int threatID, boolean isBonus, int maxHealth, int speed) {
		
		this.threatID = threatID;
		this.isBonus = isBonus;
		this.maxHealth = maxHealth + getPlusHealth();
		this.health = maxHealth;
		this.speed = speed;
		
		hitBox = new Rectangle();
		walkFrame = speed;		
		direction = DOWN;
		inGame = false;
		setAnimation(); // Seteamos la animación de la amenaza
		
	}

	public void spawnThreatLeft() {
		for(int x = 0 ; x < Map.MAP_WIDTH ; x++) {
			if(Window.getInstance().getPlayPanel().getGame().getMap().getMapRepresentation()[0][x] instanceof Path){
				Path path = (Path)Window.getInstance().getPlayPanel().getGame().getMap().getMapRepresentation()[0][x];
				if(  path.getPathID() == Path.LEFT_ROAD ) {
					hitBox.setBounds(path.x+4 ,path.y , THREAT_DIMENSION ,  THREAT_DIMENSION);
					yMap = 0;
					xMap = x;
					break;	
				}
			}
		}
		
		inGame = true;
	}
	
	public void spawnThreatRight() {
		for(int x = 0 ; x < Map.MAP_WIDTH ; x++) {
			Square cell = Window.getInstance().getPlayPanel().getGame().getMap().getMapRepresentation()[0][x];
			if(cell instanceof Path &&  ((Path)cell).getPathID() == Path.RIGHT_ROAD ) {
				
				hitBox.setBounds(cell.x+4 , cell.y , THREAT_DIMENSION ,  THREAT_DIMENSION);
				yMap = 0;
				xMap = x;
				break;
			}
		}
		
		inGame = true;
	}
	
	// Lógica de movimiento de la amenaza
	public void move() {
		
		if(walkFrame >= WALK_RATE) {
			
			steps++;
			
			// Si la amenaza esta envenenada, por cada paso que da, recibe el daño del envenenamiento.
			if(isPoisoned) {
				poisonDamage();
			}
			
			moveGraphic(); // Movemos a la amenaza en pantalla
			
			threatWalk += 1;
			
			// Si llegamos al final de la celda en la que estabamos, nos fijamos a que celda debemos ir.
			if(threatWalk == Square.BLOCK_SIZE) {
				
				Path possibleNextPaths[] = new Path[4];
				int directions[][] = { {0,1},{0,-1},{1,0},{-1,0}};
				Path actualPath = (Path)Window.getInstance().getPlayPanel().getGame().getMap().getMapRepresentation()[yMap][xMap];
				boolean isLeftPath;
				
				// Si la celda en la que estaba, era el final
				if(actualPath.getPathID() == Path.LEFT_FINISH || actualPath.getPathID() == Path.RIGHT_FINISH) {
					deleteThreat(); // Eliminamos la amenaza 
					Window.getInstance().getPlayPanel().getGame().looseLife(); // Y perdemos una vida
					return;
				}
				
				// Nos fijamos si estabamos en un camino izquierdo o derecho
				if(actualPath.getPathID() == Path.LEFT_ROAD) {
					isLeftPath = true;
				} else {
					isLeftPath = false;
				}
				
				// Analizamos las celdas posibles a desplazarnos
				for(int i = 0 ; i < 4 ; i++) {
					if( ( ( (xMap+directions[i][0]) >= 0) && ((xMap+directions[i][0]) < Map.MAP_WIDTH) ) && (((yMap+directions[i][1]) >= 0) && ((yMap+directions[i][1]) < Map.MAP_HEIGHT)) ) {
						Square cell = Window.getInstance().getPlayPanel().getGame().getMap().getMapRepresentation()[yMap + directions[i][1]][xMap + directions[i][0]];
						if( cell instanceof Path ) {
							if(isLeftPath) {
								if( ((Path)cell).getPathID() == Path.LEFT_ROAD || ((Path)cell).getPathID() == Path.LEFT_FINISH) {
									possibleNextPaths[i] = (Path)cell;
								}
							} else {
								if( ((Path)cell).getPathID() == Path.RIGHT_ROAD || ((Path)cell).getPathID() == Path.RIGHT_FINISH) {
									possibleNextPaths[i] = (Path)cell;
								}
							}
						}
					}
				}
				
				// Nos desplazamos
				for(int i = 0 ; i < 4 ; i++) {
					if(possibleNextPaths[i] != null) {
						if( !(i == DOWN && direction == UP) && !(i == UP && direction == DOWN) && !(i == RIGHT && direction == LEFT) && !(i == LEFT && direction == RIGHT)) {
							direction = i;
							xMap = xMap + directions[i][0];
							yMap = yMap + directions[i][1];
							break;
						}
					}
				}
				
				threatWalk = 0;

			}
		
			walkFrame = speed;
			
		} else {
		
			if(isSlowed()) {
				slowCountDown--;
				// Si estamos realentizados, perdemos tiempo.
			}
			else {
				walkFrame += 1; // Si no, avanzamos.
			}
			
		}
	}
	
	// Envenear a la amenaza
	public void poison() {
	
		if(poisonCountDown == 0) {
			poisonCountDown = POISON_TICKS;
			isPoisoned = true;
		}

	}
	
	public boolean isSlowed() {
		if(slowCountDown > 0) {
			return true;
		}
		return false;
	}
	
	// Daño de envenenamiento
	public void poisonDamage() {
		
		if((poisonCountDown - 1) == 0) {
			isPoisoned = false;
		}
		poisonCountDown--;
		this.setHealth(this.getHealth()-POISON_DAMAGE);
		
	}
	
	@Override
	public void draw(Graphics g) {

		// Transformar vida de la amenaza a cantidad de pixeles de la barra de salud.
		java.lang.Double healthBarWidth = (double) ((health * 100 / maxHealth) * 24 / 100);
		if(healthBarWidth.intValue() == 0) {
			healthBarWidth = 1.0;
		}
			
		// Dibujar animación de la amenaza
		animationDrawer.setPosition(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
		animationDrawer.draw(g);
		
		// Setear en rojo el color la barra de vida si la amenaza está a punto de morir.
		if(healthBarWidth < CRITICAL_HEALTH_PIXELS) {
			g.setColor(Color.red);
		} else{
			g.setColor(Color.green);
		}
		
		// Dibujar la barra de vida
		g.fillRect(hitBox.x , hitBox.y - (HEALTHBAR_SPACE + HEALTHBAR_HEIGHT), healthBarWidth.intValue() , HEALTHBAR_HEIGHT);
	
		// Poison
		if(isPoisoned) {
			java.lang.Double poisonBarWidth = (double) ((poisonCountDown * 100 / POISON_TICKS) * 24 / 100);
			if(poisonBarWidth.intValue() == 0) {
				poisonBarWidth = 1.0;
			}
			g.setColor(Color.magenta);
			g.fillRect(hitBox.x , hitBox.y - 2 - (HEALTHBAR_HEIGHT), poisonBarWidth.intValue() , HEALTHBAR_HEIGHT);
			
		}
		
	}
	
	public void slow(int slowNumber) {
		if(slowCountDown < slowNumber) {
			slowCountDown = slowNumber;
		}
	}
	
	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}
	
	public void deleteThreat() {
		inGame = false;
	}
	
	public static int getPlusHealth(int level) {
		return (int)(46*Game.LEVELS*Math.log10(level+1));
	}
	
	public int getPlusHealth() {
		return getPlusHealth(Window.getInstance().getPlayPanel().getGame().getStats().getLevel());
	}

	public int getHealth() {
		return health;
	}

	public void killThreat() {
		this.setHealth(0);
	}
	
	public void setHealth(int health) {
		this.health = health;
		if(health <= 0) {
			Window.getInstance().getPlayPanel().getGame().getReward(this);
			inGame = false;
		}
	}

	public int getThreatID() {
		return threatID;
	}

	public int getSpeed() {
		return speed;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public boolean isBonus() {
		return isBonus;
	}
	
	public int getSteps() {
		return steps;
	}
	
	public AnimationDrawer getAnimationDrawer() {
		return animationDrawer;
	}
	
	public void moveGraphic() {
		
		if(direction == DOWN) {
			hitBox.y+=1;
		} else if(direction == RIGHT) {
			hitBox.x+=1;
		} else if(direction == LEFT) {
			hitBox.x-=1;
		} else {
			hitBox.y-=1; // Up.
		}
		
	}
	
	public void setAnimation() {
		
		animationDrawer.setAnimation(Window.getInstance().getPlayPanel().getTileset_threat()[threatID]);
		
	}

	public Rectangle getHitBox() {
		return hitBox;
	}

	public void setHitBox(Rectangle hitBox) {
		this.hitBox = hitBox;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((animationDrawer == null) ? 0 : animationDrawer.hashCode());
		result = prime * result + direction;
		result = prime * result + health;
		result = prime * result + (inGame ? 1231 : 1237);
		result = prime * result + maxHealth;
		result = prime * result + speed;
		result = prime * result + threatID;
		result = prime * result + threatWalk;
		result = prime * result + walkFrame;
		result = prime * result + xMap;
		result = prime * result + yMap;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Threat other = (Threat) obj;
		if (animationDrawer == null) {
			if (other.animationDrawer != null)
				return false;
		} else if (!animationDrawer.equals(other.animationDrawer))
			return false;
		if (direction != other.direction)
			return false;
		if (health != other.health)
			return false;
		if (inGame != other.inGame)
			return false;
		if (maxHealth != other.maxHealth)
			return false;
		if (speed != other.speed)
			return false;
		if (threatID != other.threatID)
			return false;
		if (threatWalk != other.threatWalk)
			return false;
		if (walkFrame != other.walkFrame)
			return false;
		if (xMap != other.xMap)
			return false;
		if (yMap != other.yMap)
			return false;
		return true;
	}
	
}
