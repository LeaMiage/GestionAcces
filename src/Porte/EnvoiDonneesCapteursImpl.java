package Porte;

import GestionEntreeSortie.Authentification;
import GestionEntreeSortie.ChampVide;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.EmpreinteInconnue;
import GestionEntreeSortie.ErreurAuthentification;
import GestionEntreeSortie.ErreurEnvoi;
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.Journalisation;
import GestionEntreeSortie.JournalisationImpossible;
import GestionEntreeSortie.PersonneInconnue;
import GestionEntreeSortie.VerificationEmpreinte;

public class EnvoiDonneesCapteursImpl extends GestionEntreeSortie.EnvoiDonneesCapteursPOA{

	@Override
	public void accederZone(String empreinte, String photoP, String cleAPI) throws ErreurEnvoi, CleInconnue {
		
		System.out.println("Demande d'accès à une zone");
		
		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}
		
		String [] args = {};
		
		System.out.println("Contact de Authentification, VérificationEmpreinte et Journalisation");
		
		Authentification authentification = PorteClient.getServiceAuthentification(args);
		VerificationEmpreinte verificationEmpreinte = PorteClient.getServiceVerificationEmpreinte(args);
		Journalisation journalisation = PorteClient.getServiceJournalisation(args);
		
		try{
			IdentiteCollaborateur ic = authentification.authentifierPersonne(photoP, cleAPI);
			System.out.println("Photo valide");
			
			verificationEmpreinte.verifierEmpreinte(ic.idPersonne, empreinte, cleAPI);
			System.out.println("Empreinte valide");
			
			System.out.println("Identité confirmée. Bienvenue " + ic.prenomP + " " + ic.nomP);
			
			journalisation.journaliser(0, 0, photoP, "Autorisé", "Entrée", cleAPI);
			System.out.println("Journalisation effectuée");
			
			
		} catch (CleInconnue e) {
			System.out.println("Erreur : clé inconnue");
		} catch (ErreurAuthentification e) {
			System.out.println("Erreur : L'authentification a échoué");
		} catch (EmpreinteInconnue e) {
			System.out.println("Erreur : Empreinte inconnue");
		} catch (ChampVide e) {
			System.out.println("Erreur : Champ vide");
		} catch (JournalisationImpossible e) {
			System.out.println("Erreur : Journalisation impossible");
		}
	}

	@Override
	public void sortirZone(String empreinte, String photoP, String cleAPI) throws ErreurEnvoi, CleInconnue {
		// TODO Auto-generated method stub
		
	}

}
