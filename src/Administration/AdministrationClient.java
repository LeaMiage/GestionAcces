package Administration;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import org.omg.CORBA.ORBPackage.InvalidName;

import GestionEntreeSortie.Authentification;
import GestionEntreeSortie.AutorisationInconnue;
import GestionEntreeSortie.AutorisationPermanente;
import GestionEntreeSortie.AutorisationTemporaire;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.Collaborateur;
import GestionEntreeSortie.ConsultationJournal;
import GestionEntreeSortie.GestionAutorisation;
import GestionEntreeSortie.GestionSalaries;
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.PersonneInconnue;
import GestionEntreeSortie.Zone;

public class AdministrationClient {

	private int nbZones;
	
	private int nbPortes;
	
	Hashtable<Integer,Zone> listeZones= new Hashtable<Integer, Zone>();
	
	public AdministrationClient(){
		nbZones=0;
		nbPortes=0;
		Hashtable<Integer, Zone> listeZones = new Hashtable<Integer, Zone>();
		initialisation();
		
	}
	
	// Création des zones et affectation des portes
	public void initialisation(){

		listeZones.put(1, new Zone(1,"Zone 1",new int[] {1,2}));
		listeZones.put(2, new Zone(2,"Zone 2",new int[] {3,4}));
		listeZones.put(3, new Zone(3,"Zone 3",new int[] {5,6}));


		
		Helpers.GestionFichiers.ecrireFichier("src/Administration/BD_Zones.txt", listeZones);
		
		System.out.println("Création des zones et affectation des portes effectué");		
	}
	
