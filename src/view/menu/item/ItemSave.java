package view.menu.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.page.ViewSave;

public class ItemSave extends MenuItem {

	public ItemSave() {
		super();
		this.addActionListener(new SaveListener());
	}

	class SaveListener implements ActionListener{

		  public void actionPerformed(ActionEvent e) {
			  ViewSave page=new ViewSave();
			  page.setFen(fen);
		  	  fen.setPage(page);
		  	  fen.go();
		  }

	}
}
