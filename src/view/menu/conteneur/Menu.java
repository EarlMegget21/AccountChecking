package view.menu.conteneur;
import javax.swing.JMenuBar;

import view.Fenetre;

public class Menu extends JMenuBar {
	
	MenuConteneur[] menuConteneur;
	Fenetre fenetre;

	public Menu() {
		super();
		menuConteneur=new MenuConteneur[1];
	}
	
	public Menu(int i) {
		super();
		menuConteneur=new MenuConteneur[i];
	}
	
	public Menu(MenuConteneur[] m){
		menuConteneur=m;
		for(MenuConteneur mc: m){
			mc.setMenu(this);
			this.add(mc);
		}
	}
	
	public void setFenetre(Fenetre m){
		//coder le test pour que la fenetre soit la bonne
		fenetre=m;
	}

	public MenuConteneur[] getMenuConteneur() {
		return menuConteneur;
	}

	public void setMenuConteneur(MenuConteneur[] menuConteneur) {
		this.menuConteneur = menuConteneur;
	}

	public Fenetre getFenetre() {
		return fenetre;
	}

}
