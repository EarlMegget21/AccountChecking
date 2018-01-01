package view.menu.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.page.ViewBilan;

public class ItemBilan extends MenuItem {

	public ItemBilan() {
		super();
		this.addActionListener(new BilanListener());
	}
	class BilanListener implements ActionListener{

		  public void actionPerformed(ActionEvent e) {
			  ViewBilan page=new ViewBilan();
			  page.setFen(fen);			  
		  	  fen.setPage(page);
		  	  fen.go();
		  }

	}

}
