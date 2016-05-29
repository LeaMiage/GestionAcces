package GestionnaireEmpreintes;

import GestionEntreeSortie.ChampVide;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.ErreurAuthentification;
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.PersonneExistante;
import GestionEntreeSortie.PersonneInconnue;

public class GestionnaireEmpreinteClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Nom de l'objet CORBA
	        String idObj = "Authentification";

	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
	        
	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantAuthentification = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantAuthentification));
	        
	        // Casting des objets CORBA
	        GestionEntreeSortie.Authentification authentification = GestionEntreeSortie.AuthentificationHelper.narrow(distantAuthentification);
	        	        
	        System.out.println(authentification.authentifierPersonne("photoLea", "cleAPI"));
	        
	        //*****************************************************//
	        
	        // Nom de l'objet CORBA
	        String idObj2 = "GestionEmpreinte";
	        
	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind2 = new org.omg.CosNaming.NameComponent[1];
	        nameToFind2[0] = new org.omg.CosNaming.NameComponent(idObj2,"");
	        
	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantGestionEmpreinte = nameRoot.resolve(nameToFind2);
	        System.out.println("Objet '" + idObj2 + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantGestionEmpreinte));
        
	        // Casting des objets CORBA
	        GestionEntreeSortie.GestionEmpreinte gestionEmpreinte = GestionEntreeSortie.GestionEmpreinteHelper.narrow(distantGestionEmpreinte);
	        //gestionEmpreinte.modifierEmpreinte(7, "empreinteLea", "cleAPI");
	        gestionEmpreinte.supprimerEmpreinte(7, "cleAPI");
	        
		}catch (CleInconnue cleInconnue){
			System.out.println(cleInconnue.message);
		}catch (PersonneInconnue personneInconnue){
			System.out.println(personneInconnue.message);
		}catch (ErreurAuthentification erreurAuthentification){
			System.out.println(erreurAuthentification.message);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
