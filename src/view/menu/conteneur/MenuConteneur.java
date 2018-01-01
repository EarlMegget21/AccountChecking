package view.menu.conteneur;
import javax.swing.JMenu;

import view.menu.item.MenuItem;

public class MenuConteneur extends JMenu {
	
	MenuItem[] voir;
	Menu menu;

	public MenuConteneur(String nom) {
		super(nom);
		voir=new MenuItem[1];
	}

	public MenuConteneur(int i, String nom) {
		super(nom);
		voir=new MenuItem[i];
	}
	
	public MenuConteneur(MenuItem[] v,String nom) {
		super(nom);
		voir=v;
		for(MenuItem m:voir){
			m.setConteneur(this);
			this.add(m);
		}
	}
	
	public MenuItem[] getVoir() {
		return voir;
	}

	public void setVoir(MenuItem[] voir) {
		this.voir = voir;
	}

	public Menu getMenu() {
		return menu;
	}
	
	public void setMenu(Menu c){
		//coder le test pour que le menu soit le bon
		menu=c;
	}

}
