package model;

import java.io.Serializable;

/**
 * Classe qui représente une entrée ou une sorie.
 * Elle possède un compte, un nom et un montant
 * Elle est serialisable pour pouvoir savaugarder les transactions.
 * @see model.ModelCompte
 * @author RudySonetti
 * @version 1.0
 */
public class ModelES implements Serializable{
	
	private ModelCompte compte;
	private String nom;
	private int montant;

	public ModelES() {
		nom="";
		montant=0;
	}
	
	public ModelES(ModelCompte mc, String n, int m) {
		compte=mc;
		nom=n;
		montant=m;
	}

	public ModelCompte getCompte() {
		return compte;
	}

	public String getNom() {
		return nom;
	}

	public int getMontant() {
		return montant;
	}

	public void addTotalEntree(){
		compte.addTotalEntree(montant);
	}
	
	public void addTotalSortie(){
		compte.addTotalSortie(montant);
	}
}
