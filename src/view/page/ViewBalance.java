package view.page;

import java.awt.Font;
import java.awt.Graphics;

import model.BD;
import model.ModelBalance;
import model.ModelCompte;

public class ViewBalance extends View {

	public ViewBalance() {
		super();
	}
	
	public void paintComponent(Graphics g){
		int width=this.getWidth(); //on r�cup�re la largeur de la fen�tre
		int height=this.getHeight(); //on r�cup�re la longueur de la fen�tre
		//on d�finit la police pour l'ent�te
		Font font = new Font("Courier", Font.BOLD, 20);
		g.setFont(font);
		//�criture des comptes
		g.drawString("Compte", 20, 40);
		g.drawString("Libelle", width/8*2, 40);
		g.drawString("Total", width/16*9, 20);
		g.drawString("Debit", width/2, 70);
		g.drawString("Credit", width/8*5, 70);
		g.drawString("Solde", width/16*13, 20);
		g.drawString("Debit", width/4*3, 70);
		g.drawString("Credit", width/8*7, 70);
		//dessin des lignes horizontales
		g.drawLine(0, height/8-30, width, height/8-30);
		g.drawLine(width/2-20, 40, width, 40);
		g.drawLine(0, height-100, width, height-100);
		//dessin des lignes verticales
		g.drawLine(width/16*3, 0, width/16*3, height-100);
		g.drawLine(width/2-20, 0, width/2-20, height-100);
		g.drawLine(width/8*5-20, 40, width/8*5-20, height-100);
		g.drawLine(width/4*3-20, 0, width/4*3-20, height);
		g.drawLine(width/8*7-20, 40, width/8*7-20, height);
		//on d�finit la police pour le contenu
		font = new Font("Courier", Font.PLAIN, 20);
		g.setFont(font);
		//on r�cup�re la balance et ses comptes de la BD
		ModelBalance balance=BD.getBalance();
		ModelCompte[] comptes=balance.getListComptes();
		//on parcours les comptes pour r�cup�rer leur total et les afficher avec le titre du compte
		for(int i=0;i<comptes.length;i++){
			//ecriture du num�ro du compte avec son titre
			g.drawString("["+comptes[i].getNumero()+"]", 20, height/8*(i+1));
			g.drawString(comptes[i].getTitre(), width/8*2-50, height/8*(i+1));
			//calcul du total entree/sortie
			int totalEntrees=comptes[i].getTotalEntreesBalance();
			int totalSorties=comptes[i].getTotalSortiesBalance();
			//affichage du total sorties/entr�es
			g.drawString(totalEntrees+"", width/2, height/8*(i+1));
			g.drawString(totalSorties+"", width/8*5, height/8*(i+1));
			//affichage du solde d�biteur/cr�diteur
			int solde=comptes[i].getSoldeBalance();
			int soldeDebiteur,soldeCrediteur;
			if(solde>0){  //si c'est positif c'est d�biteur sinon cr�diteur
				soldeDebiteur=solde;
				soldeCrediteur=0;
			}else{
				soldeDebiteur=0;
				soldeCrediteur=-solde;
			}
			g.drawString(soldeDebiteur+"", width/4*3, height/8*(i+1));
			g.drawString(soldeCrediteur+"", width/8*7, height/8*(i+1));
			if(i<6){ //si c'est le dernier, on dessine une ligne en dessous
				g.drawLine(0, height/8*(i+1)+height/16, width, height/8*(i+1)+height/16);
			}
		}
		//on d�finit la police pour le total
		font = new Font("Courier", Font.BOLD, 20);
		g.setFont(font);
		//affichage du total
		g.drawString("Total", width/4, height-40);
		//on d�clare les variables de total de solde
		int totalDebiteur=balance.getTotalDebitCredit()[0];
		g.drawString(totalDebiteur+"", width/4*3, height-40);
		int totalCrediteur=-balance.getTotalDebitCredit()[1];
		g.drawString(totalCrediteur+"", width/8*7, height-40);
	}

}
