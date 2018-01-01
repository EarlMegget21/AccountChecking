package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe qui représente une transaction.
 * Elle possède une date, une liste d'entrées et une liste de sorties.
 * Elle est serialisable pour pouvoir savaugarder les transactions.
 * @see model.Date
 * @see model.ModelES
 * @author RudySonetti
 * @version 1.0
 */
public class ModelTransaction implements Serializable{
	
	private Date date;
	private ArrayList<ModelES> entrees;
	private ArrayList<ModelES> sorties;

	/**
     * Constructeur par défaut
     */
	public ModelTransaction() {
		date=new Date(2017, 10, 21);
		entrees=new ArrayList<ModelES>();
		sorties=new ArrayList<ModelES>();
	}
	
	/**
     * Constructeur avec parametres.
     * En plus d'instancier l'objet, il met à jour les totaux des comptes.
     * @see ModelTransaction#addTotalEntree()
     * @see ModelTransaction#addTotalSortie()
     * @param d
     *            Objet de type model.Date.
     * @param e
     *            ArrayList d'objets de type ModelES représentant les entrées.
     *            @see model.ModelES
     * @param s
     *            ArrayList d'objets de type ModelES représentant les sorties.
     *            @see model.ModelES
     */
	public ModelTransaction(Date d, ArrayList<ModelES> e, ArrayList<ModelES> s) {
		date=d;
		entrees=e;
		sorties=s;
		addTotalEntree();
		addTotalSortie();
	}
	
	/**
     * Met à jour les totaux d'entrée des comptes dans l'ArrayList entrees.
     */
	public void addTotalEntree(){
		for(int i=0;i<entrees.size();i++){
			if(entrees.get(i)!=null){ //si le maillon est nul alors on le retire sinon on met à jour les entrées des comptes
				entrees.get(i).addTotalEntree();
			}else{
				entrees.remove(i);
				i-=1; //on recul i car on à enlevé un élément de la liste donc tous le maillon suivant est d'indice i-1
			}
		}
	}
	
	/**
     * Met à jour les totaux de sortie des comptes dans l'ArrayList sorties.
     */
	public void addTotalSortie(){
		for(int i=0;i<sorties.size();i++){
			if(sorties.get(i)!=null){
				sorties.get(i).addTotalSortie();
			}else{
				sorties.remove(i);
				i-=1;
			}
		}
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<ModelES> getEntree() {
		return entrees;
	}

	public void setEntree(ArrayList<ModelES> entree) {
		this.entrees = entree;
	}

	public ArrayList<ModelES> getSortie() {
		return sorties;
	}

	public void setSortie(ArrayList<ModelES> sortie) {
		this.sorties = sortie;
	}

}
