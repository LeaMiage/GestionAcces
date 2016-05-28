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

	
	
	@Override
	public void ajouterAutorisationPermanente(AutorisationPermanente ap, String cleAPI)
			throws AutorisationInconnue, CleInconnue {

		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}

		String [] args = {};
		
		GestionSalaries gestionSalaries = PorteClient.getServiceGestionSalaries(args);
		try {
			gestionSalaries.verifierPersonne(ap.idPersonne, cleAPI);
			
			/* Vérification autorisation */
			
			Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier("src/Porte/BD_Autorisations.txt");

			String idAutorisation = ap.idPersonne + "_" + ap.heureDebut + "_" + ap.heureFin ;
			
			// Ajout si la clé n'existe pas déjà
			annuaireAutorisations.putIfAbsent(ap.idPersonne + "_" + ap.heureDebut + "_" + ap.heureFin, ap);
			
		} catch (PersonneInconnue e) {
			System.out.println("Erreur : Personne inconnue");
		} catch (CleInconnue e) {
			System.out.println("Erreur : clé inconnue");
		}
		
		
		
		
	}

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
			
			Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier("src/Porte/BD_Autorisations.txt");

			String idAutorisation = ap.idPersonne + "_" + ap.heureDebut + "_" + ap.heureFin ;
			
			// Ajout si la clé n'existe pas déjà
			annuaireAutorisations.putIfAbsent(ap.idPersonne + "_" + ap.heureDebut + "_" + ap.heureFin, ap);
			
		} catch (PersonneInconnue e) {
			System.out.println("Erreur : Personne inconnue");
		} catch (CleInconnue e) {
			System.out.println("Erreur : clé inconnue");
		}
		
		
		
		
	}

	@Override
	public void supprimerAutorisationPermanente(AutorisationPermanente ap, String cleAPI)
			throws AutorisationInconnue, CleInconnue {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterAutorisationTemporaire(AutorisationTemporaire at, String cleAPI)
			throws AutorisationInconnue, CleInconnue {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierAutorisationTemporaire(AutorisationTemporaire at, AutorisationTemporaire nt, String cleAPI)
			throws AutorisationInconnue, CleInconnue {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerAutorisationTemporaire(AutorisationTemporaire at, String cleAPI)
			throws AutorisationInconnue, CleInconnue {
		// TODO Auto-generated method stub
		
	}

}
