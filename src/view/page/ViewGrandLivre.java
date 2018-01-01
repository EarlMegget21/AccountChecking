package view.page;

import java.awt.Graphics;
import java.awt.GridLayout;

public class ViewGrandLivre extends View {
	
	private ViewCompte[] comptes; //tableau des comptes

	public ViewGrandLivre() {
		super();
		//création des comptes
		comptes=new ViewCompte[7];
		for(int i=0;i<7;i++){
			comptes[i]=new ViewCompte(i);
		}
		//mise en forme de l'agencement de la page
		this.setLayout(new GridLayout(0,3));
		this.add(comptes[0]);
		this.add(comptes[1]);
		this.add(comptes[2]);
		this.add(comptes[3]);
		this.add(comptes[4]);
		this.add(comptes[5]);
		this.add(comptes[6]);
		
	}
	
	public void paintComponent(Graphics g){
		
	}

}
