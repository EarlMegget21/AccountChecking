package view.page;

import java.awt.Font;
import java.awt.Graphics;

import model.BD;
import model.ModelBilan;
import model.ModelCompte;
import model.ModelListCompte;

public class ViewBilan extends View {

	public ViewBilan() {
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
		g.drawString("ACTIF", (width/4)-50, height/30);
		g.drawString("PASSIF", (width/4*3)-50, height/30);
		//lignes horizontales
		g.drawLine(20, 2*height/30, width-20, 2*height/30);
		//lignes verticales
		g.drawLine(width/2, 20, width/2, height-20);
		//on ecrit les gros titres
		g.drawString("Actif Immobilisé", width/32, 3*height/30);
		g.drawString("Actif Circulant", width/32, 13*height/32);
		g.drawString("Fonds Propres", 17*width/32, 3*height/30);
		g.drawString("Dettes", 17*width/32, 13*height/30);
		//on définit la police pour le contenu
		g.setFont(font2);
		//on récupère le bilan et ses comptes de la BD
		ModelBilan bilan=BD.getBilan();
		ModelCompte[] compteActif=bilan.getActif().getListComptes();
		ModelCompte[] comptePassif=bilan.getPassif().getListComptes();
		//on affiche les comptes d'actif et leur montant
		afficheActif(g, compteActif,comptePassif, width, height);
		//on affiche les comptes de passif et leur montant
		affichePassif(g, comptePassif,compteActif, width, height);
		//on définit la police pour les totaux
		g.setFont(font1);
		//écriture du total charges et total produits
		g.drawString("TOTAL", width/16, 29*height/30);
		g.drawString(bilan.totalActifBilan()+"", width/8*3, 29*height/30);
		g.drawString("TOTAL", 9*width/16, 29*height/30);
		g.drawString(bilan.totalPassifBilan()+"", 7*width/8, 29*height/30);
	}
	
	public void affichePassif(Graphics g, ModelCompte[] comptePassif, ModelCompte[] compteActif, int width, int height){
			int i;
			for(i=0;i<comptePassif[0].getCompte().length;i++){
				g.drawString(comptePassif[0].getCompte()[i].getTitre(), 9*width/16, (4+i)*height/30); //on écrit le titre du compte
				g.drawString(-comptePassif[0].getCompte()[i].getSolde()+"", 7*width/8, (4+i)*height/30); //on écrit le solde du compte
			}
			g.drawString(comptePassif[1].getCompte()[0].getTitre(), 9*width/16, (i+5)*height/30); //on écrit le titre du compte
			g.drawString(-comptePassif[1].getCompte()[0].getSolde()+"", 7*width/8, (i+5)*height/30); //on écrit le solde du compte
			for(int j=2;j<comptePassif[1].getCompte().length;j++){
				g.drawString(comptePassif[1].getCompte()[j].getTitre(), 9*width/16, (i+j+4)*height/30); //on écrit le titre du compte
				g.drawString(-comptePassif[1].getCompte()[j].getSolde()+"", 7*width/8, (i+j+4)*height/30); //on écrit le solde du compte
			}
			ModelCompte banque=compteActif[2].getCompte()[1];
			if(banque.getSolde()<0){
				g.drawString(banque.getTitre(), 9*width/16, 23*height/30); //on écrit le titre du compte
				g.drawString(-banque.getSolde()+"", width/16*14, 23*height/30); //on écrit le solde du compte
			}
	}
	
	public void afficheActif(Graphics g, ModelCompte[] compteActif,ModelCompte[] comptePassif, int width, int height){
		int i;
		for(i=0;i<compteActif[0].getCompte().length;i++){
			g.drawString(compteActif[0].getCompte()[i].getTitre(), width/16, (4+i)*height/32); //on écrit le titre du compte
			g.drawString(compteActif[0].getCompte()[i].getSolde()+"", width/8*3, (4+i)*height/32); //on écrit le solde du compte
		}
		int j;
		for(j=0;j<compteActif[1].getCompte().length;j++){
			g.drawString(compteActif[1].getCompte()[j].getTitre(), width/16, (i+j+5)*height/32); //on écrit le titre du compte
			g.drawString(compteActif[1].getCompte()[j].getSolde()+"", width/8*3, (i+j+5)*height/32); //on écrit le solde du compte
		}
		g.drawString(compteActif[2].getCompte()[0].getTitre(), width/16, (i+j+5)*height/32); //on écrit le titre du compte
		g.drawString(compteActif[2].getCompte()[0].getSolde()+"", width/8*3, (i+j+5)*height/32); //on écrit le solde du compte
		for(int k=2;k<compteActif[2].getCompte().length;k++){
			g.drawString(compteActif[2].getCompte()[k].getTitre(), width/16, (i+j+k+4)*height/32); //on écrit le titre du compte
			g.drawString(compteActif[2].getCompte()[k].getSolde()+"", width/8*3, (i+j+k+4)*height/32); //on écrit le solde du compte
		}
		ModelCompte banque=compteActif[2].getCompte()[1];
		if(banque.getSolde()>=0){
			g.drawString(banque.getTitre(), width/16, 29*height/32); //on écrit le titre du compte
			g.drawString(banque.getSolde()+"", width/8*3, 29*height/32); //on écrit le solde du compte
		}
		ModelCompte client=comptePassif[1].getCompte()[1];
		g.drawString(client.getTitre(), width/16, 30*height/32); //on écrit le titre du compte
		g.drawString(client.getSolde()+"", width/8*3, 30*height/32); //on écrit le solde du compte
	}

}
