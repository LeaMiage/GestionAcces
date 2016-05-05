package AnnuaireSalaries;

import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.PersonneInconnue;

public class GestionSalariesImpl extends GestionEntreeSortie.GestionSalariesPOA{

	@Override
	public IdentiteCollaborateur rechercherSalarie(int idPersonne, String cleAPI) throws PersonneInconnue, CleInconnue {
		// TODO Auto-generated method stub

		System.out.println("Test : rechercherSalarie");
		return null;
	}

	@Override
	public void verifierPersonne(int idPersonne, String cleAPI) throws PersonneInconnue, CleInconnue {
		// TODO Auto-generated method stub

		System.out.println("Test : verifierPersonne");
	}

}
