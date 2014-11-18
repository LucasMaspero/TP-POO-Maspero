package graphics;

import java.awt.*;

public class Description implements Drawable {
	
	// Coordenadas
	private static final int X = 886;
	private static final int Y_TITLE_DESCRIPTION = 348;
	private static final int Y_SLOT_ONE = 416;
	private static final int Y_SLOT_TWO = 486;
	private static final int Y_SLOT_THREE = 556;
	
	// Elementos
	private String title = "";
	
	private String slotOneTitle = "";
	private String slotOneFirstText = "";
	private String slotOneSecondText = "";
	
	private String slotTwoTitle = "";
	private String slotTwoFirstText = "";
	private String slotTwoSecondText = "";
	
	private String slotThreeTitle = "";
	private String slotThreeFirstText = "";
	private String slotThreeSecondText = "";
	
	// Descripcion que luego se imprime en la "consola" del juego (debajo del menu de torres).
	public Description() {
		
	}
	
	public Description(Description d) {
		title = d.getTitle();
		slotOneTitle = d.getSlotOneTitle();
		slotOneFirstText = d.getSlotOneFirstText();
		slotOneSecondText = d.getSlotOneSecondText();
		slotTwoTitle = d.getSlotTwoTitle();
		slotTwoFirstText = d.getSlotTwoFirstText();
		slotThreeTitle = d.getSlotThreeTitle();
		slotThreeFirstText = d.getSlotThreeFirstText();
		slotThreeSecondText = d.getSlotThreeSecondText();
	}
	
	public Description(String title, String slotOneFirstText, String slotOneSecondText, String slotTwoText, String slotThreeFirstText, String slotThreeSecondText) {
		this.title = title;
		this.slotOneFirstText = slotOneFirstText;
		this.slotOneSecondText = slotOneSecondText;
		this.slotTwoFirstText = slotTwoText;
		this.slotThreeFirstText = slotThreeFirstText;
		this.slotThreeSecondText = slotThreeSecondText;
	}
	
	public Description(String title, String slotOneTitle,String slotOneFirstText, String slotOneSecondText, String slotTwoTitle, String slotTwoText, String slotThreeTitle, String slotThreeFirstText, String slotThreeSecondText) {
		this.title = title;
		this.slotOneTitle = slotOneTitle;
		this.slotOneFirstText = slotOneFirstText;
		this.slotOneSecondText = slotOneSecondText;
		this.slotTwoTitle = slotTwoTitle;
		this.slotTwoFirstText = slotTwoText;
		this.slotThreeTitle = slotThreeTitle;
		this.slotThreeFirstText = slotThreeFirstText;
		this.slotThreeSecondText = slotThreeSecondText;
	}
	
	public Description(String slotOneTitle, String slotTwoTitle, String slotThreeTitle) {
		this.slotOneTitle = slotOneTitle;
		this.slotTwoTitle = slotTwoTitle;
		this.slotThreeTitle = slotThreeTitle;
	}
	
	@Override
	public void draw(Graphics g) {
		
		// Title.

		g.setFont(new Font("Consolas",0,14));
		g.setColor(Color.cyan);	
		g.drawString(title,X,Y_TITLE_DESCRIPTION);
					
		// Descriptions
					
		g.setColor(new Color(133,255,28));
		g.drawString(slotOneTitle, X, Y_SLOT_ONE-20);
		g.drawString("* " + slotOneFirstText, X, Y_SLOT_ONE);
		g.drawString(slotOneSecondText, X, Y_SLOT_ONE+20);			
		
		g.setColor(new Color(243,121,37));
		g.drawString(slotTwoTitle, X, Y_SLOT_TWO-20);
		g.drawString("* " + slotTwoFirstText, X, Y_SLOT_TWO);
		g.drawString(slotTwoSecondText, X, Y_SLOT_TWO+20);
					
		g.setColor(new Color(195,195,195));
		g.drawString(slotThreeTitle, X, Y_SLOT_THREE-20);
		g.drawString("* " + slotThreeFirstText, X, Y_SLOT_THREE);
		g.drawString(slotThreeSecondText, X, Y_SLOT_THREE+20);
		
	}

	public void clean() {
		title = "";
		slotOneTitle = "";
		slotOneFirstText = "";
		slotOneSecondText = "";
		slotTwoTitle = "";
		slotTwoFirstText = "";
		slotTwoSecondText = "";
		slotThreeTitle = "";
		slotThreeFirstText = "";
		slotThreeSecondText = "";
	}
	
	public void multiSet(String title, String slotOneFirstText, String slotOneSecondText, String slotTwoText, String slotThreeFirstText, String slotThreeSecondText) {
		this.title = title;
		this.slotOneFirstText = slotOneFirstText;
		this.slotOneSecondText = slotOneSecondText;
		this.slotTwoFirstText = slotTwoText;
		this.slotThreeFirstText = slotThreeFirstText;
		this.slotThreeSecondText = slotThreeSecondText;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public String getSlotOneTitle() {
		return slotOneTitle;
	}

	public String getSlotOneFirstText() {
		return slotOneFirstText;
	}

	public String getSlotOneSecondText() {
		return slotOneSecondText;
	}

	public String getSlotTwoTitle() {
		return slotTwoTitle;
	}

	public String getSlotTwoFirstText() {
		return slotTwoFirstText;
	}

	public String getSlotThreeTitle() {
		return slotThreeTitle;
	}

	public String getSlotThreeFirstText() {
		return slotThreeFirstText;
	}

	public String getSlotThreeSecondText() {
		return slotThreeSecondText;
	}

	public void setSlotOneTitle(String slotOneTitle) {
		this.slotOneTitle = slotOneTitle;
	}

	public void setSlotOneFirstText(String slotOneFirstText) {
		this.slotOneFirstText = slotOneFirstText;
	}
	
	public void setSlotOneSecondText(String slotOneSecondText) {
		this.slotOneSecondText = slotOneSecondText;
	}

	public void setSlotTwoTitle(String slotTwoTitle) {
		this.slotTwoTitle = slotTwoTitle;
	}

	public void setSlotTwoFirstText(String slotTwoFirstText) {
		this.slotTwoFirstText = slotTwoFirstText;
	}

	public String getSlotTwoSecondText() {
		return slotTwoSecondText;
	}

	public void setSlotTwoSecondText(String slotTwoSecondText) {
		this.slotTwoSecondText = slotTwoSecondText;
	}

	public void setSlotThreeTitle(String slotThreeTitle) {
		this.slotThreeTitle = slotThreeTitle;
	}

	public void setSlotThreeFirstText(String slotThreeFirstText) {
		this.slotThreeFirstText = slotThreeFirstText;
	}

	public void setSlotThreeSecondText(String slotThreeSecondText) {
		this.slotThreeSecondText = slotThreeSecondText;
	}

}