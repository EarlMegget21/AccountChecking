package view.page;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.BD;
import model.Date;
import model.ModelCompte;
import model.ModelES;
import model.ModelTransaction;

public class ViewTransactions extends View {
	
	private String[] tabJour; //tableau des jours pour la liste déroulante
	private String[] tabMois; //tableau des mois pour la liste déroulante
	private String[] tabCombo = {"1", "2", "3", "4", "5", "6", "7"}; //tableau des comptes pour la liste déroulante
	private String[] tabCombo2 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}; //tableau des comptes pour la liste déroulante
	
	private JComboBox jour; //liste déroulante jours
	private JComboBox mois; //liste déroulante mois
	private JTextField annee; //champ texte
	private JLabel date = new JLabel("Date: "); //Label pour la date

	//liste déroulante/champ de texte pour l'entrée
	private JPanel paneSortie=new JPanel();
	
	private JComboBox compteEntree = new JComboBox(tabCombo);
	private JComboBox compteEntree2 = new JComboBox(tabCombo2);
	private JLabel labelCompteE = new JLabel("Compte Entrée");
	
	private JTextField titreEntree = new JTextField("ex: aquisition immeuble");
	private JLabel labelTitreE = new JLabel("Titre Entree");
	  
	private JTextField montantEntree = new JTextField("ex: 10000");
	private JLabel labelMontantE = new JLabel("Montant Entree");
	
	private BoutonPage addE = new BoutonPage("Add"); //bouton pour ajouter des entrées
	private int i=1, ii=1; //i indice de ligne pour l'affichage (la ligne 0 est pour les input), ii nombre de valeurs null dans transacEntree
	
	private ArrayList<ModelES> transacEntree=null; //liste des entrées pour créer la transaction
	
	private ArrayList<Component[]> listE=new ArrayList<Component[]>(); //liste des composants graphiques pour l'affichage
	
	//liste déroulante/champ de texte pour la sortie
	private JPanel paneEntree=new JPanel();
	
	private JComboBox compteSortie = new JComboBox(tabCombo);
	private JComboBox compteSortie2 = new JComboBox(tabCombo2);
	private JLabel labelCompteS = new JLabel("Compte Sortie");
	  
	private JTextField titreSortie = new JTextField("ex: paiement immeuble");
	private JLabel labelTitreS = new JLabel("Titre Sortie");
	
	private JTextField montantSortie = new JTextField("ex: 10000");
	private JLabel labelMontantS = new JLabel("Montant Sortie");
	
	private BoutonPage addS = new BoutonPage("Add"); //bouton pour ajouter
	private int j=1, jj=1;
	
	private ArrayList<ModelES> transacSortie=null;
	
	private ArrayList<Component[]> listS=new ArrayList<Component[]>();
	
	private JButton confirmer = new JButton("Confirmer"); //bouton pour confirmer
	
	public ViewTransactions() {
		super();
		//initialisation des tableaux de jour et mois
		tabJour=new String[31];
		tabMois=new String[12];
		for(int i=0;i<31;i++){
			tabJour[i]=""+(i+1);
		}
		for(int i=0;i<12;i++){
			tabMois[i]=""+(i+1);
		}
		//création et parametrage des listes déroulantes et champ de texte pour la date
		jour = new JComboBox(tabJour);
		mois = new JComboBox(tabMois);
		annee = new JTextField("ex: 2017");
		annee.setForeground(Color.GRAY);
		annee.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (annee.getText().equals("ex: 2017")) {
		        	annee.setText("");
		        	annee.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (annee.getText().isEmpty()) {
		        	annee.setForeground(Color.GRAY);
		        	annee.setText("ex: 2017");
			        confirmer.setEnabled(false);
		        }else{
			        if(j!=jj&&i!=ii){ //on active le bouton confirmer si le champ et les listes ne sont pas vide sinon on le désactive
			        	confirmer.setEnabled(true);
			        }
		        }
		    }
		    });
		
		annee.addKeyListener(new KeyAdapter() { //pour accepter que des int
			    public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			      }
			    }
			  });
		
		jour.setPreferredSize(new Dimension(50, 30));
		mois.setPreferredSize(new Dimension(50, 30));
		annee.setPreferredSize(new Dimension(55, 30));

		//création des paneaux comprenant les champs
		JPanel combo11 = new JPanel(); //comprenant la date (au milieu des deux vides)
		//initalisation pour la date
		combo11.add(date);
		combo11.add(jour);
		combo11.add(mois);
		combo11.add(annee);
		
		//création/parametrage des champs
		
	    JPanel combo1 = new JPanel();
	    combo1.add(labelCompteE);
	    combo1.add(compteEntree);
	    combo1.add(compteEntree2);
	    
	    titreEntree.setPreferredSize(new Dimension(200, 30));
	    titreEntree.setForeground(Color.GRAY);
	    titreEntree.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (titreEntree.getText().equals("ex: aquisition immeuble")) {
		        	titreEntree.setText("");
		        	titreEntree.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (titreEntree.getText().isEmpty()) {
		        	titreEntree.setForeground(Color.GRAY);
		        	titreEntree.setText("ex: aquisition immeuble");
		        }
		    }
		    });
	    
	    JPanel text1 = new JPanel();
	    text1.add(labelTitreE);
	    text1.add(titreEntree);
	    
	    montantEntree.setPreferredSize(new Dimension(100, 30));
	    montantEntree.setForeground(Color.GRAY);
	    montantEntree.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (montantEntree.getText().equals("ex: 10000")) {
		        	montantEntree.setText("");
		        	montantEntree.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (montantEntree.getText().isEmpty()) {
		        	montantEntree.setForeground(Color.GRAY);
		        	montantEntree.setText("ex: 10000");
		        }
		    }
		    });
	    
	    montantEntree.addKeyListener(new KeyAdapter() { //pour accepter que des int
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE))) {
		        getToolkit().beep();
		        e.consume();
		      }
		    }
		  });
	    
	    JPanel nb1 = new JPanel();
	    nb1.add(labelMontantE);
	    nb1.add(montantEntree);
		
	    JPanel combo2 = new JPanel();
	    combo2.add(labelCompteS);
	    combo2.add(compteSortie);
	    combo2.add(compteSortie2);
	    
	    titreSortie.setPreferredSize(new Dimension(200, 30));
	    titreSortie.setForeground(Color.GRAY);
	    titreSortie.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (titreSortie.getText().equals("ex: paiement immeuble")) {
		        	titreSortie.setText("");
		        	titreSortie.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (titreSortie.getText().isEmpty()) {
		        	titreSortie.setForeground(Color.GRAY);
		        	titreSortie.setText("ex: paiement immeuble");
		        }
		    }
		    });
	    
	    JPanel text2 = new JPanel();
	    text2.add(labelTitreS);
	    text2.add(titreSortie);
	    
	    montantSortie.setPreferredSize(new Dimension(100, 30));
	    montantSortie.setForeground(Color.GRAY);
	    montantSortie.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (montantSortie.getText().equals("ex: 10000")) {
		        	montantSortie.setText("");
		        	montantSortie.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (montantSortie.getText().isEmpty()) {
		        	montantSortie.setForeground(Color.GRAY);
		        	montantSortie.setText("ex: 10000");
		        }
		    }
		    });
	    
	    montantSortie.addKeyListener(new KeyAdapter() { //pour accepter que des int
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE))) {
		        getToolkit().beep();
		        e.consume();
		      }
		    }
		  });
	    
	    JPanel nb2 = new JPanel();
	    nb2.add(labelMontantS);
	    nb2.add(montantSortie);
	    
	    //listener pour les boutons
	    confirmer.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event){
	    		//on créer la transaction en lui passant les listes d'entrée et de sortie et on l'ajoute à la BD
	    		ModelTransaction t1=new ModelTransaction(new Date(jour.getSelectedIndex()+1,mois.getSelectedIndex()+1,Integer.parseInt(annee.getText())),transacEntree,transacSortie);
	    		BD.addTransaction(t1);
	    		transacEntree=null; //on réinitialise la liste d'entrées
	    		i=1; //on remet l'index à 1
	    		for(Component[] ligne:listE){ //on retire tous les Components du GridBagLayout
	    			if(ligne!=null){
		    			for(Component elem:ligne){
		    				paneEntree.remove(elem);
		    			}
	    			}
	    		}
	    		listE=new ArrayList<Component[]>();
	    		//pareil pour les sorties
	    		transacSortie=null;
	    		j=1;
	    		for(Component[] ligne:listS){
	    			if(ligne!=null){
		    			for(Component elem:ligne){
		    				paneSortie.remove(elem);
		    			}
	    			}
	    		}
	    		listS=new ArrayList<Component[]>();
	    		confirmer.setEnabled(false); //on redésactive le bouton
	    		//on réinitialise les input à une valeur par défaut
	    	    compteEntree.setSelectedIndex(0);
	    	    compteEntree2.setSelectedIndex(0);
	    	    titreEntree.setText("Inconnu");
	    	    montantEntree.setText("0");
	    	    compteSortie.setSelectedIndex(0);
	    	    compteSortie2.setSelectedIndex(0);
	    	    titreSortie.setText("Inconnu");
	    	    montantSortie.setText("0");
	    	    jour.setSelectedIndex(0);
	    	    mois.setSelectedIndex(0);
	    	    annee.setText("2017");
	    		fen.go(); //on repaint la fenêtre
	    	}
	    });
	    
	    confirmer.setEnabled(false);
	    
	    addE.setConteneur(this); //on définit le conteneur du bouton addE
	    
	    addE.addActionListener(new ActionListener(){ //listener pour ajouter des entrées
	    	public void actionPerformed(ActionEvent event){
	    		if (!montantEntree.getText().equals("ex: 10000")&&!titreEntree.getText().equals("ex: aquisition immeuble")) {
	    			if(transacEntree==null){ //si la liste des modèle entrée est vide
	    				transacEntree=new ArrayList<ModelES>(); //on la crée
	    			}
	    			i+=1; //on incrément l'indice des entrées
	    			//on récupère la valeur des champs input
	    			int code=compteEntree.getSelectedIndex();
	    			int code2=compteEntree2.getSelectedIndex();
	    			String text=titreEntree.getText();
	    			String montant=montantEntree.getText();
	    			//on créer le modèle entrée et on l'ajoute à la liste
	    			int[] numComptes={code};
	    			ModelCompte[] compte2=BD.getComptesNum(numComptes); //récupération du type de compte
	    			ModelCompte compte=compte2[0].getCompteByNum(code2); //récupération du compte
	    			ModelES entree=new ModelES(compte, text, Integer.parseInt(montant));
	    			transacEntree.add(entree); //si on veut favoriser les perf stockage aux perf rapidité alors on parcours la liste pour voir si il y a des maillons à null pour les attribuer sinon on ajoute à la fin de la liste
	    			//on affiche les composants en les ajoutant au GridBagLayout
	    			GridBagConstraints c = new GridBagConstraints(); //création de contraintes

	    			PanneauString pCode=new PanneauString("["+(code+1)+""+code2+"]");
	    			c.fill = GridBagConstraints.HORIZONTAL; //indique que le moyen de remplissage est horizontal (largeur)
	    			c.weightx = 0.0; //c'est comme le flex grow en CSS (priorité de remplissage)
	    			c.gridwidth = 1; //indique le nombre de cases qu'il occupe en largeur
	    			c.ipady = 12; //indique la taille verticale en pixels
	    			c.gridx = 0; //index de ligne
	    			c.gridy = i; //index de colonne
	    			paneEntree.add(pCode,c); //on l'ajoute avec les contraintes correspondantes

	    			PanneauString pText=new PanneauString(text);
	    			c.gridx = 1;
	    			c.gridy = i;
	    			paneEntree.add(pText,c);

	    			PanneauString pMontant=new PanneauString(montant);
	    			c.gridx = 2;
	    			c.gridy = i;
	    			paneEntree.add(pMontant,c);

	    			JButton delete=new JButton("Del"); //on créer un bouton pour pouvoir supprimer la ligne
	    			c.gridx = 3;
	    			c.gridy = i;
	    			paneEntree.add(delete,c);
	    			//on créer le tableau de Component et on l'ajoute à la liste des Components pour pouvoir sauvegarder leurs adresses
	    			Component[] t={pCode,pText,pMontant,delete};
	    			listE.add(t);

	    			int k=i-2; //on définit la constante indice de suppression (-2 car i est le prochain indice à créer et la première ligne du GridBagLayout est occupé par les input
	    			delete.addActionListener(new ActionListener(){ //listener du bouton de suppression
	    				public void actionPerformed(ActionEvent event){ //si on clique
	    					Component[] ta=listE.remove(k); //on retire les adresses des Component de la liste des composants graphiques
	    					listE.add(k,null); //on remplace le maillon par null pour pas créer de décalage dans les indices des autres Component
	    					//pareil pour la liste des entrées
	    					transacEntree.remove(k);
	    					transacEntree.add(k,null);
	    					//on les retire du Layout Component
	    					paneEntree.remove(ta[0]);
	    					paneEntree.remove(ta[1]);
	    					paneEntree.remove(ta[2]);
	    					paneEntree.remove(ta[3]);
	    					ii+=1;
	    					if(ii==i){//si toutes les valeurs dans la liste transacEntree sont null
	    	    				confirmer.setEnabled(false); //on desactive le bouton pour confirmer
	    	    			}
	    					fen.go();//on repaint la fenetre
	    				}
	    			});
	    			//on réinitialise les input à une valeur par défaut
	    			compteEntree.setSelectedIndex(0);
	    			compteEntree2.setSelectedIndex(0);
	    			titreEntree.setForeground(Color.GRAY);
	    			titreEntree.setText("ex: aquisition immeuble");
	    			montantEntree.setForeground(Color.GRAY);
	    			montantEntree.setText("ex: 10000");
	    			if(j!=jj&&!annee.getText().equals("ex: 2017")){//si on a au moins une sortie
	    				confirmer.setEnabled(true); //on active le bouton pour confirmer
	    			}
	    			fen.go(); //on repaint la fenêtre
	    		}
	    	}
	    });
	    //pareil pour le bouton pour ajouter des sorties
	    addS.setConteneur(this);
	    
	    addS.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event){
	    		if (!montantSortie.getText().equals("ex: 10000")&&!titreSortie.getText().equals("ex: paiement immeuble")) {
	    			if(transacSortie==null){
	    				transacSortie=new ArrayList<ModelES>();
	    			}
	    			j+=1;
	    			int code=compteSortie.getSelectedIndex();
	    			int code2=compteSortie2.getSelectedIndex();
	    			String text=titreSortie.getText();
	    			String montant=montantSortie.getText();

	    			int[] numComptes={code};
	    			ModelCompte[] compte2=BD.getComptesNum(numComptes);
	    			ModelCompte compte=compte2[0].getCompteByNum(code2);
	    			ModelES sortie=new ModelES(compte, text, Integer.parseInt(montant));
	    			transacSortie.add(sortie);

	    			GridBagConstraints c = new GridBagConstraints();

	    			PanneauString pCode=new PanneauString("["+(code+1)+""+code2+"]");
	    			c.fill = GridBagConstraints.HORIZONTAL;
	    			c.weightx = 0.0;
	    			c.gridwidth = 1;
	    			c.ipady = 12;
	    			c.gridx = 0;
	    			c.gridy = j;
	    			paneSortie.add(pCode,c);

	    			PanneauString pText=new PanneauString(text);
	    			c.gridx = 1;
	    			c.gridy = j;
	    			paneSortie.add(pText,c);

	    			PanneauString pMontant=new PanneauString(montant);
	    			c.gridx = 2;
	    			c.gridy = j;
	    			paneSortie.add(pMontant,c);

	    			JButton delete=new JButton("Del");
	    			c.gridx = 3;
	    			c.gridy = j;
	    			paneSortie.add(delete,c);

	    			Component[] t={pCode,pText,pMontant,delete};
	    			listS.add(t);
	    			int k=j-2;
	    			delete.addActionListener(new ActionListener(){
	    				public void actionPerformed(ActionEvent event){
	    					Component[] ta=listS.remove(k);
	    					listS.add(k,null);
	    					transacSortie.remove(k);
	    					transacSortie.add(k,null);
	    					paneSortie.remove(ta[0]);
	    					paneSortie.remove(ta[1]);
	    					paneSortie.remove(ta[2]);
	    					paneSortie.remove(ta[3]);
	    					jj+=1;
	    					if(jj==j){//si toutes les valeurs dans la liste transacSortie sont null
	    	    				confirmer.setEnabled(false); //on desactive le bouton pour confirmer
	    	    			}
	    					fen.go();
	    				}
	    			});
	    			compteSortie.setSelectedIndex(0);
	    			compteSortie2.setSelectedIndex(0);
	    			titreSortie.setForeground(Color.GRAY);
	    			titreSortie.setText("ex: paiement immeuble");
	    			montantSortie.setForeground(Color.GRAY);
	    			montantSortie.setText("ex: 10000");
	    			if(i!=ii&&!annee.getText().equals("ex: 2017")){
	    				confirmer.setEnabled(true);
	    			}
	    			fen.go();
	    		}
	    	}
	    });

	    //ajout du bouton
	    JPanel boutton = new JPanel();
	    boutton.add(confirmer);
	    //mise en place de l'agencement de la page
	    this.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();

	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.0;
	    c.gridwidth = 2;
	    c.gridx = 0;
		c.gridy = 0;
		this.add(combo11, c);
		
		paneEntree.setLayout(new GridBagLayout());
	    c.weightx = 0.5;
	    c.weighty = 1;
	    c.gridwidth = 1;
	    c.gridx = 0;
		c.gridy = 1;
	    this.add(paneEntree, c);
	    paneEntree.add(combo1);
	    paneEntree.add(text1);
	    paneEntree.add(nb1);
	    paneEntree.add(addE);
		
		paneSortie.setLayout(new GridBagLayout());
	    c.gridx = 1;
		c.gridy = 1;
	    this.add(paneSortie, c);
	    paneSortie.add(combo2);
	    paneSortie.add(text2);
	    paneSortie.add(nb2);
	    paneSortie.add(addS);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.0;
	    //c.weighty = 0.2;
	    c.gridwidth = 2;
	    c.gridx = 0;
		c.gridy = 2;
	    this.add(boutton,c);
	}
}
