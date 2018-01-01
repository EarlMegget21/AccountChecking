package view.page;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.BD;
import model.ModelES;
import model.ModelTransaction;

public class ViewConteneurJournal extends JPanel {

	private static int page=0;
	private ViewJournal conteneur;

	public ViewConteneurJournal(){
		super();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int width=this.getWidth(); //on récupère la largeur de la fenêtre
		int height=this.getHeight(); //on récupère la longueur de la fenêtre
		//on définit la police pour l'entête
		Font font = new Font("Courier", Font.BOLD, 20);
		g.setFont(font);
		//dessin des lignes verticales
		g.drawLine(width/6-30, 0, width/6-30, height);
		g.drawLine(width/3-30, 0, width/3-30, height);
		g.drawLine((width/3)*2+30, 0, (width/3)*2+30, height);
		g.drawLine((width/6)*5+30, 0, (width/6)*5+30, height);
		//dessin de l'entête
		g.drawString("CompteE", 20, 20);
		g.drawString("CompteS", width/6, 20);
		g.drawString("Titres", width/3, 20);
		g.drawString("MontantE", (width/3)*2+50, 20);
		g.drawString("MontantS", (width/6)*5+50, 20);
		//récupération des transactions dans la BD
		ArrayList<ModelTransaction> listTransactions=BD.getTransactions();
		//on définit les variables pour la navigation entre les pages
		int nbAffich=4; //nombre de transac à afficher sur la page
		int lastPage=listTransactions.size()/nbAffich; //calcul de la dernière page
		if(page==lastPage){ //si on est à la dernière page
			nbAffich=listTransactions.size()%nbAffich; //le nombre de transac à afficher est le nombre de transac restantes
		}
		//on définit la police pour le contenu
		font = new Font("Courier", Font.PLAIN, 30);
		g.setFont(font);
		//on parcours les nbAffich transactions
		if(listTransactions.size()!=0){ //si la liste n'est pas vide
			ModelTransaction m; //transaction courante
			//première ligne
			m=listTransactions.get(page*4); //récupération de la transaction
			g.drawLine(0, 30, width/2-100, 30);
			g.drawString(m.getDate().toString(), width/2-90, 40);
			g.drawLine(width/2+100, 30, width, 30);
			int j,k,a=0,z=0;
			for(int i=0;i<nbAffich;i++){
				m=listTransactions.get(page*4+i); //récupération de la transaction
				//dessin de la date
				if(i!=0){//si c'est pas la première
					g.drawLine(0, z+30, width/2-100, z+30);
					g.drawString(m.getDate().toString(), width/2-90, z+40);
					g.drawLine(width/2+100, z+30, width, z+30);
				}
				//dessin des comptes d'entrée et sortie avec leur montant
				ArrayList<ModelES> entrees=m.getEntree();
				for(j=0; j<entrees.size();j++){
					g.drawString("["+entrees.get(j).getCompte().getType().getNumero(), 20, 40+(j*30)+z+30);
					g.drawString(entrees.get(j).getCompte().getNumero()+"]", 60, 40+(j*30)+z+30);
					g.drawString(entrees.get(j).getNom(), width/3, 40+(j*30)+z+30);
					g.drawString(entrees.get(j).getMontant()+" €", (width/3)*2+50, 40+(j*30)+z+30);
				}
				a=j;
				ArrayList<ModelES> sorties=m.getSortie();
				for(k=0; k<sorties.size();k++){
					g.drawString("["+sorties.get(k).getCompte().getType().getNumero(), width/6, 80+(a*30)+(k*30)+z+30);
					g.drawString(sorties.get(k).getCompte().getNumero()+"]", width/6+40, 80+(a*30)+(k*30)+z+30);
					g.drawString(sorties.get(k).getNom(), width/3, 80+(a*30)+(k*30)+z+30);
					g.drawString(sorties.get(k).getMontant()+" €", (width/6)*5+50, 80+(a*30)+(k*30)+z+30);
					z=80+(a*30)+(k*30)+z+30;
				}
			}
		}
	}

	public static int getPage() {
		return page;
	}

	public static void incPage() {
		ViewConteneurJournal.page += 1;
	}

	public static void decPage() {
		ViewConteneurJournal.page -= 1;
	}

	public ViewJournal getConteneur() {
		return conteneur;
	}

	public void setConteneur(ViewJournal conteneur) {
		this.conteneur = conteneur;
	}

}
