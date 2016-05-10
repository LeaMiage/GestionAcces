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
		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}
		
		Hashtable annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries.txt");
		
		IdentiteCollaborateur collaborateur = (IdentiteCollaborateur) annuaire.get(idPersonne);
		if (collaborateur == null){
			throw new PersonneInconnue("Le salarié numéro " + idPersonne + " n'existe pas.");
		}
		
		return collaborateur;
	}

	@Override
	public void verifierPersonne(int idPersonne, String cleAPI) throws PersonneInconnue, CleInconnue {
		// TODO Auto-generated method stub
		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}
		
		Hashtable annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries.txt");
		
		IdentiteCollaborateur collaborateur = (IdentiteCollaborateur) annuaire.get(idPersonne);
		if (collaborateur == null){
			throw new PersonneInconnue("Le salarié numéro " + idPersonne + " n'existe pas.");
		}
	}

}
