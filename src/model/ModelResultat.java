package model;

/**
 * Classe qui représente le compte de résultat.
 * Elle est serialisable pour pouvoir savaugarder les transactions.
 * @see model.ModelListCompte
 * @author RudySonetti
 * @version 1.0
 */
public class ModelResultat extends ModelListCompte {

	public ModelResultat() {
		this.getResultat();
	}
	
	public int getMontantResultat(){
		int resultat=this.getTotalProduit()-this.getTotalCharge();
		return resultat;
	}
	
	public int getTotalCharge(){
		return this.getListComptes()[0].getSolde();
	}
	
	public int getTotalProduit(){ //on met - car pour les produits c'est sortie-entree
		return -this.getListComptes()[1].getSolde();
	}
}
