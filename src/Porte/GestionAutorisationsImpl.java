package Porte;

import java.util.Hashtable;

import GestionEntreeSortie.Authentification;
import GestionEntreeSortie.AutorisationInconnue;
import GestionEntreeSortie.AutorisationPermanente;
import GestionEntreeSortie.AutorisationTemporaire;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.GestionSalaries;
import GestionEntreeSortie.PersonneInconnue;

public class GestionAutorisationsImpl extends GestionEntreeSortie.GestionAutorisationPOA{

	
	
	/********Autorisations Permanentes*********/
	
	@Override
	public void ajouterAutorisationPermanente(AutorisationPermanente ap, String cleAPI)
			throws AutorisationInconnue, CleInconnue {

		
		System.out.println("Demande d'ajout d'autorisation pour le salarié " + ap.idPersonne);
		
		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}

		String [] args = {};
		
		System.out.println("Contact de GestionSalaries");
		
		GestionSalaries gestionSalaries = PorteClient.getServiceGestionSalaries(args);
		try {
			gestionSalaries.verifierPersonne(ap.idPersonne, cleAPI);
			
			System.out.println("Personne vérifiée");
			
			// Vérification autorisation 
			
			Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier("src/Porte/BD_Autorisations_Perm.txt");

			String idAutorisation = ap.idPersonne + "_" + ap.heureDebut + "_" + ap.heureFin ;
			
			// Ajout si la clé n'existe pas déjà
			annuaireAutorisations.putIfAbsent(idAutorisation, ap);
			
			Helpers.GestionFichiers.ecrireFichier("src/Porte/BD_Autorisations_Perm.txt", annuaireAutorisations);
			
			System.out.println("Autorisation permanente ajoutée");
			
			
		} catch (CleInconnue e) {
			System.out.println("Erreur : clé inconnue");
		} catch (PersonneInconnue e) {
			System.out.println("Erreur : Personne inconnue");
		}
		
	}

	
	/*
	 * Modif = Suppression ancienne + ajout nouvelle
	 * ap : Ancienne autorisation permanente
	 * np : Nouvelle autorisation permanente
	*/
	@Override
	public void modifierAutorisationPermanente(AutorisationPermanente ap, AutorisationPermanente np, String cleAPI)
			throws AutorisationInconnue, CleInconnue {
		

		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}

		String [] args = {};
		
		GestionSalaries gestionSalaries = PorteClient.getServiceGestionSalaries(args);
		try {
			gestionSalaries.verifierPersonne(ap.idPersonne, cleAPI);
			
			/* Vérification autorisation */
			
			Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier("src/Porte/BD_Autorisations_Perm.txt");
			
			String idAutorisation = ap.idPersonne + "_" + ap.heureDebut + "_" + ap.heureFin ;
			
			// Suppression de l'ancienne autorisation si elle existe
			if (annuaireAutorisations.containsKey(idAutorisation))
				supprimerAutorisationPermanente(ap, cleAPI);
			else
				throw new AutorisationInconnue("L'autorisation à modifier est inconnue.");
			
			ajouterAutorisationPermanente(np, cleAPI);		
			
			// Pas d'écriture dans le fichier BD, car les méthodes supprimer et ajouter le font déjà
			
			
		} catch (PersonneInconnue e) {
			System.out.println("Erreur : Personne inconnue");
		} catch (CleInconnue e) {
			System.out.println("Erreur : clé inconnue");
		}
		
		
		
		
	}

	@Override
	public void supprimerAutorisationPermanente(AutorisationPermanente ap, String cleAPI)
			throws AutorisationInconnue, CleInconnue {


		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}

		String [] args = {};
		
		GestionSalaries gestionSalaries = PorteClient.getServiceGestionSalaries(args);
		try {
			gestionSalaries.verifierPersonne(ap.idPersonne, cleAPI);
			
			/* Vérification autorisation */
			
			Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier("src/Porte/BD_Autorisations_Perm.txt");

			String idAutorisation = ap.idPersonne + "_" + ap.heureDebut + "_" + ap.heureFin ;
			
			// Suppression de l'ancienne autorisation si elle existe
			if (annuaireAutorisations.containsKey(idAutorisation))
				annuaireAutorisations.remove(idAutorisation);
			else
				throw new AutorisationInconnue("L'autorisation à supprimer est inconnue.");

			Helpers.GestionFichiers.ecrireFichier("src/Porte/BD_Autorisations_Perm.txt", annuaireAutorisations);
			
			
		} catch (PersonneInconnue e) {
			System.out.println("Erreur : Personne inconnue");
		} catch (CleInconnue e) {
			System.out.println("Erreur : clé inconnue");
		}
		
	}
	
	
	
	/********Autorisations Temporaires*********/

	@Override
	public void ajouterAutorisationTemporaire(AutorisationTemporaire at, String cleAPI)
			throws AutorisationInconnue, CleInconnue {
		

		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}

		String [] args = {};
		
		GestionSalaries gestionSalaries = PorteClient.getServiceGestionSalaries(args);
		try {
			gestionSalaries.verifierPersonne(at.idPersonne, cleAPI);
			
			/* Vérification autorisation */
			
			Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier("src/Porte/BD_Autorisations_Temp.txt");

			String idAutorisation = at.idPersonne + "_" + at.heureDebut + "_" + at.heureFin + "_" + at.jourDebut + "_" + at.jourFin;
			
			// Ajout si la clé n'existe pas déjà
			annuaireAutorisations.putIfAbsent(idAutorisation, at);
			
			Helpers.GestionFichiers.ecrireFichier("src/Porte/BD_Autorisations_Temp.txt", annuaireAutorisations);
			
			
		} catch (PersonneInconnue e) {
			System.out.println("Erreur : Personne inconnue");
		} catch (CleInconnue e) {
			System.out.println("Erreur : clé inconnue");
		}
		
	}

	@Override
	public void modifierAutorisationTemporaire(AutorisationTemporaire at, AutorisationTemporaire nt, String cleAPI)
			throws AutorisationInconnue, CleInconnue {

		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}

		String [] args = {};
		
		GestionSalaries gestionSalaries = PorteClient.getServiceGestionSalaries(args);
		try {
			gestionSalaries.verifierPersonne(at.idPersonne, cleAPI);
			
			/* Vérification autorisation */
			
			Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier("src/Porte/BD_Autorisations_Perm.txt");

			String idAutorisation = at.idPersonne + "_" + at.heureDebut + "_" + at.heureFin + "_" + at.jourDebut + "_" + at.jourFin;
			
			// Suppression de l'ancienne autorisation si elle existe
			if (annuaireAutorisations.containsKey(idAutorisation))
				supprimerAutorisationTemporaire(at, cleAPI);
			else
				throw new AutorisationInconnue("L'autorisation à modifier est inconnue.");
			
			ajouterAutorisationTemporaire(nt, cleAPI);		
			
			// Pas d'écriture dans le fichier BD, car les méthodes supprimer et ajouter le font déjà
			
		} catch (PersonneInconnue e) {
			System.out.println("Erreur : Personne inconnue");
		} catch (CleInconnue e) {
			System.out.println("Erreur : clé inconnue");
		}
		
	}

	@Override
	public void supprimerAutorisationTemporaire(AutorisationTemporaire at, String cleAPI)
			throws AutorisationInconnue, CleInconnue {


		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}

		String [] args = {};
		
		GestionSalaries gestionSalaries = PorteClient.getServiceGestionSalaries(args);
		try {
			gestionSalaries.verifierPersonne(at.idPersonne, cleAPI);
			
			/* Vérification autorisation */
			
			Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier("src/Porte/BD_Autorisations_Perm.txt");

			String idAutorisation = at.idPersonne + "_" + at.heureDebut + "_" + at.heureFin + "_" + at.jourDebut + "_" + at.jourFin;
			
			// Suppression de l'ancienne autorisation si elle existe
			if (annuaireAutorisations.containsKey(idAutorisation))
				annuaireAutorisations.remove(idAutorisation);
			else
				throw new AutorisationInconnue("L'autorisation à supprimer est inconnue.");

			Helpers.GestionFichiers.ecrireFichier("src/Porte/BD_Autorisations_Temp.txt", annuaireAutorisations);
			
			
		} catch (PersonneInconnue e) {
			System.out.println("Erreur : Personne inconnue");
		} catch (CleInconnue e) {
			System.out.println("Erreur : clé inconnue");
		}
		
	}

}
