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
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.PersonneExistante;
import GestionEntreeSortie.PersonneInconnue;

public class CreationCompteImpl extends GestionEntreeSortie.CreationComptePOA{

	@Override
	public int creerCP(String nomP, String prenomP, String mdp, String photoP, String cleAPI) throws CleInconnue, PersonneExistante, ChampVide {
		// TODO Auto-generated method stub
		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}
		
		Hashtable annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries.txt");
		
		GestionEntreeSortie.AutorisationTemporaire[] listeAutorisationsTemporaires = new GestionEntreeSortie.AutorisationTemporaire[10];
		Collaborateur collaborateur = new Collaborateur(annuaire.size(), nomP, prenomP, "", mdp, listeAutorisationsTemporaires);
		
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
		
		Hashtable annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries.txt");
		
		GestionEntreeSortie.AutorisationTemporaire[] listeAutorisationsTemporaires = new GestionEntreeSortie.AutorisationTemporaire[10];
		Collaborateur collaborateur = new Collaborateur(annuaire.size(), nomP, prenomP, "", mdp, listeAutorisationsTemporaires);
		
		annuaire.put(annuaire.size(), collaborateur);
		
		Helpers.GestionFichiers.ecrireFichier("src/AnnuaireSalaries/BD_Salaries.txt", annuaire);
		
		return collaborateur.idPersonne;
	}

}
