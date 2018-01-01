package view.menu.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.page.ViewTransactions;

public class ItemTransactions extends MenuItem {

	public ItemTransactions() {
		super();
		this.addActionListener(new TransacListener());
	}
	
	class TransacListener implements ActionListener{

		  public void actionPerformed(ActionEvent e) {
			  ViewTransactions page=new ViewTransactions();
			  page.setFen(fen);
		  	  fen.setPage(page);
		  	  fen.go();
		  }

	}

}
