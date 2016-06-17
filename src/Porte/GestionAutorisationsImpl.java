package Porte;

import java.util.Enumeration;
import java.util.Hashtable;

import GestionEntreeSortie.AjoutAPImpossible;
import GestionEntreeSortie.Authentification;
import GestionEntreeSortie.AutorisationExistante;
import GestionEntreeSortie.AutorisationInconnue;
import GestionEntreeSortie.AutorisationPermanente;
import GestionEntreeSortie.AutorisationTemporaire;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.EntreeJournal;
import GestionEntreeSortie.GestionSalaries;
import GestionEntreeSortie.PersonneInconnue;
import GestionEntreeSortie.ZoneInconnue;

public class GestionAutorisationsImpl extends GestionEntreeSortie.GestionAutorisationPOA{

	private int idZone;
	private int idPorte;
	private String locationBDPerm;
	private String locationBDTemp;
	
	public GestionAutorisationsImpl(int idZone, int idPorte) {
		this.idZone=idZone;
		this.idPorte=idPorte;
		this.locationBDPerm="src/Porte/BD_Portes/BD_Autorisations_" + idZone + "_" + idPorte + "_Perm.txt";
		this.locationBDTemp="src/Porte/BD_Portes/BD_Autorisations_" + idZone + "_" + idPorte + "_Temp.txt";
	}


	/********Autorisations Permanentes
	 * @throws PersonneInconnue 
	 * @throws AjoutAPImpossible *********/
	
	@Override
	public void ajouterAutorisationPermanente(AutorisationPermanente ap, String cleAPI)
			throws AutorisationInconnue, CleInconnue, PersonneInconnue, AutorisationExistante, AjoutAPImpossible {

		
		System.out.println("Demande d'ajout d'autorisation pour le salarié " + ap.idPersonne);
		
		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}

		String [] args = {};
		
		System.out.println("Contact de GestionSalaries");
		
		GestionSalaries gestionSalaries = PorteClient.getServiceGestionSalaries(args);
		
		
		
