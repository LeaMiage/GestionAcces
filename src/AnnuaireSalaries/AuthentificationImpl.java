package AnnuaireSalaries;

import java.util.Enumeration;
import java.util.Hashtable;

import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.Collaborateur;
import GestionEntreeSortie.ErreurAuthentification;
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.PersonneInconnue;

public class AuthentificationImpl extends GestionEntreeSortie.AuthentificationPOA{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void authentifierCompte(int idPersonne, String mdp, String cleAPI)
			throws ErreurAuthentification, CleInconnue {
		// TODO Auto-generated method stub
		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}
		
		Hashtable annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries.txt");
		
		Collaborateur collaborateur = (Collaborateur) annuaire.get(idPersonne);

		if (collaborateur == null){
			throw new ErreurAuthentification("Le salarié numéro " + idPersonne + " n'existe pas.");
		} else {
			if (!collaborateur.mdp.equals(mdp)){
				throw new ErreurAuthentification("Mot de passe incorrect.");
			}
		}

		System.out.println("Test : authentifierCompte");
		
	}

	@Override
	public IdentiteCollaborateur authentifierPersonne(String photoP, String cleAPI)
			throws ErreurAuthentification, CleInconnue {
		boolean trouve = false;
		IdentiteCollaborateur identiteCollaborateur;
		Collaborateur collaborateur = new Collaborateur();
		
		// TODO Auto-generated method stub
		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}
		
		Hashtable annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries.txt");
		
		System.out.println(annuaire.size());
		
		Enumeration e = annuaire.elements();
		
		while (e.hasMoreElements() & !trouve){
			collaborateur = (Collaborateur) e.nextElement();
			if (collaborateur.photoP.equals(photoP)){
				trouve = true;
			}
		}
		
		if (!trouve){
			throw new ErreurAuthentification("Aucun salarié associé à cette photo.");
		}
		System.out.println("Test : authentifierPersonne");
		identiteCollaborateur = new IdentiteCollaborateur(collaborateur.idPersonne, collaborateur.nomP, collaborateur.prenomP, collaborateur.photoP);
		return identiteCollaborateur;
	}

}
