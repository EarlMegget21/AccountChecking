package view.page;

import java.awt.Font;
import java.awt.Graphics;

import model.BD;
import model.ModelCompte;
import model.ModelResultat;

public class ViewResultat extends View {

	public ViewResultat() {
		super();
	}
	
	public void paintComponent(Graphics g){
		int width=this.getWidth(); //on récupère la largeur de la fenêtre
		int height=this.getHeight(); //on récupère la longueur de la fenêtre
		
		//on définit la police pour l'entête et les totaux
		Font font1 = new Font("Courier", Font.BOLD, 20);
		//on définit la police pour le contenu
		Font font2 = new Font("Courier", Font.PLAIN, 20);
		g.setFont(font1);
		//on ecrit les titres
		g.drawString("CHARGES", (width/4)-50, 50);
		g.drawString("PRODUITS", (width/4*3)-50, 50);
		//lignes horizontales
		g.drawLine(20, 100, width-20, 100);
		//lignes verticales
		g.drawLine(width/2, 20, width/2, height-20);
		//on définit la police pour le contenu
		g.setFont(font2);
		//on récupère le résultat et ses comptes de la BD
		ModelResultat resultat=BD.getResultat();
		ModelCompte[] comptes=resultat.getListComptes();
		//on parcours les comptes pour récupérer leur total et les afficher avec le titre du compte
		ModelCompte[] charges=comptes[0].getCompte();
		for(int i=0; i<charges.length; i++){
			g.drawString(charges[i].getTitre(), width/16, 150+(i*50)); //on écrit le titre du compte
			g.drawString(charges[i].getSolde()+"", width/8*3, 150+(i*50)); //on écrit le solde de ce compte
		}
		ModelCompte[] produits=comptes[1].getCompte();
		for(int i=0; i<produits.length; i++){
			g.drawString(produits[i].getTitre(), width/16*9, 150+(i*50)); //on écrit le titre du compte
			g.drawString(-produits[i].getSolde()+"", width/8*7, 150+(i*50)); //"-" car les produits sortent
		}
		//on définit la police pour les totaux
		g.setFont(font1);
		//écriture du total charges et total produits
		g.drawString("TOTAL", width/8, height-100);
		g.drawString(resultat.getTotalCharge()+"", width/8*3, height-100);
		g.drawString("TOTAL", 5*width/8, height-100);
		g.drawString(resultat.getTotalProduit()+"", 7*width/8, height-100);
		//calcule et affichage du résultat
		if(resultat.getMontantResultat()>=0){ //si bénéfices ou nul
			g.drawString("Bénéfice", width/8, height-50);
			g.drawString(resultat.getMontantResultat()+"", width/8*3, height-50);
		}
		if(resultat.getMontantResultat()<=0){ //si pertes ou nul
			g.drawString("Perte", 5*width/8, height-50);
			g.drawString(-resultat.getMontantResultat()+"", 7*width/8, height-50);
		}
	}

}
