package model;

import java.io.Serializable;

/**
 * Classe qui repr�sente un compte.
 * Elle poss�de un numero, un titre, un total d'entr�es, un total de sorties, une �ventuelle liste de sous comptes et un �ventuel compte type.
 * Elle est serialisable pour pouvoir savaugarder les transactions.
 * @author RudySonetti
 * @version 1.0
 */
public class ModelCompte implements Serializable {
	
	private int numero; //code du compte
	private String titre; //titre
	private int totalEntrees=0; //total des entr�es
	private int totalSorties=0; //total des sorties
	private ModelCompte[] compte; //peut �tre transformer en tableau plus tard
	private ModelCompte type;

	private ModelCompte(int n, String t, ModelCompte[] c, ModelCompte type) {
		numero=n;
		titre=t;
		compte=c;
		this.type=type;
	}
	
	private ModelCompte(int n) { //cr�ation du compte dont le code est n
		numero=n;
		switch(n){
		case 1:
			titre="Capitaux";
			compte=new ModelCompte[9];
			compte[0]=new ModelCompte(0, "Capital",null,this);
			compte[1]=new ModelCompte(1, "Report � nouveau",null,this);
			compte[2]=new ModelCompte(2, "R�sultat",null,this);
			compte[3]=new ModelCompte(3, "Subvention d'investissement",null,this);
			compte[4]=new ModelCompte(4, "Provisions reglement�es",null,this);
			compte[5]=new ModelCompte(5, "Provisions risques/charges",null,this);
			compte[6]=new ModelCompte(6, "Emprunts/Dettes assimil�es",null,this);
			compte[7]=new ModelCompte(7, "Dettes participations",null,this);
			compte[8]=new ModelCompte(8, "Comptes liaison",null,this);
			break;
		case 2:
			titre="Immobilisations";
			compte=new ModelCompte[9];
			compte[0]=new ModelCompte(0, "Incorporelle",null,this);
			compte[1]=new ModelCompte(1, "Corporelle",null,this);
			compte[2]=new ModelCompte(2, "Concession",null,this);
			compte[3]=new ModelCompte(3, "En cours",null,this);
			compte[4]=new ModelCompte(5, "Parts entreprises li�es",null,this);
			compte[5]=new ModelCompte(6, "Participations",null,this);
			compte[6]=new ModelCompte(7, "Financi�res",null,this);
			compte[7]=new ModelCompte(8, "Ammortissements",null,this);
			compte[8]=new ModelCompte(9, "D�pr�ciation",null,this);
			break;
		case 3:
			titre="Stocks";
			compte=new ModelCompte[9];
			compte[0]=new ModelCompte(1, "Mati�res Premi�res",null,this);
			compte[1]=new ModelCompte(2, "Autres",null,this);
			compte[2]=new ModelCompte(3, "En-cours biens",null,this);
			compte[3]=new ModelCompte(4, "En-cours services",null,this);
			compte[4]=new ModelCompte(5, "Produits",null,this);
			compte[5]=new ModelCompte(6, "Stocks immobilisations",null,this);
			compte[6]=new ModelCompte(7, "Marchandises",null,this);
			compte[7]=new ModelCompte(8, "Diff �tats stocks",null,this);
			compte[8]=new ModelCompte(9, "Provisions pour d�pr�ciation",null,this);
			break;
		case 4:
			titre="Comptes tiers";
			compte=new ModelCompte[10];
			compte[0]=new ModelCompte(0, "Dettes Fournisseurs",null,this);
			compte[1]=new ModelCompte(1, "Cr�ances Clients",null,this);
			compte[2]=new ModelCompte(2, "Dettes Personnel",null,this);
			compte[3]=new ModelCompte(3, "Dettes Sociales",null,this);
			compte[4]=new ModelCompte(4, "Dettes Etat",null,this);
			compte[5]=new ModelCompte(5, "Groupes/associ�s",null,this);
			compte[6]=new ModelCompte(6, "Divers",null,this);
			compte[7]=new ModelCompte(7, "Attente/transition",null,this);
			compte[8]=new ModelCompte(8, "R�gularisation",null,this);
			compte[9]=new ModelCompte(9, "Provisions d�pr�ciation tiers",null,this);
			break;
		case 5:
			titre="Comptes financiers";
			compte=new ModelCompte[7];
			compte[0]=new ModelCompte(0, "VMPlacement",null,this);
			compte[1]=new ModelCompte(1, "Banque",null,this);
			compte[2]=new ModelCompte(2, "Instru tr�sorerie",null,this);
			compte[3]=new ModelCompte(3, "Caisse",null,this);
			compte[4]=new ModelCompte(4, "Avance/accr�ditif",null,this);
			compte[5]=new ModelCompte(8, "Virements internes",null,this);
			compte[6]=new ModelCompte(9, "Provisions d�pr�ciation financiers",null,this);
			break;
		case 6:
			titre="Charges";
			compte=new ModelCompte[10];
			compte[0]=new ModelCompte(0, "Achats",null,this);
			compte[1]=new ModelCompte(1, "Charges Externes",null,this);
			compte[2]=new ModelCompte(2, "Autres charges externes",null,this);
			compte[3]=new ModelCompte(3, "Imp�ts",null,this);
			compte[4]=new ModelCompte(4, "Charges Personnel",null,this);
			compte[5]=new ModelCompte(5, "Autres Charges",null,this);
			compte[6]=new ModelCompte(6, "Charges Financi�res",null,this);
			compte[7]=new ModelCompte(7, "Charges Exceptionnelles",null,this);
			compte[8]=new ModelCompte(8, "DAP",null,this);
			compte[9]=new ModelCompte(9, "Particip salari�s/Imp�ts b�n�f assim",null,this);
			break;
		case 7:
			titre="Produits";
			compte=new ModelCompte[9];
			compte[0]=new ModelCompte(0, "Vente",null,this);
			compte[1]=new ModelCompte(1, "Production stock�e",null,this);
			compte[2]=new ModelCompte(2, "Production immo",null,this);
			compte[3]=new ModelCompte(4, "Subventions exploit",null,this);
			compte[4]=new ModelCompte(5, "Autres Produits",null,this);
			compte[5]=new ModelCompte(6, "Produits Fincanciers",null,this);
			compte[6]=new ModelCompte(7, "Produits Exceptionnels",null,this);
			compte[7]=new ModelCompte(8, "RAP",null,this);
			compte[8]=new ModelCompte(9, "Transfert charges",null,this);
			break;
		default:
			titre="Invalide";
			compte=null;
			break;
		}
		type=null;
	}
	