	public static GestionAutorisation getServiceGestionAutorisations(String args[], int idZone, int idPorte){
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Nom de l'objet CORBA
	        String idObj = "GestionAutorisations_" + idZone + "_" + idPorte;

	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantGestionAutorisations = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantGestionAutorisations));
	        
	        // Casting des objets CORBA
	        GestionEntreeSortie.GestionAutorisation gestionAutorisations = GestionEntreeSortie.GestionAutorisationHelper.narrow(distantGestionAutorisations);
	       
	        return gestionAutorisations;
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public static ConsultationJournal getServiceConsultationJournal(String args[]){
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Nom de l'objet CORBA
	        String idObj = "consultationJournal";

	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantConsultationJournal = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantConsultationJournal));
	        
	        // Casting des objets CORBA
	        GestionEntreeSortie.ConsultationJournal consultationJournal = GestionEntreeSortie.ConsultationJournalHelper.narrow(distantConsultationJournal);
	       
	        return consultationJournal;
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}




	public int getNbZones() {
		return nbZones;
	}


	public void setNbZones(int nbZones) {
		this.nbZones = nbZones;
	}
	
	

	public void ajouterAutorisationPermanente(int idZone, AutorisationPermanente ap){
		
		String [] args = {};
		int idPorte = 0;
		
		Zone z = listeZones.get(idZone);
		
		for(int i=0;i<z.listeIdPortes.length;i++)
		{

			idPorte = z.listeIdPortes[i];
			

			GestionAutorisation gestionAutorisation = getServiceGestionAutorisations(args,idZone,idPorte);
			
			System.out.println("Gestion autorisation de la porte " + idPorte + " récupéré");
			

			try {
				System.out.println("Tentative d'ajout d'autorisation");
				gestionAutorisation.ajouterAutorisationPermanente(ap,Utils.Utils.cleApi);
				System.out.println("Ajout d'autorisation réussie sur la porte "+ idPorte);
			} catch (AutorisationInconnue e) {
				System.out.println("Erreur : Autorisation inconnue");
			} catch (CleInconnue e) {
				System.out.println("Erreur : Cle inconnue");
			}
			
		}
		
		
	}
	
	public void modifierAutorisationPermanente(int idZone, AutorisationPermanente ap, AutorisationPermanente np){
			
	
		String [] args = {};
		int idPorte = 0;
		
		Zone z = listeZones.get(idZone);
		
		for(int i=0;i<z.listeIdPortes.length;i++)
		{
	
			idPorte = z.listeIdPortes[i];
			
			GestionAutorisation gestionAutorisation = getServiceGestionAutorisations(args,idZone,idPorte);
			
			System.out.println("Gestion autorisation récupéré");
			
			
			try {
				System.out.println("Tentative de modification d'autorisation");
				gestionAutorisation.modifierAutorisationPermanente(ap, np,Utils.Utils.cleApi);
				System.out.println("Modification d'autorisation réussie");
			} catch (AutorisationInconnue e) {
				System.out.println("Erreur : Autorisation inconnue");
			} catch (CleInconnue e) {
				System.out.println("Erreur : Cle inconnue");
			}
			
		}
	}
	
	
	public void supprimerAutorisationPermanente(int idZone, AutorisationPermanente ap){
		
		String [] args = {};
		int idPorte = 0;
		
		Zone z = listeZones.get(idZone);
		
		for(int i=0;i<z.listeIdPortes.length;i++)
		{
	
			idPorte = z.listeIdPortes[i];
			
	
			GestionAutorisation gestionAutorisation = getServiceGestionAutorisations(args,idZone,idPorte);
			
			System.out.println("Gestion autorisation de la porte " + idPorte + " récupéré");
			
	
			try {
				System.out.println("Tentative de suppression d'autorisation");
				gestionAutorisation.supprimerAutorisationPermanente(ap,Utils.Utils.cleApi);
				System.out.println("Suppression d'autorisation réussie sur la porte "+ idPorte);
			} catch (AutorisationInconnue e) {
				System.out.println("Erreur : Autorisation inconnue");
			} catch (CleInconnue e) {
				System.out.println("Erreur : Cle inconnue");
			}
			
		}
		
		
	}
		
	
	
	
	public void ajouterAutorisationTemporaire(int idZone, AutorisationTemporaire at){
		
		String [] args = {};
		int idPorte = 0;
		
		Zone z = listeZones.get(idZone);
		
		for(int i=0;i<z.listeIdPortes.length;i++)
		{
	
			idPorte = z.listeIdPortes[i];
			
	
			GestionAutorisation gestionAutorisation = getServiceGestionAutorisations(args,idZone,idPorte);
			
			System.out.println("Gestion autorisation de la porte " + idPorte + " récupéré");
			
	
			try {
				System.out.println("Tentative d'ajout d'autorisation");
				gestionAutorisation.ajouterAutorisationTemporaire(at,Utils.Utils.cleApi);
				System.out.println("Ajout d'autorisation réussie sur la porte "+ idPorte);
			} catch (AutorisationInconnue e) {
				System.out.println("Erreur : Autorisation inconnue");
			} catch (CleInconnue e) {
				System.out.println("Erreur : Cle inconnue");
			}
			
		}
		
		
	}
	
	public void modifierAutorisationTemporaire(int idZone, AutorisationTemporaire at, AutorisationTemporaire at_new){
		
	
		String [] args = {};
		int idPorte = 0;
		
		Zone z = listeZones.get(idZone);
		
		for(int i=0;i<z.listeIdPortes.length;i++)
		{
		
			idPorte = z.listeIdPortes[i];
			
			GestionAutorisation gestionAutorisation = getServiceGestionAutorisations(args,idZone,idPorte);
			
			System.out.println("Gestion autorisation récupéré");
			
			
			try {
				System.out.println("Tentative de modification d'autorisation");
				gestionAutorisation.modifierAutorisationTemporaire(at, at_new,Utils.Utils.cleApi);
				System.out.println("Modification d'autorisation réussie");
			} catch (AutorisationInconnue e) {
				System.out.println("Erreur : Autorisation inconnue");
			} catch (CleInconnue e) {
				System.out.println("Erreur : Cle inconnue");
			}
			
		}
	}


	public void supprimerAutorisationTemporaire(int idZone, AutorisationTemporaire at){
	
		String [] args = {};
		int idPorte = 0;
		
		Zone z = listeZones.get(idZone);
		
		for(int i=0;i<z.listeIdPortes.length;i++)
		{
		
			idPorte = z.listeIdPortes[i];
			
		
			GestionAutorisation gestionAutorisation = getServiceGestionAutorisations(args,idZone,idPorte);
			
			System.out.println("Gestion autorisation de la porte " + idPorte + " récupéré");
			
		
			try {
				System.out.println("Tentative de suppression d'autorisation");
				gestionAutorisation.supprimerAutorisationTemporaire(at,Utils.Utils.cleApi);
				System.out.println("Suppression d'autorisation réussie sur la porte "+ idPorte);
			} catch (AutorisationInconnue e) {
				System.out.println("Erreur : Autorisation inconnue");
			} catch (CleInconnue e) {
				System.out.println("Erreur : Cle inconnue");
			}
			
		}
	
	
	}

	public void gestionAutorisationsPermanentes(){
		
		int numZone, idPersonne;
		String hdeb, hfin, hdeb_new, hfin_new;
		AutorisationPermanente ap, ap_new;
		
		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		while(!str.equals("0"))
		{
			System.out.println("Menu de gestion des autorisations permanentes. Veuillez choisir l'action à réaliser. (0 pour quitter)");
			System.out.println("1. Ajouter une autorisation permanente\n2. Modifier une autorisation permanente\n3. Supprimer une autorisation permanente\n"
								+ "\n");
			
			str = sc.nextLine();
			
			switch (str){
			case "1":
				
				System.out.println("Ajout d'une autorisation permanente");
				
				System.out.println("Entrez le numéro du collaborateur concerné");
				str=sc.nextLine();
				idPersonne = Integer.parseInt(str);
				
				System.out.println("Entrez le numéro de la zone concernée");
				str=sc.nextLine();
				numZone = Integer.parseInt(str);
				
				System.out.println("Entrez l'heure de début de l'autorisation (au format hh:mm)");
				hdeb = sc.nextLine();
				
				System.out.println("Entrez l'heure de fin de l'autorisation (au format hh:mm)");
				hfin = sc.nextLine();
				
				
				ap = new AutorisationPermanente(idPersonne,hdeb,hfin);
				
				
				ajouterAutorisationPermanente(numZone,ap);

				break;
				
				
			case "2":

				System.out.println("Modification d'une autorisation permanente");
				
				System.out.println("Entrez le numéro du collaborateur concerné");
				str=sc.nextLine();
				idPersonne = Integer.parseInt(str);
				
				System.out.println("Entrez le numéro de la zone concernée");
				str=sc.nextLine();
				numZone = Integer.parseInt(str);
				
				System.out.println("Entrez l'ancienne heure de début de l'autorisation (au format hh:mm)");
				hdeb = sc.nextLine();
				
				System.out.println("Entrez l'ancienne heure de fin de l'autorisation (au format hh:mm)");
				hfin = sc.nextLine();
				
				System.out.println("Entrez la nouvelle heure de début de l'autorisation (au format hh:mm)");
				hdeb_new = sc.nextLine();
				
				System.out.println("Entrez la nouvelle heure de fin de l'autorisation (au format hh:mm)");
				hfin_new = sc.nextLine();
				

				ap = new AutorisationPermanente(idPersonne,hdeb,hfin);
				ap_new = new AutorisationPermanente(idPersonne,hdeb_new,hfin_new);
				
				modifierAutorisationPermanente(numZone,ap,ap_new);
				
				
				
				break;
				
			case "3":


				System.out.println("Suppression d'une autorisation permanente");
				
				System.out.println("Entrez le numéro du collaborateur concerné");
				str=sc.nextLine();
				idPersonne = Integer.parseInt(str);
				
				System.out.println("Entrez le numéro de la zone concernée");
				str=sc.nextLine();
				numZone = Integer.parseInt(str);
				
				System.out.println("Entrez l'heure de début de l'autorisation (au format hh:mm)");
				hdeb = sc.nextLine();
				
				System.out.println("Entrez l'heure de fin de l'autorisation (au format hh:mm)");
				hfin = sc.nextLine();
				
				
				ap = new AutorisationPermanente(idPersonne,hdeb,hfin);
				
				
				supprimerAutorisationPermanente(numZone,ap);
				
				
				break;

				
			default:
				break;
			}
		}
	}
	
	public void gestionAutorisationsTemporaires() throws ParseException{
		

		int numZone, idPersonne;
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Calendar c = Calendar.getInstance();
		String res;
		long timestamp_deb, timestamp_fin, timestamp_deb_new, timestamp_fin_new;
		AutorisationTemporaire at, at_new;
		
		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		while(!str.equals("0"))
		{
			System.out.println("Menu de gestion des autorisations temporaire. Veuillez choisir l'action à réaliser. (0 pour quitter)");
			System.out.println("1. Ajouter une autorisation temporaire\n2. Modifier une autorisation temporaire\n3. Supprimer une autorisation temporaire\n"
								+ "4. \n");
			
			str = sc.nextLine();
			
			switch (str){
			case "1":
				
				System.out.println("Ajout d'une autorisation temporaire");
				
				System.out.println("Entrez le numéro du collaborateur concerné");
				str=sc.nextLine();
				idPersonne = Integer.parseInt(str);
				
				System.out.println("Entrez le numéro de la zone concernée");
				str=sc.nextLine();
				numZone = Integer.parseInt(str);
				
				System.out.println("Entrez la date et l'heure de début de l'autorisation (au format jj-mm-aaaa hh:mm)");
				res = sc.nextLine();
			    c.setTime(df.parse(res));
			    timestamp_deb = c.getTimeInMillis();
				
				System.out.println("Entrez la date et l'heure de fin de l'autorisation (au format jj-mm-aaaa hh:mm)");
				res = sc.nextLine();
				c.setTime(df.parse(res));
			    timestamp_fin = c.getTimeInMillis();

				at = new AutorisationTemporaire(idPersonne, timestamp_deb, timestamp_fin);

				ajouterAutorisationTemporaire(numZone,at);

				break;
				
				
			case "2":

				System.out.println("Modification d'une autorisation temporaire");
				
				System.out.println("Entrez le numéro du collaborateur concerné");
				str=sc.nextLine();
				idPersonne = Integer.parseInt(str);
				
				System.out.println("Entrez le numéro de la zone concernée");
				str=sc.nextLine();
				numZone = Integer.parseInt(str);
				
				System.out.println("Entrez l'ancienne date et heure de début de l'autorisation (au format jj-mm-aaaa hh:mm)");
				res = sc.nextLine();
				c.setTime(df.parse(res));
			    timestamp_deb = c.getTimeInMillis();
				
				System.out.println("Entrez l'ancienne date et heure de fin de l'autorisation (au format jj-mm-aaaa hh:mm)");
				res = sc.nextLine();
				c.setTime(df.parse(res));
			    timestamp_fin = c.getTimeInMillis();
				
				System.out.println("Entrez la nouvelle date et heure de début de l'autorisation (au format jj-mm-aaaa hh:mm)");
				res = sc.nextLine();
			    c.setTime(df.parse(res));
			    timestamp_deb_new = c.getTimeInMillis();
				
				System.out.println("Entrez la nouvelle date et heure de fin de l'autorisation (au format jj-mm-aaaa hh:mm)");
				res = sc.nextLine();
				c.setTime(df.parse(res));
			    timestamp_fin_new = c.getTimeInMillis();


				at = new AutorisationTemporaire(idPersonne,timestamp_deb,timestamp_fin);
				at_new = new AutorisationTemporaire(idPersonne,timestamp_deb_new,timestamp_fin_new);
				
				modifierAutorisationTemporaire(numZone,at,at_new);
				
				
				
				break;
				
			case "3":

				System.out.println("Suppression d'une autorisation temporaire");
				
				System.out.println("Entrez le numéro du collaborateur concerné");
				str=sc.nextLine();
				idPersonne = Integer.parseInt(str);
				
				System.out.println("Entrez le numéro de la zone concernée");
				str=sc.nextLine();
				numZone = Integer.parseInt(str);
				
				System.out.println("Entrez la date et l'heure de début de l'autorisation (au format jj-mm-aaaa hh:mm)");
				res = sc.nextLine();
				c.setTime(df.parse(res));
			    timestamp_deb = c.getTimeInMillis();
				
				System.out.println("Entrez la date et l'heure de fin de l'autorisation (au format jj-mm-aaaa hh:mm)");
				res = sc.nextLine();
				c.setTime(df.parse(res));
			    timestamp_fin = c.getTimeInMillis();

				at = new AutorisationTemporaire(idPersonne,timestamp_deb,timestamp_fin);
				
				
				supprimerAutorisationTemporaire(numZone,at);
				
				
				break;

				
			default:
				break;
			}
		}
		
	}
		
	public void menuAdmin() {
		
		// Main de l'admin

		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		while(!str.equals("0"))
		{
			
			System.out.println("Bienvenue sur le menu Administrateur. Veuillez choisir l'action à réaliser. (0 pour quitter)");
			
			System.out.println("1. Gérer les autorisations permanentes\n2. Gérer les autorisations temporaires\n");
			
			str = sc.nextLine();
			
			switch (str){
			case "1":
				gestionAutorisationsPermanentes();
				
				break;
			case "2":
				try {
					gestionAutorisationsTemporaires();
				} catch (ParseException e) {
					System.out.println("Erreur : format non respecté\n");
				}
				
				break;

				
			default:
				System.out.println(str);
				break;
			}
			

		}
		
		
	}

	
	
	public static void main(String[] args) {
		
		AdministrationClient admin = new AdministrationClient();
		
		admin.menuAdmin();
		
		
	}
	
	
	
}
