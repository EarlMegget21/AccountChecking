package model;

import java.util.ArrayList;

/**
 * Classe qui représente la BD temporaire.
 * Elle stock en static les objets(comptes, transaction, journal, ..) qui seront sérialisés pour la sauvegarde.
 * Elle est serialisable pour pouvoir savaugarder les transactions.
 * @see model.ModelJournal
 * @see model.ModelResultat
 * @see model.ModelBalance
 * @see model.ModelBilan
 * @see model.ModelCompte
 * @author RudySonetti
 * @version 1.0
 */
public class BD {
	
	private static ModelJournal journal; //journal contenant toutes les transactions
	
	private static ModelResultat resultat;
	
	private static ModelBalance balance;
	
	private static ModelBilan bilan;
	
	private static ModelCompte[] comptes; //tableau des comptes

	public BD() {
		journal=new ModelJournal();
		int[] c={0,1,2,3,4,5,6};
		comptes=ModelCompte.getComptes(c); //on créer tous les comptes
		resultat=new ModelResultat();
		balance=new ModelBalance();
		bilan=new ModelBilan();
	}
	
	public static void addTransaction(ModelTransaction t){
		journal.addTransaction(t);
	}
	
	public static ArrayList<ModelTransaction> getTransactions(){
		return journal.getListTransactions();
	}
	
	public static ModelCompte[] getComptesNum(int[] t){ //récupère le tableau des comptes correspondants aux int+1 dans le tab en paramètres
		ModelCompte[] tabc=new ModelCompte[t.length];
		for(int i=0; i<t.length; i++){
			tabc[i]=comptes[t[i]];
		}
		return tabc;
	}
	
	public static ModelResultat getResultat() {
		return resultat;
	}

	public static ModelBalance getBalance() {
		return balance;
	}
	
	public static ModelBilan getBilan() {
		return bilan;
	}
	
	public static ModelCompte[] getComptes() {
		return comptes;
	}

	public static ModelJournal getJournal() {
		return journal;
	}

	public static void setJournal(ModelJournal journal) {
		BD.journal = journal;
	}

	public static void setResultat(ModelResultat resultat) {
		BD.resultat = resultat;
	}

	public static void setBalance(ModelBalance balance) {
		BD.balance = balance;
	}

	public static void setBilan(ModelBilan bilan) {
		BD.bilan = bilan;
	}

	public static void setComptes(ModelCompte[] comptes) {
		BD.comptes = comptes;
	}
}
