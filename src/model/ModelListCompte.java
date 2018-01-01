package model;

import java.io.Serializable;

/**
 * Classe qui possède une liste de comptes en attribut.
 * Elle est serialisable pour pouvoir savaugarder les transactions.
 * @see model.ModelCompte
 * @author RudySonetti
 * @version 1.0
 */
public class ModelListCompte implements Serializable {
	
private ModelCompte[] listComptes;

	/**
	 * Constructeur par défaut
	 */
	public ModelListCompte() {
		listComptes = null;
	}
	
	/**
     * Constructeur avec parametres.
     * @param t
     *            Tableau d'objets de type model.ModelCompte.
     */
	private ModelListCompte(int[] t) {
		listComptes = BD.getComptesNum(t);
	}
	
	public ModelCompte[] getListComptes() {
		return listComptes;
	}

	/**
     * Methode qui remplit l'attribut listComptes par le tableau comprenant les ModelCompte du résultat(6, 7).
     */
	public void getResultat(){
		int[] t={5,6};
		listComptes = BD.getComptesNum(t);
	}
	
	/**
     * Methode qui remplit l'attribut listComptes par le tableau comprenant les ModelCompte de la balance(tous).
     */
	public void getBalance(){
		int[] t={0, 1, 2, 3, 4, 5, 6};
		listComptes = BD.getComptesNum(t);
	}
	
	/**
     * Methode qui renvoie le tableau comprenant les ModelCompte de l'actif du bilan.
     * @return Le tableau comprenant les ModelCompte de l'actif du bilan.
     */
	public static ModelListCompte getActifBilan(){
		int[] t={1, 2, 4};
		return new ModelListCompte(t);
	}
	
	/**
     * Methode qui renvoie le tableau comprenant les ModelCompte du passif du bilan.
     * @return Le tableau comprenant les ModelCompte du passif du bilan.
     */
	public static ModelListCompte getPassifBilan(){
		int[] t={0, 3};
		return new ModelListCompte(t);
	}
	
	/**
     * Methode qui calcule la somme des soldes de tous les compte de l'attribut listComptes.
     * @return La somme entière des soldes de tous les compte de l'attribut listComptes.
     */
	public int getTotal(){
		int total=0;
		for(ModelCompte comptes:listComptes){
			total+=comptes.getSolde();
		}
		return total;
	}
}
