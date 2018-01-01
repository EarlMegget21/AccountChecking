package view.page;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BoutonPage extends JButton { //bouton pour changer de page dans le journal
	
	private JPanel Conteneur; //on lui ajoute le conteneur pour qu'il soit accessible

	public BoutonPage() {
		super();
	}

	public BoutonPage(String text) {
		super(text);
		this.setVisible(true);
	}

	public JPanel getConteneur() {
		return Conteneur;
	}

	public void setConteneur(JPanel conteneur) {
		Conteneur = conteneur;
	}

}
