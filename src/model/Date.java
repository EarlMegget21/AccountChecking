package model;

import java.io.Serializable;

/**
 * Classe qui représente une date.
 * Elle possède un jour, un mois et une année.
 * Elle est serialisable pour pouvoir savaugarder les transactions.
 * @author RudySonetti
 * @version 1.0
 */
public class Date implements Serializable{
	
	private int jour;
	private int mois;
	private int annee;

	public Date() {
		jour=01;
		mois=01;
		annee=2000;
	}
	
	public Date(int j, int m, int a) {
		jour=j;
		mois=m;
		annee=a;
	}
	
	public String toString(){
		String jour=""+this.jour;
		String mois=""+this.mois;
		if(this.jour<10){
			jour="0"+jour;
		}
		if(this.mois<10){
			mois="0"+mois;
		}
		return jour+"/"+mois+"/"+annee;
	}

}
