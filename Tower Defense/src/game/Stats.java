package game;

import graphics.Drawable;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;

public class Stats implements Serializable, Drawable {
	
	private static final long serialVersionUID = 1L;
	
	// Coordenadas de stats en pantalla.
	
	private final static int X_LIFES = 686;
	private final static int Y_LIFES = 52;
	
	private final static int X_LEVEL = 686;
	private final static int Y_LEVEL = 118;
	
	private final static int X_BONUS = 686;
	private final static int Y_BONUS = 180;
	
	private final static int X_MONEY = 533;
	private final static int Y_MONEY = 52;
	
	private final static int X_INTEREST = 533;
	private final static int Y_INTEREST = 118;
	
	private final static int X_SCORE = 533;
	private final static int Y_SCORE = 180;
	
	private Integer lifes, money, interest, bonus, level, score;
	
	public Stats(Integer lifes, Integer money, Integer interest, Integer bonus,
			Integer level, Integer score) {
		this.lifes = lifes;
		this.money = money;
		this.interest = interest;
		this.bonus = bonus;
		this.level = level;
		this.score = score;
	}

	@Override
	public void draw(Graphics g) {
		g.setFont(new Font("Consolas",0,16));

		// Vidas.
		g.setColor(new Color(46,193,191));
		g.drawString("LIFES:  " + lifes.toString(), X_LIFES, Y_LIFES);
		// Nivel.
		g.setColor(new Color(165,135,53));
		g.drawString("LEVEL: " + level.toString()+" / 50", X_LEVEL, Y_LEVEL);
		// Bonus.
		g.setColor(new Color(142,77,165));
		g.drawString("BONUS: " + bonus.toString(), X_BONUS, Y_BONUS);
		// Dinero.
		g.setColor(new Color(0,165,41));
		g.drawString("MONEY:$" + money.toString(), X_MONEY, Y_MONEY);
		// Interés.
		g.setColor(new Color(165,44,38));
		g.drawString("INTEREST: " + interest.toString()+ "%", X_INTEREST, Y_INTEREST);
		// Puntaje.
		g.setColor(Color.GRAY);
		g.drawString("SCORE:" + score.toString(), X_SCORE, Y_SCORE);
	}

	public Integer getLifes() {
		return lifes;
	}

	public void setLifes(Integer lifes) {
		this.lifes = lifes;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Integer getInterest() {
		return interest;
	}

	public void setInterest(Integer interest) {
		this.interest = interest;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public Integer getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
