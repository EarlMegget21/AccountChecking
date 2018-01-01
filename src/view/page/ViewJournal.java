package view.page;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BD;

public class ViewJournal extends View {

	private ViewConteneurJournal contenu;

	private PanneauString page;

	private PanneauString footer;

	private BoutonPage suivant= new BoutonPage("Page Suivante");
	private BoutonPage precedent = new BoutonPage("Page Precedente");

	public ViewJournal() {
		super();
		
		contenu=new ViewConteneurJournal(); //cr�ation du contenu
		contenu.setConteneur(this); //pour pouvoir �tre accessible dans l'autre sens
		//d�finition du champ indiquant la page actuelle
		String s="Page "+(ViewConteneurJournal.getPage()+1);
		page=new PanneauString(s);
		page.setPreferredSize(new Dimension(100, 30));
		//initialisation du bouton suivant
		suivant.setConteneur(this);
		suivant.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){ //listener
				ViewConteneurJournal.incPage(); //si on clique on incremmente la page
				((ViewJournal)((BoutonPage)event.getSource()).getConteneur()).repaint(); //on repaint la fenetre enti�re
			}
		});
		//pareil pour le bouton pr�c�dent
		precedent.setConteneur(this);
		precedent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				ViewConteneurJournal.decPage();
				((ViewJournal)((BoutonPage)event.getSource()).getConteneur()).repaint();
			}
		});
		//cr�ation du footer
		footer=new PanneauString();
		footer.add(precedent);
		footer.add(page);
		footer.add(suivant);
		//d�finition de l'organisation de la page
		this.setLayout(new BorderLayout());
		this.add(contenu, BorderLayout.CENTER);
		this.add(footer, BorderLayout.SOUTH);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//r��criture du champ page
		int lastPage=BD.getTransactions().size()/4;
		String s=(ViewConteneurJournal.getPage()+1)+"/"+(lastPage+1);
		//affichage ou non des boutons si on est a la premi�re/derni�re page
		if(ViewConteneurJournal.getPage()==lastPage){
			suivant.setEnabled(false);
		}else{
			suivant.setEnabled(true);
		}
		if(BD.getTransactions().size()%4==0 && lastPage!=0){ //si le reste est nul(la taille de la liste est un multiple de nbAffich)
			suivant.setEnabled(false);
			s=(ViewConteneurJournal.getPage()+1)+"/"+(lastPage); //on enl�ve 1 au nombre de pages max � l'affichage
		}
		page.setText(s);
		if(ViewConteneurJournal.getPage()==0){
			precedent.setEnabled(false);
		}else{
			precedent.setEnabled(true);
		}
	}

	public BoutonPage getSuivant() {
		return suivant;
	}

	public BoutonPage getPrecedent() {
		return precedent;
	}

	public ViewConteneurJournal getContenu() {
		return contenu;
	}

	public void setContenu(ViewConteneurJournal contenu) {
		this.contenu = contenu;
	}

}
