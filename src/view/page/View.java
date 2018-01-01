package view.page;

import javax.swing.JPanel;

import view.Fenetre;

public class View extends JPanel{ //classe représente le contenu de la fenetre (les documents héritent)
	
	protected Fenetre fen; //pour pouvoir accéder à la fenêtre contenante

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
