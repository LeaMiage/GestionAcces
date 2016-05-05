package AnnuaireSalaries;

import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.ErreurAuthentification;
import GestionEntreeSortie.IdentiteCollaborateur;

public class AuthentificationImpl extends GestionEntreeSortie.AuthentificationPOA{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void authentifierCompte(int idPersonne, String mdp, String cleAPI)
			throws ErreurAuthentification, CleInconnue {
		// TODO Auto-generated method stub

		System.out.println("Test : authentifierCompte");
		
	}

	@Override
	public IdentiteCollaborateur authentifierPersonne(String photoP, String cleAPI)
			throws ErreurAuthentification, CleInconnue {
		// TODO Auto-generated method stub

		System.out.println("Test : authentifierPersonne");
		
		return null;
	}

}
