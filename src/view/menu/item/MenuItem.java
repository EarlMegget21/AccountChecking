package view.menu.item;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import view.Fenetre;
import view.menu.conteneur.MenuConteneur;

public class MenuItem extends JMenuItem {
	
	private MenuConteneur conteneur;
	protected Fenetre fen;

	public MenuItem() {
		super("Voir");
		conteneur=new MenuConteneur("");
		this.addActionListener(new MenuListener());
	}
	
	public MenuItem(String nom) {
		super(nom);
		conteneur=new MenuConteneur("");
		this.addActionListener(new MenuListener());
	}
	
	public void setConteneur(MenuConteneur c) {
		conteneur=c;
	}
	
	public MenuConteneur getConteneur() {
		return conteneur;
	}

	public Fenetre getFen() {
		return fen;
	}

	public void setFen(Fenetre fen) {
		this.fen = fen;
	}

	class MenuListener implements ActionListener{

		  public void actionPerformed(ActionEvent e) {
//			    //lance la fonction changePage(Enum) de la View de la Fenetre
//			  Fenetre fen=((MenuItem)e.getSource()).getConteneur().getMenu().getFenetre();
//			  page.setFen(fen);
//			  ViewJournal page2=(ViewJournal)page;
//		  	  fen.setPage(page2);
//		  	  fen.go();
		  }

	}
	
}
