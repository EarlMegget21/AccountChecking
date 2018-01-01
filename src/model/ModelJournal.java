package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe qui représente le journal où on stock les transactions dans une liste.
 * Elle est serialisable pour pouvoir savaugarder les transactions.
 * @see model.ModelTransaction
 * @author RudySonetti
 * @version 1.0
 */
public class ModelJournal implements Serializable{
	
	private ArrayList<ModelTransaction> listTransactions;

	public ModelJournal() {
		listTransactions=new ArrayList<ModelTransaction>();
	}
	
	public ArrayList<ModelTransaction> getListTransactions() {
		return listTransactions;
	}

	public void setListTransactions(ArrayList<ModelTransaction> listTransactions) {
		this.listTransactions = listTransactions;
	}
	
	public void addTransaction(ModelTransaction t){
		listTransactions.add(t);
	}

}
