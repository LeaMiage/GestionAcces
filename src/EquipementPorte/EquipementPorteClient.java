package EquipementPorte;

import GestionEntreeSortie.Authentification;
import GestionEntreeSortie.EnvoiDonneesCapteurs;

public class EquipementPorteClient {


	public static EnvoiDonneesCapteurs getServiceEnvoiDonneesCapteurs(String args[]){
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Nom de l'objet CORBA
	        String idObj = "envoiDonneesCapteurs";

	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantEnvoiDonneesCapteurs = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantEnvoiDonneesCapteurs));
	        
	        // Casting des objets CORBA
	        GestionEntreeSortie.EnvoiDonneesCapteurs envoiDonneesCapteurs = GestionEntreeSortie.EnvoiDonneesCapteursHelper.narrow(distantEnvoiDonneesCapteurs);
	       
	        return envoiDonneesCapteurs;
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
