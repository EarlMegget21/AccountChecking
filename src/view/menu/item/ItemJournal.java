package view.menu.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Fenetre;
import view.page.ViewJournal;

public class ItemJournal extends MenuItem {

	public ItemJournal() {
		super();
		this.addActionListener(new JournalListener());
	}
	
	class JournalListener implements ActionListener{

		  public void actionPerformed(ActionEvent e) {
			  ViewJournal page=new ViewJournal();
			  page.setFen(fen);			  
		  	  fen.setPage(page);
		  	  fen.go();
		  }

	}

}
