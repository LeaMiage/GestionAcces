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
	//retourne 1 pour temporaire
	public int authentifierCompte(int idPersonne, String mdp, String cleAPI)
			throws ErreurAuthentification, CleInconnue {
		// TODO Auto-generated method stub
		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}
		
		Collaborateur collaborateur = null;
		
		// Récupération des deux types de collaborateurs pour vérifier leur type et le mot de passe
		Hashtable annuaireTemp = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries_Temp.txt");
		Hashtable annuairePerm = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries_Perm.txt");
		
		Collaborateur collaborateurTemp = (Collaborateur) annuaireTemp.get(idPersonne);
		Collaborateur collaborateurPerm = (Collaborateur) annuairePerm.get(idPersonne);
		
		if (collaborateurTemp == null && collaborateurPerm == null){
			throw new ErreurAuthentification("Le salarié numéro " + idPersonne + " n'existe pas.");
		}
		
		if (collaborateurTemp == null){
			collaborateur = collaborateurPerm;
		} else {
			collaborateur = collaborateurTemp;
		}
		if (!collaborateur.mdp.equals(mdp)){
			throw new ErreurAuthentification("Mot de passe incorrect.");
		}
		System.out.println("Test : authentifierCompte");
		if (collaborateurTemp == null){
			return 0;
		} else {
			return 1;
		}		
	}

	@Override
	public IdentiteCollaborateur authentifierPersonne(String photoP, String cleAPI)
			throws ErreurAuthentification, CleInconnue {
		boolean trouve = false;
		IdentiteCollaborateur identiteCollaborateur;
		Collaborateur collaborateur = new Collaborateur();
		
		// TODO Auto-generated method stub
		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}
		
		// Récuplwration de l’ensemble des collaborateurs pour comparer la photo transmise avec la photo enregistrée
		Hashtable annuairePerm = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries_Perm.txt");
		Hashtable annuaireTemp = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries_Temp.txt");
		
		System.out.println(annuairePerm.size());
		System.out.println(annuaireTemp.size());
		
		Enumeration e = annuairePerm.elements();
		
		while (e.hasMoreElements() & !trouve){
			collaborateur = (Collaborateur) e.nextElement();
			if (collaborateur.photoP.equals(photoP)){
				trouve = true;
			}
		}
		
		e = annuaireTemp.elements();
		
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
