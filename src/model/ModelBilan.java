package model;

import java.io.Serializable;

/**
 * Classe qui représente le bilan.
 * Elle possède une liste de comptes d'actif et une liste de compte passif.
 * Elle est serialisable pour pouvoir savaugarder les transactions.
 * @see model.ModelListCompte
 * @author RudySonetti
 * @version 1.0
 */
public class ModelBilan  implements Serializable {
	
	private ModelListCompte actif;
	private ModelListCompte passif;

	public ModelBilan() {
		actif=ModelListCompte.getActifBilan();
		passif=ModelListCompte.getPassifBilan();
	}
	
	public ModelListCompte getActif(){
		return actif;
	}
	
	public ModelListCompte getPassif(){
		return passif;
	}
	
	public int totalActifBilan(){
		int banque=BD.getComptes()[4].getCompte()[1].getSolde();
		if(banque>0){ //on n'enlève pas la banque de l'actif si elle est positive
			banque=0;
		}
		return actif.getTotal()+BD.getComptes()[3].getCompte()[1].getSolde()-banque; //on ajoute les créances clients en on enlève la banque de l'actif si elle est négative
	}
	
	public int totalPassifBilan(){
		int banque=BD.getComptes()[4].getCompte()[1].getSolde(); //on ajoute la banque au passif si elle est en découvert
		if(banque>0){
			banque=0;
		}
		return -(passif.getTotal()-BD.getComptes()[3].getCompte()[1].getSolde()+banque); //en passif les sorties>entrées donc on met - devant tout, on enlève les créances client du passif et on ajoute la valeur absolue de la banque si elle est en découvert
	}

}
