package AnnuaireSalaries;

import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.PersonneInconnue;

public class CreationCompteImpl extends GestionEntreeSortie.CreationComptePOA{

	@Override
	public int creerCP(String nomP, String prenomP, String mdp, String cleAPI) throws CleInconnue, PersonneInconnue {
		// TODO Auto-generated method stub

		System.out.println("Test : creerCP");
		return 0;
	}

	@Override
	public int creerCT(String nomP, String prenomP, String mdp, String cleAPI) throws CleInconnue, PersonneInconnue {
		// TODO Auto-generated method stub
		
		System.out.println("Test : creerCT");
		return 0;
	}

}
