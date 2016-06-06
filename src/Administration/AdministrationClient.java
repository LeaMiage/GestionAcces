package Administration;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

import org.omg.CORBA.ORBPackage.InvalidName;

import GestionEntreeSortie.Authentification;
import GestionEntreeSortie.AutorisationInconnue;
import GestionEntreeSortie.AutorisationPermanente;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.ConsultationJournal;
import GestionEntreeSortie.GestionAutorisation;
import GestionEntreeSortie.GestionSalaries;
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.PersonneInconnue;

public class AdministrationClient {

	private long nbZones = 0;
	
	private long nbPortes = 0;
	
	private Hashtable<Long,Zone> listeZones;	
	
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


	public long ajouterZone(){
		
		nbZones++;
		Zone z = new Zone(nbZones);
		listeZones.put(nbZones, z);
		
		return nbZones;
	}
	
	public void supprimerZone(long idZone){
		listeZones.remove(idZone);
		nbZones--;
	}

	public long getNbZones() {
		return nbZones;
	}


	public void setNbZones(long nbZones) {
		this.nbZones = nbZones;
	}
	
	
	public long ajouterPorte(long idZone){
		
		nbPortes++;
		
		Zone z = listeZones.get(idZone);
		z.ajouterPorte(nbPortes);
		
		return nbPortes;
	}


	public void ajouterAutorisationPermanente(int idPersonne, int idZone, AutorisationPermanente ap){
		
		String [] args = {};
		int idPorte = 0;
		
		Zone z = listeZones.get(idZone);
		
		Iterator it = z.getListePortes().iterator();

		while(it.hasNext())
		{
			
			idPorte = (int) it.next();

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
	
public void modifierAutorisationPermanente(int idPersonne, int idZone, AutorisationPermanente ap, AutorisationPermanente np){
		
		String [] args = {};
		
		
		GestionAutorisation gestionAutorisation = getServiceGestionAutorisations(args,idZone);
		
		System.out.println("Gestion autorisation récupéré");
		
		
		try {
			System.out.println("Tentative de modification d'autorisation");
			gestionAutorisation.modifierAutorisationPermanente(ap, np,"cleAPI");
			System.out.println("Ajout d'autorisation réussie");
		} catch (AutorisationInconnue e) {
			System.out.println("Erreur : Autorisation inconnue");
		} catch (CleInconnue e) {
			System.out.println("Erreur : Cle inconnue");
		}
		
	}
	
	
	public void gestionZones(){
		

		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		
		while(str!= "0")
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
		
		
		while(str!= "0")
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
				
				if(listeZones.containsKey(Long.parseLong(str)))
					System.out.println("Ajout de la porte " + ajouterPorte(Long.parseLong(str)) + " dans la zone " + Long.parseLong(str) + " effectué");
				
				else
					System.out.println("Erreur : cette zone n'existe pas");
								
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
	
	public void gestionAutorisationsPermanentes(){
		
		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		while(str != "0")
		{
			System.out.println("Menu de gestion des autorisations permanentes. Veuillez choisir l'action à réaliser. (0 pour quitter)");
			System.out.println("1. Ajouter une autorisation permanente\n2. Modifier une autorisation permanente\n3. Supprimer une autorisation permanente\n"
								+ "4. ");
			
			str = sc.nextLine();
			
			switch (str){
			case "1":
				
				System.out.println("Entrez le numéro du collaborateur concerné");
				str=sc.nextLine();
				Integer idPersonne = Integer.parseInt(str);
				
				System.out.println("Entrez le numéro de la zone concernée");
				str=sc.nextLine();
				Integer numZone = Integer.parseInt(str);
				
				System.out.println("Entrez l'heure de début de l'autorisation");
				String hdeb = sc.nextLine();
				
				System.out.println("Entrez l'heure de fin de l'autorisation");
				String hfin = sc.nextLine();
				
				
				AutorisationPermanente ap = new AutorisationPermanente(idPersonne,hdeb,hfin);
				
				
				ajouterAutorisationPermanente(idPersonne,numZone,ap);
				
				
				
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
	
	public void gestionAutorisationsTemporaires(){
		
	}
		
	public void menuAdmin() {
		
		// Main de l'admin

		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		while(str != "0")
		{
			System.out.println(str);
			
			System.out.println("Bienvenue sur le menu Administrateur. Veuillez choisir l'action à réaliser. (autre nombre pour quitter)");
			
			System.out.println("1. Gérer les zones\n2. Gérer les portes\n3. Gérer les autorisations permanentes\n"
								+ "4. Gérer les autorisations temporaires");
			
			str = sc.nextLine();
			
			switch (str){
			case "1":
				gestionZones();
				
				break;
			case "2":
				gestionPortes();
				
				break;
				
			case "3":
				gestionAutorisationsPermanentes();
				
				break;	
				
			case "4":
				gestionAutorisationsTemporaires();
				
				break;
				
			case "0":
				str="0";
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
