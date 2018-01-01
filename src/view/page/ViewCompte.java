package view.page;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.BD;
import model.ModelCompte;

public class ViewCompte extends JPanel { //comptes qui seront dessinés dans le grand livre
	
	private int numero; //numero du compte
	
	public ViewCompte(int n){
		super();
		numero=n;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int width=this.getWidth(); //on récupère la largeur de la fenêtre
		int height=this.getHeight(); //on récupère la longueur de la fenêtre
		//on définit la police pour l'entête et les totaux
		Font font1 = new Font("Courier", Font.BOLD, 20);
		//on définit la police pour le contenu
		Font font2 = new Font("Courier", Font.PLAIN, 20);
		g.setFont(font1);
		
		g.drawLine(width/2, height/4, width/2, height-5); //ligne verticale du T
		g.drawLine(width/4, height/4, width/4*3, height/4); //ligne horizontale du T
		
		//récupération du modèle du compte
		int[] t={numero};
		ModelCompte[] compte=BD.getComptesNum(t);
		//ecriture du titre
		String nom=compte[0].getTitre();
		g.drawString(nom, width/2-((nom.length()/2)*13), height/4-20);
		//on définit la police pour les montants
		g.setFont(font2);
		ModelCompte[] c=compte[0].getCompte();
		String totE, totS;
		for(int i=0; i<c.length; i++){
			totE=c[i].getTotalEntreesBalance()+"";
			totS=c[i].getTotalSortiesBalance()+"";
			g.drawString(totE, width/2-(totE.length()*17)-10, 25+height/4+(i*20));
			g.drawString(totS, width/2+10, 25+height/4+(i*20));
		}
		g.setFont(font1);
		//ecriture des totaux
		String totalDeb, totalCred;
		totalDeb=compte[0].getTotalEntreesBalance()+"";
		totalCred=compte[0].getTotalSortiesBalance()+"";
		g.drawString(totalDeb, width/2-(totalDeb.length()*17)-10, height-5);
		g.drawString(totalCred, width/2+10, height-5);
	}
	
}
