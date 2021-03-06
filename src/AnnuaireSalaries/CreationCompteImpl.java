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
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}
		if (nomP.isEmpty() | prenomP.isEmpty() | mdp.isEmpty() | photoP.isEmpty()){
			throw new ChampVide("Un des champs est vide.");
		}
		if (verifierPersonne(nomP, prenomP)){
			throw new PersonneExistante("L'employé " + prenomP + " " + nomP + " est déjà présent dans l'annuaire.");
		}
		
		Hashtable<Integer, Collaborateur> annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries_Perm.txt");
		Hashtable<Integer, Collaborateur> annuaireTemp = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries_Temp.txt");
		
		Collaborateur collaborateur = new Collaborateur(annuaire.size()+annuaireTemp.size(), nomP, prenomP, photoP, mdp);
		
		annuaire.put(annuaire.size()+annuaireTemp.size(), collaborateur);
		
		Helpers.GestionFichiers.ecrireFichier("src/AnnuaireSalaries/BD_Salaries_Perm.txt", annuaire);
		
		return collaborateur.idPersonne;		
	}

	@Override
	public int creerCT(String nomP, String prenomP, String mdp, String photoP, String cleAPI) throws CleInconnue, PersonneExistante, ChampVide {
		// TODO Auto-generated method stub
		
		if (cleAPI==""){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}
		if (nomP.isEmpty() | prenomP.isEmpty() | mdp.isEmpty() | photoP.isEmpty()){
			throw new ChampVide("Un des champs est vide.");
		}
		if (verifierPersonne(nomP, prenomP)){
			throw new PersonneExistante("L'employé " + prenomP + " " + nomP + " est déjà présent dans l'annuaire.");
		}
		
		Hashtable<Integer, Collaborateur> annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries_Temp.txt");
		Hashtable<Integer, Collaborateur> annuairePerm = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries_Perm.txt");
		
		Collaborateur collaborateur = new Collaborateur(annuaire.size()+annuairePerm.size(), nomP, prenomP, photoP, mdp);
		
		annuaire.put(annuaire.size()+annuairePerm.size(), collaborateur);
		
		Helpers.GestionFichiers.ecrireFichier("src/AnnuaireSalaries/BD_Salaries_Temp.txt", annuaire);
		
		return collaborateur.idPersonne;
	}
	
	private static boolean verifierPersonne(String nomP, String prenomP){
		Collaborateur collaborateur;
		boolean trouve = false;
		Hashtable<Integer, Collaborateur> annuaireTemp = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries_Temp.txt");
		
		Enumeration e = annuaireTemp.elements();
		
		while (e.hasMoreElements() & !trouve){
			collaborateur = (Collaborateur) e.nextElement();
			if (collaborateur.nomP.equals(nomP) & collaborateur.prenomP.equals(prenomP)){
				trouve = true;
			}
		}
		Hashtable<Integer, Collaborateur> annuairePerm = Helpers.GestionFichiers.lireFichier("src/AnnuaireSalaries/BD_Salaries_Perm.txt");
		
		e = annuairePerm.elements();
		
		while (e.hasMoreElements() & !trouve){
			collaborateur = (Collaborateur) e.nextElement();
			if (collaborateur.nomP.equals(nomP) & collaborateur.prenomP.equals(prenomP)){
				trouve = true;
			}
		}
		return trouve;
	}
	
	public void initialisation() {
		try {
			Hashtable annuaire = new Hashtable<>();
			
			//Initialisation des fichiers à vide
			Helpers.GestionFichiers.ecrireFichier("src/AnnuaireSalaries/BD_Salaries_Perm.txt", annuaire);
			Helpers.GestionFichiers.ecrireFichier("src/AnnuaireSalaries/BD_Salaries_Temp.txt", annuaire);
			
			creerCT("Toto", "To", "testToto", "photoToto", Utils.Utils.cleApi);
			creerCT("Titi", "Ti", "testTiti", "photoTiti", Utils.Utils.cleApi);
			creerCP("Cheoux", "Lea", "lcheoux", "photoLea", Utils.Utils.cleApi);
			creerCP("Chevalier", "Theo", "tchevalier", "photoTheo", Utils.Utils.cleApi);
			creerCP("Movia", "Bastien", "bmovia", "photoBastien", Utils.Utils.cleApi);
			
		} catch (CleInconnue e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersonneExistante e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ChampVide e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
