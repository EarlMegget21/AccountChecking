package view.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.BD;
import model.ModelBalance;
import model.ModelBilan;
import model.ModelCompte;
import model.ModelJournal;
import model.ModelResultat;

public class ViewSave extends View {
	
	private JButton save = new JButton("Sauvegarder"); //bouton pour sauvegarder
	private JButton load = new JButton("Charger"); //bouton pour sauvegarder

	public ViewSave() {
		//listener pour les boutons
	    save.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event){
	    		//on affiche une boite de confirmation avec le bouton OUI et NON
	    	    int option = JOptionPane.showConfirmDialog(null,
	    	     "Etes-vous sûr(e)? L'ancienne sauvegarde sera écrasée.", 
	    	     "Lancement de l'animation", 
	    	     JOptionPane.YES_NO_OPTION, 
	    	     JOptionPane.QUESTION_MESSAGE);
	
	    	    if(option == JOptionPane.OK_OPTION){ //si l'utilisateur confirme, alors on sauvegarde
	    	    	ModelJournal journal=BD.getJournal();
	    	    	ModelResultat resultat=BD.getResultat();
	    	    	ModelBalance balance=BD.getBalance();
	    	    	ModelBilan bilan=BD.getBilan();
	    	    	ModelCompte[] comptes=BD.getComptes();
	    	    	ObjectOutputStream oos = null;
	    	    	try {
	    	    		final FileOutputStream fichier = new FileOutputStream("bd.ser");
	    	    		oos = new ObjectOutputStream(fichier);
	    	    		oos.writeObject(journal);
	    	    		oos.writeObject(resultat);
	    	    		oos.writeObject(balance);
	    	    		oos.writeObject(bilan);
	    	    		oos.writeObject(comptes);
	    	    		oos.flush();
	    	    	} catch (final java.io.IOException e) {
	    	    		e.printStackTrace();
	    	    	} finally {
	    	    		try {
	    	    			if (oos != null) {
	    	    				oos.flush();
	    	    				oos.close();
	    	    			}
	    	    		} catch (final IOException ex) {
	    	    			ex.printStackTrace();
	    	    		}
	    	    	}
	    	    }
	    	}
	    });

	    load.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event){   	
	    	    int option = JOptionPane.showConfirmDialog(null, 
	    	     "Etes-vous sûr(e)? Toutes vos transactions actuelles seront écrasées.", 
	    	     "Lancement de l'animation", 
	    	     JOptionPane.YES_NO_OPTION, 
	    	     JOptionPane.QUESTION_MESSAGE);
	
	    	    if(option == JOptionPane.OK_OPTION){
	    	    	ObjectInputStream ois = null;
	    	    	try {
	    	    		final FileInputStream fichier = new FileInputStream("bd.ser");
	    	    		ois = new ObjectInputStream(fichier);
	    	    		ModelJournal journal=(ModelJournal) ois.readObject();
	    	    		BD.setJournal(journal);
	    	    		ModelResultat resultat=(ModelResultat) ois.readObject();
	    	    		BD.setResultat(resultat);
	    	    		ModelBalance balance=(ModelBalance) ois.readObject();
	    	    		BD.setBalance(balance);
	    	    		ModelBilan bilan=(ModelBilan) ois.readObject();
	    	    		BD.setBilan(bilan);
	    	    		ModelCompte[] comptes=(ModelCompte[]) ois.readObject();
	    	    		BD.setComptes(comptes);
	    	    	} catch (final java.io.IOException e) {
	    	    		e.printStackTrace();
	    	    	} catch (final ClassNotFoundException e) {
	    	    		e.printStackTrace();
	    	    	} finally {
	    	    		try {
	    	    			if (ois != null) {
	    	    				ois.close();
	    	    			}
	    	    		} catch (final IOException ex) {
	    	    			ex.printStackTrace();
	    	    		}
	    	    	}
	    	    }
	    	}
	    });
	    
	  //ajout du bouton
	  JPanel boutton = new JPanel();
	  boutton.add(save);
	  
	  JPanel boutton2 = new JPanel();
	  boutton2.add(load);
	  
	  this.add(boutton);
	  this.add(boutton2);
	}

}
