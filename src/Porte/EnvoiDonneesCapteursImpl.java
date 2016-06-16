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
import GestionEntreeSortie.NonAutorise;
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
	public String accederZone(String empreinte, String photoP, String cleAPI) throws ErreurEnvoi, CleInconnue, ErreurAuthentification, EmpreinteInconnue, ChampVide, NonAutorise {
		
		System.out.println("Demande d'accès à une zone");
		
		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("La clé API est invalide.");
		}
		
		String [] args = {};
		String msg = "";
		Date date      = new Date();
		double timestamp = (double) date.getTime();
		
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
			
						int heures     = date.getHours();
						int minutes    = date.getMinutes();
						
						Date dateCourante = new Date(2016,1,1,heures,minutes);
						
						boolean trouve = false;
						
						
						// Parcours des autorisations permanentes
						
						Hashtable annuaireAP = Helpers.GestionFichiers.lireFichier("src/Porte/BD_Portes/BD_Autorisations_" + idZone + "_" + idPorte + "_Perm.txt");
					    Set<String> keys     = annuaireAP.keySet();
					    Iterator<String> itr = keys.iterator();
					    
					    System.out.println(annuaireAP.toString());
					    
					    System.out.println("Début du parcours des autorisations permanentes");
					    
					    while (itr.hasNext() && ! trouve) {
					    	
					    	
					       String str = itr.next();
					       AutorisationPermanente autorisation = (AutorisationPermanente) annuaireAP.get(str);
					       
					       System.out.println(str);
					    	
					       
					       
					       String[] exploded = autorisation.heureDebut.split(":");
					       int hdeb  = Integer.parseInt(exploded[0]);
					       int mdeb = Integer.parseInt(exploded[1]);
					       Date dateDebut = new Date(2016,1,1,hdeb,mdeb);
					       

					       exploded = autorisation.heureFin.split(":");
					       int hfin  = Integer.parseInt(exploded[0]);
					       int mfin = Integer.parseInt(exploded[1]);
					       Date dateFin = new Date(2016,1,1,hfin,mfin);
					       
					       
					       System.out.println("Il est "+ heures + "h" + minutes);
					       System.out.println("L'autorisation mentionne un accès entre "+ hdeb + "h" + mdeb + " et " + hfin + "h" + mfin);
							
					       
					       
					       if (autorisation.idPersonne == ic.idPersonne && dateCourante.after(dateDebut) && dateCourante.before(dateFin)){
					    	   
					    	   System.out.println("L'heure est conforme à l'autorisation");
					    	   trouve = true;
					    	   
					       }
					       else
					    	   System.out.println("L'heure n'est pas conforme à l'autorisation");
					       
					    }
					    
					    System.out.println("Fin du parcours des autorisations permanentes");
					    
					    // Parcours des autorisations temporaires

						Hashtable annuaireAT = Helpers.GestionFichiers.lireFichier("src/Porte/BD_Portes/BD_Autorisations_" + idZone + "_" + idPorte + "_Temp.txt");
					    Set<String> keys2     = annuaireAT.keySet();
					    Iterator<String> itr2 = keys2.iterator();
					    
					    System.out.println("Début du parcours des autorisations temporaires");
					    
					    while (itr2.hasNext() && ! trouve) {
						       String str = itr2.next();
						       AutorisationTemporaire autorisation = (AutorisationTemporaire) annuaireAT.get(str);
						       
						       System.out.println("Autorisation récupérée, début du test");
						       
						       Date dateDebut = new Date ((long) autorisation.dateDebut);
						       Date dateFin = new Date ((long) autorisation.dateFin);
						       
						       System.out.println("Il est " + date.toString());
						       System.out.println("L'autorisation mentionne un accès entre " + dateDebut.toString() + " et " + dateFin.toString());
								
						       
						       
						       if (autorisation.idPersonne == ic.idPersonne && date.after(dateDebut) && date.before(dateFin)) {
						    	   System.out.println("L'heure est conforme à l'autorisation");
						    	   trouve = true;
						       }
						}
					    System.out.println("Fin du parcours des autorisations temporaires");
					    
					    
					    if (trouve) {
							System.out.println("Identité confirmée. Bienvenue " + ic.prenomP + " " + ic.nomP);
							
							journalisation.journaliser(idZone, idPorte, photoP, "Autorisé", "Entrée", timestamp, cleAPI);
							msg = "Bienvenue " + ic.prenomP + " " + ic.nomP;
					    } else {   	
					    	journalisation.journaliser(idZone, idPorte, photoP, "Refusé", "Entrée", timestamp, cleAPI);
					    	msg = "Accès refusé";
					    	throw new NonAutorise("Accès refusé : vous n'avez pas l'autorisation d'accéder à cette zone");
					    }
						System.out.println("Journalisation effectuée");
					    
					    
		}catch(ErreurAuthentification e){
			
			System.out.println(e.message);
			try {
				journalisation.journaliser(idZone, idPorte, photoP, "Refusé", "Entrée", timestamp, cleAPI);
			} catch (JournalisationImpossible e1) {
				System.out.println(e1.message);
			}
			throw new ErreurAuthentification(e.message);
			
		}catch(EmpreinteInconnue e){
			
			System.out.println(e.message);
			try {
				journalisation.journaliser(idZone, idPorte, photoP, "Refusé", "Entrée", timestamp, cleAPI);
			} catch (JournalisationImpossible e1) {
				System.out.println(e1.message);
			}
			throw new EmpreinteInconnue(e.message);
			
		}catch(JournalisationImpossible e)
	    {
	    	System.out.println("Erreur : La journalisation n'a pas pu être effectuée");
	    }
	    catch(CleInconnue e)
	    {
	    	System.out.println("Erreur : La clé API est inconnue");
	    }
			
			
		   

		return msg;
	}

	@Override
	public String sortirZone(String empreinte, String photoP, String cleAPI) throws ErreurEnvoi, CleInconnue, ErreurAuthentification, EmpreinteInconnue, ChampVide, NonAutorise {
		
		System.out.println("Demande de sortie d'une zone");
		
		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("La clé API est invalide.");
		}
		
		String [] args = {};
		String msg = "";
		Date date      = new Date();
		double timestamp = (double) date.getTime();
		
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
			
						int heures     = date.getHours();
						int minutes    = date.getMinutes();
						
						Date dateCourante = new Date(2016,1,1,heures,minutes);
						
						boolean trouve = false;
						
						
						// Parcours des autorisations permanentes
						
						Hashtable annuaireAP = Helpers.GestionFichiers.lireFichier("src/Porte/BD_Portes/BD_Autorisations_" + idZone + "_" + idPorte + "_Perm.txt");
					    Set<String> keys     = annuaireAP.keySet();
					    Iterator<String> itr = keys.iterator();
					    
					    System.out.println(annuaireAP.toString());
					    
					    System.out.println("Début du parcours des autorisations permanentes");
					    
					    while (itr.hasNext() && ! trouve) {
					    	
					    	
					       String str = itr.next();
					       AutorisationPermanente autorisation = (AutorisationPermanente) annuaireAP.get(str);
					       
					       System.out.println(str);
					    	
					       
					       
					       String[] exploded = autorisation.heureDebut.split(":");
					       int hdeb  = Integer.parseInt(exploded[0]);
					       int mdeb = Integer.parseInt(exploded[1]);
					       Date dateDebut = new Date(2016,1,1,hdeb,mdeb);
					       

					       exploded = autorisation.heureFin.split(":");
					       int hfin  = Integer.parseInt(exploded[0]);
					       int mfin = Integer.parseInt(exploded[1]);
					       Date dateFin = new Date(2016,1,1,hfin,mfin);
					       
					       
					       System.out.println("Il est "+ heures + "h" + minutes);
					       System.out.println("L'autorisation mentionne un accès entre "+ hdeb + "h" + mdeb + " et " + hfin + "h" + mfin);
							
					       
					       
					       if (autorisation.idPersonne == ic.idPersonne && dateCourante.after(dateDebut) && dateCourante.before(dateFin)){
					    	   
					    	   System.out.println("L'heure est conforme à l'autorisation");
					    	   trouve = true;
					    	   
					       }
					       else
					    	   System.out.println("L'heure n'est pas conforme à l'autorisation");
					       
					    }
					    
					    System.out.println("Fin du parcours des autorisations permanentes");
					    
					    // Parcours des autorisations temporaires

						Hashtable annuaireAT = Helpers.GestionFichiers.lireFichier("src/Porte/BD_Portes/BD_Autorisations_" + idZone + "_" + idPorte + "_Temp.txt");
					    Set<String> keys2     = annuaireAT.keySet();
					    Iterator<String> itr2 = keys2.iterator();
					    
					    System.out.println("Début du parcours des autorisations temporaires");
					    
					    while (itr2.hasNext() && ! trouve) {
						       String str = itr2.next();
						       AutorisationTemporaire autorisation = (AutorisationTemporaire) annuaireAT.get(str);
						       
						       System.out.println("Autorisation récupérée, début du test");
						       
						       Date dateDebut = new Date ((long) autorisation.dateDebut);
						       Date dateFin = new Date ((long) autorisation.dateFin);
						       
						       System.out.println("Il est " + date.toString());
						       System.out.println("L'autorisation mentionne un accès entre " + dateDebut.toString() + " et " + dateFin.toString());
								
						       
						       
						       if (autorisation.idPersonne == ic.idPersonne && date.after(dateDebut) && date.before(dateFin)) {
						    	   System.out.println("L'heure est conforme à l'autorisation");
						    	   trouve = true;
						       }
						}
					    System.out.println("Fin du parcours des autorisations temporaires");
					    
					    
					    if (trouve) {
							System.out.println("Identité confirmée. Bienvenue " + ic.prenomP + " " + ic.nomP);
							
							journalisation.journaliser(idZone, idPorte, photoP, "Autorisé", "Entrée", timestamp, cleAPI);
							msg = "Au revoir " + ic.prenomP + " " + ic.nomP;
					    } else {   	
					    	journalisation.journaliser(idZone, idPorte, photoP, "Refusé", "Entrée", timestamp, cleAPI);
					    	msg = "Sortie refusé";
					    	throw new NonAutorise("Sortie refusée : vous n'avez pas l'autorisation de sortir de cette zone");
					    }
						System.out.println("Journalisation effectuée");
					    
					    
		}catch(ErreurAuthentification e){
			
			System.out.println(e.message);
			try {
				journalisation.journaliser(idZone, idPorte, photoP, "Refusé", "Entrée", timestamp, cleAPI);
			} catch (JournalisationImpossible e1) {
				System.out.println(e1.message);
			}
			throw new ErreurAuthentification(e.message);
			
		}catch(EmpreinteInconnue e){
			
			System.out.println(e.message);
			try {
				journalisation.journaliser(idZone, idPorte, photoP, "Refusé", "Entrée", timestamp, cleAPI);
			} catch (JournalisationImpossible e1) {
				System.out.println(e1.message);
			}
			throw new EmpreinteInconnue(e.message);
			
		}catch(JournalisationImpossible e)
	    {
	    	System.out.println("Erreur : La journalisation n'a pas pu être effectuée");
	    }
	    catch(CleInconnue e)
	    {
	    	System.out.println("Erreur : La clé API est inconnue");
	    }
			
			
		   

		return msg;
	}

}
