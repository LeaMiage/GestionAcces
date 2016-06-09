package Administration;

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

	private long nbZones;
	
	private long nbPortes;
	
	Hashtable<Long,Zone> listeZones= new Hashtable<Long, Zone>();
	
	public AdministrationClient(){
		nbZones=0;
		nbPortes=0;
		Hashtable<Long, Zone> listeZones = new Hashtable<Long, Zone>();
		initialisation();
		
	}
	
	// Création des zones et affectation des portes
	public void initialisation(){

		listeZones.put((long) 1, new Zone(1,"Zone 1",new int[] {1,2}));
		listeZones.put((long) 2, new Zone(2,"Zone 2",new int[] {3,4}));
		listeZones.put((long) 3, new Zone(3,"Zone 3",new int[] {5,6}));


		
		Helpers.GestionFichiers.ecrireFichier("src/Administration/BD_Zones.txt", listeZones);
		
		System.out.println("Création des zones et affectation des portes effectué");		
	}
	
	public static GestionAutorisation getServiceGestionAutorisations(String args[], long idPorte){
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Nom de l'objet CORBA
	        String idObj = "GestionAutorisations" + idPorte;

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




	public long getNbZones() {
		return nbZones;
	}


	public void setNbZones(long nbZones) {
		this.nbZones = nbZones;
	}
	
	

	public void ajouterAutorisationPermanente(long idZone, AutorisationPermanente ap){
		
		String [] args = {};
		long idPorte = 0;
		
		Zone z = listeZones.get(idZone);
		
		for(int i=0;i<z.listeIdPortes.length;i++)
		{

			idPorte = z.listeIdPortes[i];
			

			GestionAutorisation gestionAutorisation = getServiceGestionAutorisations(args,idPorte);
			
			System.out.println("Gestion autorisation de la porte " + idPorte + " récupéré");
			

			try {
				System.out.println("Tentative d'ajout d'autorisation");
				gestionAutorisation.ajouterAutorisationPermanente(ap,"cleAPI");
				System.out.println("Ajout d'autorisation réussie sur la porte "+ idPorte);
			} catch (AutorisationInconnue e) {
				System.out.println("Erreur : Autorisation inconnue");
			} catch (CleInconnue e) {
				System.out.println("Erreur : Cle inconnue");
			}
			
		}
		
		
	}
	
public void modifierAutorisationPermanente(long idZone, AutorisationPermanente ap, AutorisationPermanente np){
		

	String [] args = {};
	long idPorte = 0;
	
	Zone z = listeZones.get(idZone);
	
	for(int i=0;i<z.listeIdPortes.length;i++)
	{

		idPorte = z.listeIdPortes[i];
		
		GestionAutorisation gestionAutorisation = getServiceGestionAutorisations(args,idZone);
		
		System.out.println("Gestion autorisation récupéré");
		
		
		try {
			System.out.println("Tentative de modification d'autorisation");
			gestionAutorisation.modifierAutorisationPermanente(ap, np,"cleAPI");
			System.out.println("Modification d'autorisation réussie");
		} catch (AutorisationInconnue e) {
			System.out.println("Erreur : Autorisation inconnue");
		} catch (CleInconnue e) {
			System.out.println("Erreur : Cle inconnue");
		}
		
	}
}


public void supprimerAutorisationPermanente(long idZone, AutorisationPermanente ap){
	
	String [] args = {};
	long idPorte = 0;
	
	Zone z = listeZones.get(idZone);
	
	for(int i=0;i<z.listeIdPortes.length;i++)
	{

		idPorte = z.listeIdPortes[i];
		

		GestionAutorisation gestionAutorisation = getServiceGestionAutorisations(args,idPorte);
		
		System.out.println("Gestion autorisation de la porte " + idPorte + " récupéré");
		

		try {
			System.out.println("Tentative de suppression d'autorisation");
			gestionAutorisation.supprimerAutorisationPermanente(ap,"cleAPI");
			System.out.println("Suppression d'autorisation réussie sur la porte "+ idPorte);
		} catch (AutorisationInconnue e) {
			System.out.println("Erreur : Autorisation inconnue");
		} catch (CleInconnue e) {
			System.out.println("Erreur : Cle inconnue");
		}
		
	}
	
	
}
	



public void ajouterAutorisationTemporaire(long idZone, AutorisationTemporaire at){
	
	String [] args = {};
	long idPorte = 0;
	
	Zone z = listeZones.get(idZone);
	
	for(int i=0;i<z.listeIdPortes.length;i++)
	{

		idPorte = z.listeIdPortes[i];
		

		GestionAutorisation gestionAutorisation = getServiceGestionAutorisations(args,idPorte);
		
		System.out.println("Gestion autorisation de la porte " + idPorte + " récupéré");
		

		try {
			System.out.println("Tentative d'ajout d'autorisation");
			gestionAutorisation.ajouterAutorisationTemporaire(at,"cleAPI");
			System.out.println("Ajout d'autorisation réussie sur la porte "+ idPorte);
		} catch (AutorisationInconnue e) {
			System.out.println("Erreur : Autorisation inconnue");
		} catch (CleInconnue e) {
			System.out.println("Erreur : Cle inconnue");
		}
		
	}
	
	
}

public void modifierAutorisationTemporaire(long idZone, AutorisationTemporaire at, AutorisationTemporaire at_new){
	

String [] args = {};
long idPorte = 0;

Zone z = listeZones.get(idZone);

for(int i=0;i<z.listeIdPortes.length;i++)
{

	idPorte = z.listeIdPortes[i];
	
	GestionAutorisation gestionAutorisation = getServiceGestionAutorisations(args,idZone);
	
	System.out.println("Gestion autorisation récupéré");
	
	
	try {
		System.out.println("Tentative de modification d'autorisation");
		gestionAutorisation.modifierAutorisationTemporaire(at, at_new,"cleAPI");
		System.out.println("Modification d'autorisation réussie");
	} catch (AutorisationInconnue e) {
		System.out.println("Erreur : Autorisation inconnue");
	} catch (CleInconnue e) {
		System.out.println("Erreur : Cle inconnue");
	}
	
}
}


public void supprimerAutorisationTemporaire(long idZone, AutorisationTemporaire at){

String [] args = {};
long idPorte = 0;

Zone z = listeZones.get(idZone);

for(int i=0;i<z.listeIdPortes.length;i++)
{

	idPorte = z.listeIdPortes[i];
	

	GestionAutorisation gestionAutorisation = getServiceGestionAutorisations(args,idPorte);
	
	System.out.println("Gestion autorisation de la porte " + idPorte + " récupéré");
	

	try {
		System.out.println("Tentative de suppression d'autorisation");
		gestionAutorisation.supprimerAutorisationTemporaire(at,"cleAPI");
		System.out.println("Suppression d'autorisation réussie sur la porte "+ idPorte);
	} catch (AutorisationInconnue e) {
		System.out.println("Erreur : Autorisation inconnue");
	} catch (CleInconnue e) {
		System.out.println("Erreur : Cle inconnue");
	}
	
}


}
	/*
	public void gestionZones(){
		

		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		
		while(!str.equals("0"))
		{
			System.out.println("Menu de gestion des zones. Veuillez choisir l'action à réaliser. (0 pour quitter)");
			System.out.println("1. Ajouter une zone\n2. Supprimer une zone\n3. Afficher le nombre de zones\n"
					+ "4. ");
			
			str = sc.nextLine();
			
			switch (str){
			case "1":				
				System.out.println("Ajout de la zone " + ajouterZone() + " effectué");
				
				break;
			case "2":
				System.out.println("Entrez le numéro de la zone à supprimer");
				sc= new Scanner(System.in);
				str=sc.nextLine();
				
				if(listeZones.containsKey(Long.parseLong(str)))
					supprimerZone(Long.parseLong(str));
				else
					System.out.println("Erreur : cette zone n'existe pas");
				break;
				
			case "3":
				System.out.println("Nombre de zones actuel : " + getNbZones());
				
				break;
				
			case "0":
				str="0";
				break;
				
			default:
				break;
			}
			

			
			
		}
	}

	public void gestionPortes(){


		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		
		while(!str.equals("0"))
		{
			System.out.println("Menu de gestion des portes. Veuillez choisir l'action à réaliser. (0 pour quitter)");

			System.out.println("1. Ajouter une porte\n2. Supprimer une porte\n3. \n"
								+ "4. ");
			str = sc.nextLine();
			switch (str){
			case "1":
				System.out.println("Entrez le numéro de la zone où ajouter la porte");
				sc= new Scanner(System.in);
				str=sc.nextLine();
		
				break;
				
				
			case "2":
				
				break;
				
			case "3":

				break;
				
			case "0":
				str="0";
				break;
				
			default:
				break;
			}
			

		}
		}
	*/

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
				
				System.out.println("Entrez l'heure de début de l'autorisation");
				hdeb = sc.nextLine();
				
				System.out.println("Entrez l'heure de fin de l'autorisation");
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
				
				System.out.println("Entrez l'ancienne heure de début de l'autorisation");
				hdeb = sc.nextLine();
				
				System.out.println("Entrez l'ancienne heure de fin de l'autorisation");
				hfin = sc.nextLine();
				
				System.out.println("Entrez la nouvelle heure de début de l'autorisation");
				hdeb_new = sc.nextLine();
				
				System.out.println("Entrez la nouvelle heure de fin de l'autorisation");
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
				
				System.out.println("Entrez l'heure de début de l'autorisation");
				hdeb = sc.nextLine();
				
				System.out.println("Entrez l'heure de fin de l'autorisation");
				hfin = sc.nextLine();
				
				
				ap = new AutorisationPermanente(idPersonne,hdeb,hfin);
				
				
				supprimerAutorisationPermanente(numZone,ap);
				
				
				break;

				
			default:
				break;
			}
		}
	}
	
	public void gestionAutorisationsTemporaires(){
		

		int numZone, idPersonne;
		String hdeb, hfin, hdeb_new, hfin_new, datedeb, datefin, datedeb_new, datefin_new;
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
				
				System.out.println("Entrez l'heure de début de l'autorisation");
				hdeb = sc.nextLine();
				
				System.out.println("Entrez l'heure de fin de l'autorisation");
				hfin = sc.nextLine();
				
				System.out.println("Entrez la date de début de l'autorisation");
				datedeb = sc.nextLine();
				
				System.out.println("Entrez la date de fin de l'autorisation");
				datefin = sc.nextLine();
				
				at = new AutorisationTemporaire(idPersonne,hdeb,hfin,datedeb,datefin);
				
				
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
				
				System.out.println("Entrez l'ancienne heure de début de l'autorisation");
				hdeb = sc.nextLine();
				
				System.out.println("Entrez l'ancienne heure de fin de l'autorisation");
				hfin = sc.nextLine();
				
				System.out.println("Entrez l'ancienne date de début de l'autorisation");
				datedeb = sc.nextLine();
				
				System.out.println("Entrez l'ancienne date de fin de l'autorisation");
				datefin = sc.nextLine();
				
				System.out.println("Entrez la nouvelle heure de début de l'autorisation");
				hdeb_new = sc.nextLine();
				
				System.out.println("Entrez la nouvelle heure de fin de l'autorisation");
				hfin_new = sc.nextLine();
				
				System.out.println("Entrez la nouvelle date de début de l'autorisation");
				datedeb_new = sc.nextLine();
				
				System.out.println("Entrez la nouvelle date de fin de l'autorisation");
				datefin_new = sc.nextLine();
				

				at = new AutorisationTemporaire(idPersonne,hdeb,hfin,datedeb,datefin);
				at_new = new AutorisationTemporaire(idPersonne,hdeb_new,hfin_new,datedeb_new,datefin_new);
				
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
				
				System.out.println("Entrez l'heure de début de l'autorisation");
				hdeb = sc.nextLine();
				
				System.out.println("Entrez l'heure de fin de l'autorisation");
				hfin = sc.nextLine();
				
				System.out.println("Entrez la date de début de l'autorisation");
				datedeb = sc.nextLine();
				
				System.out.println("Entrez la date de fin de l'autorisation");
				datefin = sc.nextLine();
				
				at = new AutorisationTemporaire(idPersonne,hdeb,hfin,datedeb,datefin);
				
				
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
				gestionAutorisationsTemporaires();
				
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
