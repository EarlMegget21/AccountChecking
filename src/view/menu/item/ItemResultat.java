package view.menu.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.page.ViewResultat;

public class ItemResultat extends MenuItem {

	public ItemResultat() {
		super();
		this.addActionListener(new ResultatListener());
	}

	class ResultatListener implements ActionListener{

		  public void actionPerformed(ActionEvent e) {
			  ViewResultat page=new ViewResultat();
			  page.setFen(fen);
		  	  fen.setPage(page);
		  	  fen.go();
		  }

	}
	
}
