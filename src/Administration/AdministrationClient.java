package Administration;

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



	public static GestionAutorisation getServiceGestionAutorisations(String args[]){
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Nom de l'objet CORBA
	        String idObj = "GestionAutorisations";

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

	

	public static void main(String[] args) {
		
		// Main de l'admin
		
		System.out.println("Test Admin");
		
		GestionAutorisation gestionAutorisation = getServiceGestionAutorisations(args);
		
		System.out.println("Gestion autorisation récupéré");
		
		
		try {
			System.out.println("Tentative d'ajout d'autorisation");
			AutorisationPermanente ap = new AutorisationPermanente(0,"08h00","18h00");
			gestionAutorisation.ajouterAutorisationPermanente(ap,"cleAPI");
			System.out.println("Ajout d'autorisation réussie");
		} catch (AutorisationInconnue e) {
			System.out.println("Autorisation inconnue");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CleInconnue e) {
			System.out.println("cle inconnue inconnue");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
}
