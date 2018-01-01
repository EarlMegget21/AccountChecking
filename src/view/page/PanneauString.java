package view.page;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanneauString extends JPanel { //Panneau contenant un String, utilisé pour afficher la page actuelle dans le journal
	
	private String text;
	
	public PanneauString(){
		super();
		text="";
	}
	
	public PanneauString(String s){
		super();
		text=s;
	}
	
	public void paintComponent(Graphics g){
		Font font = new Font("Courier", Font.PLAIN, 20);
		g.setFont(font);
		g.drawString(text, getWidth()/3, getHeight()/3*2);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

}
