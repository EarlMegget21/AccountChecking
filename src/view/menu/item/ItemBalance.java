package view.menu.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.page.ViewBalance;

public class ItemBalance extends MenuItem {

	public ItemBalance() {
		super();
		this.addActionListener(new BalanceListener());
	}
	class BalanceListener implements ActionListener{

		  public void actionPerformed(ActionEvent e) {
			  ViewBalance page=new ViewBalance();
			  page.setFen(fen);			  
		  	  fen.setPage(page);
		  	  fen.go();
		  }

	}

}
