package view;

import javax.swing.JFrame;

import model.BD;
import view.menu.conteneur.Menu;
import view.menu.conteneur.MenuConteneur;
import view.menu.item.ItemBalance;
import view.menu.item.ItemBilan;
import view.menu.item.ItemGrandLivre;
import view.menu.item.ItemJournal;
import view.menu.item.ItemResultat;
import view.menu.item.ItemSave;
import view.menu.item.ItemTransactions;
import view.menu.item.MenuItem;
import view.page.View;
import view.page.ViewTransactions;

public class Fenetre extends JFrame {
	
  private Menu menuBar; //barre de menu personnalisée
  
  private View page; //vue affichée (contenu de la fenetre)

  public Fenetre(){ //construit la fenetre et affiche à l'ecran
	super();
    this.setSize(1500, 1000); //définit la taille initiale de la fenetre
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //indique qu'on ferme la fenetre en appuyant sur la croix
    this.setLocationRelativeTo(null); //construit la fenetre au centre de l'ecran
    
    initMenu(); //lance la fonction qui initialise le menuBar (barre de navigation)
    this.setJMenuBar(menuBar); //ajoute cette barre de navigation à la fenetre
    
    page=new ViewTransactions(); //construit la page initiale du demarrage de la fenetre (page pour ajouter des transactions)
    page.setFen(this); //associe cette fenetre à la vue Transactions(peut-être inutile, à voir plus tard)

    this.go(); //lance la fonction qui affiche la fenetre
  }
  
  private void initMenu(){ //initialise la barre de navigation
	  
	  //Créer un tableau de tableaux de boutons de navigation (Item) par defaut(texte="Voir") chacun pour sa propre page, le tout héritant de MenuItem
	  MenuItem[][] listVoir={{new ItemTransactions()},{new ItemJournal()},{new ItemGrandLivre()},{new ItemBalance()},{new ItemResultat()},{new ItemBilan()},{new ItemSave()}};
	  for(MenuItem[] m:listVoir){
		  m[0].setFen(this); //associe cette fenetre à chaque bouton de navigation(peut-être inutile, à voir plus tard)
	  }
	  
	  //créer les conteneurs de boutons qui formeront la barre de menu avec en entrée un tableau de bouton(ici un bouton donc une case) et le nom apparaissant dans la barre
	  MenuConteneur transMenu=new MenuConteneur(listVoir[0], "Transactions");
	  MenuConteneur jourMenu=new MenuConteneur(listVoir[1], "Journal");
	  MenuConteneur glMenu=new MenuConteneur(listVoir[2], "GrandLivre");
	  MenuConteneur balMenu=new MenuConteneur(listVoir[3], "Balance");
	  MenuConteneur resMenu=new MenuConteneur(listVoir[4], "Resultat");
	  MenuConteneur bilMenu=new MenuConteneur(listVoir[5], "Bilan");
	  MenuConteneur saveMenu=new MenuConteneur(listVoir[6], "Sauvegarder/Charger");
	  MenuConteneur[] m={transMenu,jourMenu,glMenu,balMenu,resMenu,bilMenu,saveMenu}; //créer un tableau de tous ces conteneurs
	  
	  menuBar=new Menu(m); //associe ce tableau à la barre de navigation
	  menuBar.setFenetre(this); //associe cette fenetre à la barre de navigation(peut-être inutile, à voir plus tard)
  }

  public View getPage() {
	  return page;
  }

  public void setPage(View page) {
	  this.page = page;
  }

  public void go(){ //affiche la page à l'écran
	  this.setContentPane(page);  //defini la vue (View) comme le contenu de la fenetre
	  this.setVisible(true); //affiche à l'écran
  }

  public void go2(){
	  page.repaint(); //permet de repeindre la vue affichée(mettre à jour le contenu)
  }

  public static void main(String[] args){ //main pour tester
	  BD bd=new BD(); //créer l'objet servant de BD pour l'instant
	  Fenetre fen = new Fenetre(); //créer la fenetre
  }

}
