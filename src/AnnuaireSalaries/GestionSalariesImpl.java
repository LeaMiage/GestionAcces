package AnnuaireSalaries;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.Collaborateur;
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
		
		Collaborateur collaborateur = (Collaborateur) annuaire.get(idPersonne);
		
		if (collaborateur == null){
			throw new PersonneInconnue("Le salarié numéro " + idPersonne + " n'existe pas.");
		}
		
		IdentiteCollaborateur identiteCollaborateur = new IdentiteCollaborateur(collaborateur.idPersonne, collaborateur.nomP, collaborateur.prenomP, collaborateur.photoP);
		
		return identiteCollaborateur;
	}

	@Override
	public void verifierPersonne(int idPersonne, String cleAPI) throws PersonneInconnue, CleInconnue {
		// TODO Auto-generated method stub
		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}
		
		Hashtable annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries.txt");
		
		Collaborateur collaborateur = (Collaborateur) annuaire.get(idPersonne);
		
		if (collaborateur == null){
			throw new PersonneInconnue("Le salarié numéro " + idPersonne + " n'existe pas.");
		}
	}

}
