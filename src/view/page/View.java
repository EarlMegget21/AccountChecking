package view.page;

import javax.swing.JPanel;

import view.Fenetre;

public class View extends JPanel{ //classe repr�sente le contenu de la fenetre (les documents h�ritent)
	
	protected Fenetre fen; //pour pouvoir acc�der � la fen�tre contenante

	public View() {
		super();
	}

	public Fenetre getFen() {
		return fen;
	}

	public void setFen(Fenetre fen) {
		this.fen = fen;
	}

}
