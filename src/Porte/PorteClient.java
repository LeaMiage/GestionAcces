package Porte;

import GestionEntreeSortie.Authentification;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.ErreurAuthentification;
import GestionEntreeSortie.GestionSalaries;
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.Journalisation;
import GestionEntreeSortie.PersonneInconnue;
import GestionEntreeSortie.VerificationEmpreinte;

public class PorteClient {


	public static Authentification getServiceAuthentification(String args[]){
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Nom de l'objet CORBA
	        String idObj = "Authentification";

	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object(Utils.Utils.corbaloc));

	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantAuthentification = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantAuthentification));
	        
	        // Casting des objets CORBA
	        GestionEntreeSortie.Authentification authentification = GestionEntreeSortie.AuthentificationHelper.narrow(distantAuthentification);
	       
	        return authentification;
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	

	public static GestionSalaries getServiceGestionSalaries(String args[]){
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Nom de l'objet CORBA
	        String idObj = "GestionSalaries";

	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object(Utils.Utils.corbaloc));

	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantGestionSalaries = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantGestionSalaries));
	        
	        // Casting des objets CORBA
	        GestionEntreeSortie.GestionSalaries gestionSalaries = GestionEntreeSortie.GestionSalariesHelper.narrow(distantGestionSalaries);
	       
	        return gestionSalaries;
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
		
	
	public static Journalisation getServiceJournalisation(String args[]){
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Nom de l'objet CORBA
	        String idObj = "Journalisation";

	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object(Utils.Utils.corbaloc));

	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantJournalisation = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantJournalisation));
	        
	        // Casting des objets CORBA
	        GestionEntreeSortie.Journalisation journalisation = GestionEntreeSortie.JournalisationHelper.narrow(distantJournalisation);
	       
	        return journalisation;
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

	public static VerificationEmpreinte getServiceVerificationEmpreinte(String args[]){
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Nom de l'objet CORBA
	        String idObj = "VerificationEmpreinte";

	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object(Utils.Utils.corbaloc));

	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantVerificationEmpreinte = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantVerificationEmpreinte));
	        
	        // Casting des objets CORBA
	        GestionEntreeSortie.VerificationEmpreinte verificationEmpreinte = GestionEntreeSortie.VerificationEmpreinteHelper.narrow(distantVerificationEmpreinte);
	       
	        return verificationEmpreinte;
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
