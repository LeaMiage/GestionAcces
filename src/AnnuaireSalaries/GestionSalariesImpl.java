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
		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}
		Collaborateur collaborateur = null;
		
		Hashtable annuaireTemp = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries_Temp.txt");
		Hashtable annuairePerm = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries_Perm.txt");
		
		Collaborateur collaborateurTemp = (Collaborateur) annuaireTemp.get(idPersonne);
		Collaborateur collaborateurPerm = (Collaborateur) annuairePerm.get(idPersonne);
		
		if (collaborateurTemp == null && collaborateurPerm == null){
			throw new PersonneInconnue("Le salarié numéro " + idPersonne + " n'existe pas.");
		}
		
		if (collaborateurTemp == null){
			collaborateur = collaborateurPerm;
		} else {
			collaborateur = collaborateurTemp;
		}
		
		IdentiteCollaborateur identiteCollaborateur = new IdentiteCollaborateur(collaborateur.idPersonne, collaborateur.nomP, collaborateur.prenomP, collaborateur.photoP);
		
		return identiteCollaborateur;
	}

	@Override
	//retourne 1 pour temporaire
	public int verifierPersonne(int idPersonne, String cleAPI) throws PersonneInconnue, CleInconnue {
		// TODO Auto-generated method stub
		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}
		Hashtable annuaireTemp = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries_Temp.txt");
		Hashtable annuairePerm = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries_Perm.txt");
		
		Collaborateur collaborateurTemp = (Collaborateur) annuaireTemp.get(idPersonne);
		Collaborateur collaborateurPerm = (Collaborateur) annuairePerm.get(idPersonne);
		
		if (collaborateurTemp == null && collaborateurPerm == null){
			throw new PersonneInconnue("Le salarié numéro " + idPersonne + " n'existe pas.");
		}
		if (collaborateurTemp == null){
			return 0;
		} else {
			return 1;
		}
	}
}
