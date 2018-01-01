package model;

/**
 * Classe qui représente la balance.
 * Elle est serialisable pour pouvoir savaugarder les transactions.
 * @see model.ModelListCompte
 * @author RudySonetti
 * @version 1.0
 */
public class ModelBalance extends ModelListCompte {

	public ModelBalance() {
		this.getBalance();
	}
	
	public int[] getTotalDebitCredit(){
		int[] total={0,0};
		int montant;
		for(ModelCompte compte:this.getListComptes()){
			montant=compte.getSoldeBalance();
			if(montant>0){
				total[0]+=montant;
			}else{
				total[1]+=montant;
			}
		}
		return total;
	}
}
