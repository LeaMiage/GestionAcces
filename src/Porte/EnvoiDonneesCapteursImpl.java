package Porte;

import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import GestionEntreeSortie.Authentification;
import GestionEntreeSortie.AutorisationPermanente;
import GestionEntreeSortie.AutorisationTemporaire;
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

	private int idZone;
	private int idPorte;
	
	public EnvoiDonneesCapteursImpl(int idZone, int idPorte) {
		this.idZone=idZone;
		this.idPorte=idPorte;
	}

	@Override
	public String accederZone(String empreinte, String photoP, String cleAPI) throws ErreurEnvoi, CleInconnue {
		
		System.out.println("Demande d'accès à une zone");
		
		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("La clé API est invalide.");
		}
		
		String [] args = {};
		String msg = "";
		
		System.out.println("Contact de Authentification, VérificationEmpreinte et Journalisation");
		
		Authentification authentification = PorteClient.getServiceAuthentification(args);
		VerificationEmpreinte verificationEmpreinte = PorteClient.getServiceVerificationEmpreinte(args);
		Journalisation journalisation = PorteClient.getServiceJournalisation(args);
		
		try{
			IdentiteCollaborateur ic = authentification.authentifierPersonne(photoP, cleAPI);
			System.out.println("Photo valide");
			
			verificationEmpreinte.verifierEmpreinte(ic.idPersonne, empreinte, cleAPI);
			System.out.println("Empreinte valide");
			
			
			// Vérification des autorisations
			Date date      = new Date();
			long timestamp = date.getTime();
			int heures     = date.getHours();
			int minutes    = date.getMinutes();
			boolean trouve = false;
			
			Hashtable annuaireAP = Helpers.GestionFichiers.lireFichier("src/Porte/BD_Autorisations_Perm.txt");
		    Set<String> keys     = annuaireAP.keySet();
		    Iterator<String> itr = keys.iterator();
		    
		    while (itr.hasNext() && ! trouve) {
		       String str = itr.next();
		       AutorisationPermanente autorisation = (AutorisationPermanente) annuaireAP.get(str);
		       
		       String[] exploded = autorisation.heureDebut.split(":");
		       int heures_autorisation  = Integer.parseInt(exploded[0]);
		       int minutes_autorisation = Integer.parseInt(exploded[1]);
		       
		       if (autorisation.idPersonne == ic.idPersonne && heures >= heures_autorisation
		       && minutes >= minutes_autorisation) {
		    	   trouve = true;
		       }
		    }

			Hashtable annuaireAT = Helpers.GestionFichiers.lireFichier("src/Porte/BD_Autorisations_Temp.txt");
		    Set<String> keys2     = annuaireAT.keySet();
		    Iterator<String> itr2 = keys2.iterator();
		    
		    while (itr2.hasNext() && ! trouve) {
			       String str = itr2.next();
			       AutorisationTemporaire autorisation = (AutorisationTemporaire) annuaireAT.get(str);
			       
			       if (autorisation.idPersonne == ic.idPersonne && timestamp >= autorisation.dateDebut
			       && timestamp < autorisation.dateFin) {
			    	   trouve = true;
			       }
			}

		    if (trouve) {
				System.out.println("Identité confirmée. Bienvenue " + ic.prenomP + " " + ic.nomP);
				
				journalisation.journaliser(0, 0, photoP, "Autorisé", "Entrée", cleAPI);
				msg = "Bienvenue " + ic.prenomP + " " + ic.nomP;
		    } else {
		    	journalisation.journaliser(0, 0, photoP, "Refusé", "Entrée", cleAPI);
		    	msg = "Autorisation refusée";
		    }
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
		return msg;
	}

	@Override
	public String sortirZone(String empreinte, String photoP, String cleAPI) throws ErreurEnvoi, CleInconnue {
		// TODO Auto-generated method stub
		return "TODO";
		
	}

}