		try {
			
			int retour = gestionSalaries.verifierPersonne(ap.idPersonne, cleAPI);
			
			if (retour==1){
				throw new  AjoutAPImpossible("Impossible d'ajouter une autorisation permanente pour un collaborateur temporaire");
			}
			
			System.out.println("Personne vérifiée");
			
			// Vérification autorisation 
			
			Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier(locationBDPerm);

			String idAutorisation = ap.idPersonne + "_" + ap.heureDebut + "_" + ap.heureFin ;
			
			// Ajout si l'autorisation n'existe pas déjà
			if (annuaireAutorisations.containsKey(idAutorisation))
				throw new AutorisationExistante("Erreur : l'autorisation existe déjà\n");
			
			annuaireAutorisations.put(idAutorisation, ap);
			
			Helpers.GestionFichiers.ecrireFichier(locationBDPerm, annuaireAutorisations);
			
			System.out.println("Autorisation permanente ajoutée");
			
			
		} catch (CleInconnue e) {
			System.out.println("Erreur : clé inconnue");

		}
		
	}

	
	/*
	 * Modif = Suppression ancienne + ajout nouvelle
	 * ap : Ancienne autorisation permanente
	 * np : Nouvelle autorisation permanente
	*/
	@Override
	public void modifierAutorisationPermanente(AutorisationPermanente ap, AutorisationPermanente np, String cleAPI)
			throws AutorisationInconnue, CleInconnue, AutorisationExistante, PersonneInconnue {
		

		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}

		String [] args = {};
		
		GestionSalaries gestionSalaries = PorteClient.getServiceGestionSalaries(args);
		try {
			gestionSalaries.verifierPersonne(ap.idPersonne, cleAPI);
			
			/* Vérification autorisation */
			
			Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier(locationBDPerm);
			
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
		} catch (AjoutAPImpossible e) {
			System.out.println(e.message);
		}
		
		
		
		
	}

	@Override
	public void supprimerAutorisationPermanente(AutorisationPermanente ap, String cleAPI)
			throws AutorisationInconnue, CleInconnue {


		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}

		String [] args = {};
		
		GestionSalaries gestionSalaries = PorteClient.getServiceGestionSalaries(args);
		try {
			gestionSalaries.verifierPersonne(ap.idPersonne, cleAPI);
			
			/* Vérification autorisation */
			
			Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier(locationBDPerm);

			String idAutorisation = ap.idPersonne + "_" + ap.heureDebut + "_" + ap.heureFin ;
			
			// Suppression de l'ancienne autorisation si elle existe
			if (annuaireAutorisations.containsKey(idAutorisation))
				annuaireAutorisations.remove(idAutorisation);
			else
				throw new AutorisationInconnue("L'autorisation à supprimer est inconnue.");

			Helpers.GestionFichiers.ecrireFichier(locationBDPerm, annuaireAutorisations);
			
			
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
		

		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}

		String [] args = {};
		
		GestionSalaries gestionSalaries = PorteClient.getServiceGestionSalaries(args);
		try {
			gestionSalaries.verifierPersonne(at.idPersonne, cleAPI);
			
			/* Vérification autorisation */
			
			Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier(locationBDTemp);

			String idAutorisation = at.idPersonne + "_" + at.dateDebut + "_" + at.dateFin;
			
			// Ajout si la clé n'existe pas déjà
			annuaireAutorisations.putIfAbsent(idAutorisation, at);
			
			Helpers.GestionFichiers.ecrireFichier(locationBDTemp, annuaireAutorisations);
			
			
		} catch (PersonneInconnue e) {
			System.out.println("Erreur : Personne inconnue");
		} catch (CleInconnue e) {
			System.out.println("Erreur : clé inconnue");
		}
		
	}

	@Override
	public void modifierAutorisationTemporaire(AutorisationTemporaire at, AutorisationTemporaire nt, String cleAPI)
			throws AutorisationInconnue, CleInconnue {

		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}

		String [] args = {};
		
		GestionSalaries gestionSalaries = PorteClient.getServiceGestionSalaries(args);
		try {
			gestionSalaries.verifierPersonne(at.idPersonne, cleAPI);
			
			/* Vérification autorisation */
			
			Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier(locationBDTemp);

			String idAutorisation = at.idPersonne + "_" + at.dateDebut + "_" + at.dateFin;
			
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


		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}

		String [] args = {};
		
		GestionSalaries gestionSalaries = PorteClient.getServiceGestionSalaries(args);
		try {
			gestionSalaries.verifierPersonne(at.idPersonne, cleAPI);
			
			/* Vérification autorisation */
			
			Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier(locationBDTemp);

			String idAutorisation = at.idPersonne + "_" + at.dateDebut + "_" + at.dateFin;
			
			// Suppression de l'ancienne autorisation si elle existe
			if (annuaireAutorisations.containsKey(idAutorisation))
				annuaireAutorisations.remove(idAutorisation);
			else
				throw new AutorisationInconnue("L'autorisation à supprimer est inconnue.");

			Helpers.GestionFichiers.ecrireFichier(locationBDTemp, annuaireAutorisations);
			
			
		} catch (PersonneInconnue e) {
			System.out.println("Erreur : Personne inconnue");
		} catch (CleInconnue e) {
			System.out.println("Erreur : clé inconnue");
		}
		
	}


	@Override
	public AutorisationPermanente[] listeAutorisationsPerm(int idZone, String cleAPI) throws ZoneInconnue, CleInconnue {


		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}
		
		Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier(locationBDPerm);
		
		
		AutorisationPermanente[] listeAP = new AutorisationPermanente[annuaireAutorisations.size()];
		
		Enumeration e = annuaireAutorisations.elements();
		int i=0;
		while (e.hasMoreElements()){
			listeAP[i] = (AutorisationPermanente) e.nextElement();
			i++;
		}
		
		return listeAP;
		
		
	}


	@Override
	public AutorisationTemporaire[] listeAutorisationsTemp(int idZone, String cleAPI) throws ZoneInconnue, CleInconnue {

		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}
		
		Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier(locationBDTemp);
		
		
		AutorisationTemporaire[] listeAT = new AutorisationTemporaire[annuaireAutorisations.size()];
		
		Enumeration e = annuaireAutorisations.elements();
		int i=0;
		while (e.hasMoreElements()){
			listeAT[i] = (AutorisationTemporaire) e.nextElement();
			i++;
		}
		
		return listeAT;
		
	}


	@Override
	public AutorisationPermanente[] listeAutorisationsPermPersonne(int idPersonne, String cleAPI)
			throws CleInconnue {

		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}
		
		Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier(locationBDPerm);
		
		Hashtable<String,AutorisationPermanente> listeTemp = new Hashtable<String,AutorisationPermanente>();

		
		Enumeration e = annuaireAutorisations.elements();
		
		while (e.hasMoreElements()){
			
			AutorisationPermanente ap = (AutorisationPermanente) e.nextElement();
			String idAutorisation = ap.idPersonne + "_" + ap.heureDebut + "_" + ap.heureFin ;
			
			if(ap.idPersonne==idPersonne)			
				listeTemp.put(idAutorisation, ap);
		}
		
		AutorisationPermanente[] listeAP = new AutorisationPermanente[listeTemp.size()];
		
		Enumeration e1 = listeTemp.elements();
		int i=0;
		while (e1.hasMoreElements()){
			listeAP[i] = (AutorisationPermanente) e1.nextElement();
			i++;
		}
		
		return listeAP;
	}


	@Override
	public AutorisationTemporaire[] listeAutorisationsTempPersonne(int idPersonne, String cleAPI)
			throws CleInconnue {
		
		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}
		
		Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier(locationBDTemp);
		
		Hashtable<String,AutorisationTemporaire> listeTemp = new Hashtable<String,AutorisationTemporaire>();

		
		Enumeration e = annuaireAutorisations.elements();
		
		while (e.hasMoreElements()){
			
			AutorisationTemporaire at = (AutorisationTemporaire) e.nextElement();
			String idAutorisation = at.idPersonne + "_" + at.dateDebut + "_" + at.dateFin;
			
			if(at.idPersonne==idPersonne)			
				listeTemp.put(idAutorisation, at);
		}
		
		AutorisationTemporaire[] listeAT = new AutorisationTemporaire[listeTemp.size()];
		
		Enumeration e1 = listeTemp.elements();
		int i=0;
		while (e1.hasMoreElements()){
			listeAT[i] = (AutorisationTemporaire) e1.nextElement();
			i++;
		}
		
		
		return listeAT;
	}

}
