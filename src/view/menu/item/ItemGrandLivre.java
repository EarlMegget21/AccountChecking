package view.menu.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.page.ViewGrandLivre;

public class ItemGrandLivre extends MenuItem {

	public ItemGrandLivre() {
		super();
		this.addActionListener(new GrandLivreListener());
	}
	class GrandLivreListener implements ActionListener{

		  public void actionPerformed(ActionEvent e) {
			  ViewGrandLivre page=new ViewGrandLivre();
			  page.setFen(fen);			  
		  	  fen.setPage(page);
		  	  fen.go();
		  }

	}
}
