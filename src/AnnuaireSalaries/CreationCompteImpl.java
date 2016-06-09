package AnnuaireSalaries;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import GestionEntreeSortie.AutorisationTemporaire;
import GestionEntreeSortie.ChampVide;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.Collaborateur;
import GestionEntreeSortie.ErreurAuthentification;
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.PersonneExistante;
import GestionEntreeSortie.PersonneInconnue;

public class CreationCompteImpl extends GestionEntreeSortie.CreationComptePOA{

	@Override
	public int creerCP(String nomP, String prenomP, String mdp, String photoP, String cleAPI) throws CleInconnue, PersonneExistante, ChampVide {
		// TODO Auto-generated method stub
		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("La clé API est invalide.");
		}
		if (nomP.isEmpty() | prenomP.isEmpty() | mdp.isEmpty() | photoP.isEmpty()){
			throw new ChampVide("Un des champs est vide.");
		}
		if (verifierPersonne(nomP, prenomP)){
			throw new PersonneExistante("L'employé " + prenomP + " " + nomP + " est déjà présent dans l'annuaire.");
		}
		
		Hashtable<Integer, Collaborateur> annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries.txt");
		
		Collaborateur collaborateur = new Collaborateur(annuaire.size(), nomP, prenomP, mdp, photoP);
		
		annuaire.put(annuaire.size(), collaborateur);
		
		Helpers.GestionFichiers.ecrireFichier("src/AnnuaireSalaries/BD_Salaries.txt", annuaire);
		
		return collaborateur.idPersonne;		
	}

	@Override
	public int creerCT(String nomP, String prenomP, String mdp, String photoP, String cleAPI) throws CleInconnue, PersonneExistante, ChampVide {
		// TODO Auto-generated method stub
		
		if (cleAPI==""){
			throw new CleInconnue("La clé API est invalide.");
		}
		if (nomP.isEmpty() | prenomP.isEmpty() | mdp.isEmpty() | photoP.isEmpty()){
			throw new ChampVide("Un des champs est vide.");
		}
		if (verifierPersonne(nomP, prenomP)){
			throw new PersonneExistante("L'employé " + prenomP + " " + nomP + " est déjà présent dans l'annuaire.");
		}
		
		Hashtable<Integer, Collaborateur> annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries.txt");
		
		Collaborateur collaborateur = new Collaborateur(annuaire.size(), nomP, prenomP, mdp, photoP);
		
		annuaire.put(annuaire.size(), collaborateur);
		
		Helpers.GestionFichiers.ecrireFichier("src/AnnuaireSalaries/BD_Salaries.txt", annuaire);
		
		return collaborateur.idPersonne;
	}
	
	private static boolean verifierPersonne(String nomP, String prenomP){
		Collaborateur collaborateur;
		boolean trouve = false;
		Hashtable<Integer, Collaborateur> annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries.txt");
		
		Enumeration e = annuaire.elements();
		
		while (e.hasMoreElements() & !trouve){
			collaborateur = (Collaborateur) e.nextElement();
			if (collaborateur.nomP.equals(nomP) & collaborateur.prenomP.equals(prenomP)){
				trouve = true;
			}
		}
		return trouve;
	}

}
