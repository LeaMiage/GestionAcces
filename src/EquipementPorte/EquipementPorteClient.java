package EquipementPorte;

import GestionEntreeSortie.Authentification;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.EnvoiDonneesCapteurs;
import GestionEntreeSortie.ErreurEnvoi;

public class EquipementPorteClient {

	private int idZone;
	private int idPorte;
	
	public static EnvoiDonneesCapteurs getServiceEnvoiDonneesCapteurs(String args[], int idZone, int idPorte){

		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Nom de l'objet CORBA
	        String idObj = "EnvoiDonneesCapteurs_" + idZone + "_" + idPorte;

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
	
	
	

	public static void main(String[] args) {
		
		String msg;
		
		System.out.println("Test d'accès aux zones");
		
		EnvoiDonneesCapteurs envoiDonnees = getServiceEnvoiDonneesCapteurs(args, Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		
		System.out.println("EnvoiDonneesCapteurs récupéré");
		
		try{
			
			System.out.println("Tentative d'accès à la zone");
			msg = envoiDonnees.accederZone("empreinte", "photoLea", Utils.Utils.cleApi);
			System.out.println("Accès réussi. " + msg);
			
		} catch (CleInconnue e) {
			System.out.println("Erreur : clé inconnue");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ErreurEnvoi e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
}
