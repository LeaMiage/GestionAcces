package GestionnaireComptes;

import GestionEntreeSortie.ChampVide;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.PersonneExistante;
import GestionEntreeSortie.PersonneInconnue;

public class GestionnaireComptesClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Nom de l'objet CORBA
	        String idObj = "CreationCompte";

	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantCreationCompte = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantCreationCompte));
	        
	        // Casting des objets CORBA
	        GestionEntreeSortie.CreationCompte creationCompte = GestionEntreeSortie.CreationCompteHelper.narrow(distantCreationCompte);
	        
	        /*
	        System.out.println(creationCompte.creerCP("Chéoux", "Léa", "photoLea", "lcheoux", Utils.Utils.cleApi));
	        System.out.println(creationCompte.creerCP("Chevalier", "Théo", "photoTheo", "tchevalier", Utils.Utils.cleApi));
	        System.out.println(creationCompte.creerCP("Movia", "Bastien", "photoBastien", "bmovia", Utils.Utils.cleApi));			
	        */
	        
	        //*****************************************************//
	        
	        // Nom de l'objet CORBA
	        String idObj2 = "GestionSalaries";
	        
	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind2 = new org.omg.CosNaming.NameComponent[1];
	        nameToFind2[0] = new org.omg.CosNaming.NameComponent(idObj2,"");
	        
	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantGestionSalaries = nameRoot.resolve(nameToFind2);
	        System.out.println("Objet '" + idObj2 + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantGestionSalaries));
        
	        // Casting des objets CORBA
	        GestionEntreeSortie.GestionSalaries gestionSalaries = GestionEntreeSortie.GestionSalariesHelper.narrow(distantGestionSalaries);
	        
	        /*IdentiteCollaborateur ic = gestionSalaries.rechercherSalarie(3, Utils.Utils.cleApi);
	        System.out.println(ic.idPersonne + " " + ic.nomP + " " + ic.prenomP); 
	        */
	        //*****************************************************//
	        
	        // Nom de l'objet CORBA
	        String idObj3 = "GestionEmpreinte";
	        
	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind3 = new org.omg.CosNaming.NameComponent[1];
	        nameToFind3[0] = new org.omg.CosNaming.NameComponent(idObj3,"");
	        
	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantGestionEmpreinte = nameRoot.resolve(nameToFind3);
	        System.out.println("Objet '" + idObj3 + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantGestionEmpreinte));
        
	        // Casting des objets CORBA
	        GestionEntreeSortie.GestionEmpreinte gestionEmpreinte = GestionEntreeSortie.GestionEmpreinteHelper.narrow(distantGestionEmpreinte);
	        
	        gestionEmpreinte.modifierEmpreinte(0, "empreinte", Utils.Utils.cleApi);
	        
		}catch (CleInconnue cleInconnue){
			System.out.println(cleInconnue.message);
		}catch (ChampVide champVide) {
			System.out.println(champVide.message);
		}catch (PersonneInconnue personneInconnue){
			System.out.println(personneInconnue.message);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
