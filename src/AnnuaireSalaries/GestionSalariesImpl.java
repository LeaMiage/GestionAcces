package AnnuaireSalaries;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.PersonneInconnue;

public class GestionSalariesImpl extends GestionEntreeSortie.GestionSalariesPOA{

	@Override
	public IdentiteCollaborateur rechercherSalarie(int idPersonne, String cleAPI) throws PersonneInconnue, CleInconnue {
		// TODO Auto-generated method stub
			Hashtable annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries.txt");
			
			IdentiteCollaborateur collaborateur = (IdentiteCollaborateur) annuaire.get(idPersonne);
			
			return collaborateur;
	}

	@Override
	public void verifierPersonne(int idPersonne, String cleAPI) throws PersonneInconnue, CleInconnue {
		// TODO Auto-generated method stub

		System.out.println("Test : verifierPersonne");
	}

}