	public ModelCompte getCompteByNum(int i){ //renvoie le compte portant le numero i
		ModelCompte c=compte[0]; //par d�faut le compte renvoy� sera le premier(si il n'existe pas)
		for(ModelCompte co:compte){
			if(co.getNumero()==i){
				c=co;
				break;
			}
		}
		return c;
	}
	
	public static ModelCompte[] getComptes(int[] t){ //cr�er et retourne le tableau de ModelCompte dont le code correspond aux chiffres+1 dans le tableau d'int
		ModelCompte[] tabc=new ModelCompte[t.length];
		for(int i=0; i<t.length; i++){
			tabc[i]=new ModelCompte(t[i]+1);
		}
		return tabc;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public ModelCompte getType() {
		return type;
	}
	
	public ModelCompte[] getCompte() {
		return compte;
	}

	public int getTotalEntrees() {
		if(compte==null){
			return totalEntrees;
		}else{
			int total=0;
			for(ModelCompte c:compte){
				total+=c.getTotalEntrees();
			}
			return total;
		}
	}
	
	public int getTotalSorties() {
		if(compte==null){
			return totalSorties;
		}else{
			int total=0;
			for(ModelCompte c:compte){
				total+=c.getTotalSorties();
			}
			return total;
		}
	}

	public void addTotalEntree(int m){
		totalEntrees+=m;
		//si c'est une charge ou un produit on met � jour le compte de capital 12 repr�sentant le r�sultat
		if(type.getNumero()==6){
			BD.getComptes()[0].getCompte()[2].addTotalEntree(m);
		}
		if(type.getNumero()==7){
			BD.getComptes()[0].getCompte()[2].addTotalSortie(m);
		}
	}
	
	public void setTotalSortie(int m){
		totalSorties=m;
	}

	public void addTotalSortie(int m){
		totalSorties+=m;
		//si c'est une charge ou un produit on met � jour le compte de capital 12 repr�sentant le r�sultat
		if(type.getNumero()==6){
			BD.getComptes()[0].getCompte()[2].addTotalEntree(m);
		}
		if(type.getNumero()==7){
			BD.getComptes()[0].getCompte()[2].addTotalSortie(m);
		}
	}
	
	public int getSolde(){
		return getTotalEntrees()-getTotalSorties();
	}
	
	public int getTotalEntreesBalance() { //ne prend pas en compte le compte de r�sultat 12
		if(compte==null){
			if(type.getNumero()==1&&numero==2){
				return 0;
			}
			return totalEntrees;
		}else{
			int total=0;
			for(ModelCompte c:compte){
				total+=c.getTotalEntreesBalance();
			}
			return total;
		}
	}
	
	public int getTotalSortiesBalance() { //ne prend pas en compte le compte de r�sultat 12
		if(compte==null){
			if(type.getNumero()==1&&numero==2){
				return 0;
			}
			return totalSorties;
		}else{
			int total=0;
			for(ModelCompte c:compte){
				total+=c.getTotalSortiesBalance();
			}
			return total;
		}
	}
	
	public int getSoldeBalance(){ //ne prend pas en compte le compte de r�sultat 12
		return getTotalEntreesBalance()-getTotalSortiesBalance();
	}
}
