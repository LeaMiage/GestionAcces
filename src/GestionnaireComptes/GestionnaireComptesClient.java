package GestionnaireComptes;

import java.util.Scanner;

import GestionEntreeSortie.Authentification;
import GestionEntreeSortie.ChampVide;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.CreationCompte;
import GestionEntreeSortie.ErreurAuthentification;
import GestionEntreeSortie.GestionEmpreinte;
import GestionEntreeSortie.GestionSalaries;
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.PersonneExistante;
import GestionEntreeSortie.PersonneInconnue;
import GestionnaireEmpreintes.GestionnaireEmpreinteClient;

public class GestionnaireComptesClient {

	public static CreationCompte getCreationCompte(String args[]){
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
	        
	        return creationCompte;
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static GestionSalaries getGestionSalaries(String args[]){
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

			// Nom de l'objet CORBA
	        String idObj2 = "GestionSalaries";
	        
	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind2 = new org.omg.CosNaming.NameComponent[1];
	        nameToFind2[0] = new org.omg.CosNaming.NameComponent(idObj2,"");
	        
	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

	        
	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantGestionSalaries = nameRoot.resolve(nameToFind2);
	        System.out.println("Objet '" + idObj2 + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantGestionSalaries));
        
	        // Casting des objets CORBA
	        GestionEntreeSortie.GestionSalaries gestionSalaries = GestionEntreeSortie.GestionSalariesHelper.narrow(distantGestionSalaries);
	        
	        return gestionSalaries;
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static GestionEmpreinte getServiceGestionEmpreinte(String args[]){
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

			 // Nom de l'objet CORBA
	        String idObj3 = "GestionEmpreinte";
	        
	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind3 = new org.omg.CosNaming.NameComponent[1];
	        nameToFind3[0] = new org.omg.CosNaming.NameComponent(idObj3,"");
	        
	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
	        
	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantGestionEmpreinte = nameRoot.resolve(nameToFind3);
	        System.out.println("Objet '" + idObj3 + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantGestionEmpreinte));
        
	        // Casting des objets CORBA
	        GestionEntreeSortie.GestionEmpreinte gestionEmpreinte = GestionEntreeSortie.GestionEmpreinteHelper.narrow(distantGestionEmpreinte);
	        
	        return gestionEmpreinte;
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void creerCP(String nomP, String prenomP, String mdp, String photoP) throws CleInconnue, PersonneExistante, ChampVide{
		String [] args = {};
		CreationCompte creationCompte = GestionnaireComptesClient.getCreationCompte(args);
		creationCompte.creerCP(nomP, prenomP, mdp, photoP, Utils.Utils.cleApi);
	}
	public void creerCT(String nomP, String prenomP, String mdp, String photoP) throws CleInconnue, PersonneExistante, ChampVide{
		String [] args = {};
		CreationCompte creationCompte = GestionnaireComptesClient.getCreationCompte(args);
		creationCompte.creerCT(nomP, prenomP, mdp, photoP, Utils.Utils.cleApi);
	}
	public void rechercherSalarie(int idPersonne) throws PersonneInconnue, CleInconnue{
		String [] args = {};
		GestionSalaries gestionSalarie = GestionnaireComptesClient.getGestionSalaries(args);
		gestionSalarie.rechercherSalarie(idPersonne, Utils.Utils.cleApi);
	}	
	public void verifierPersonne(int idPersonne) throws PersonneInconnue, CleInconnue{
		String [] args = {};
		GestionSalaries gestionSalarie = GestionnaireComptesClient.getGestionSalaries(args);
		gestionSalarie.verifierPersonne(idPersonne, Utils.Utils.cleApi);
	}
	public void supprimerEmpreinte(int idPersonne) throws PersonneInconnue, CleInconnue{
		String [] args = {};
		GestionEmpreinte gestionEmpreinte = GestionnaireComptesClient.getServiceGestionEmpreinte(args);
		gestionEmpreinte.supprimerEmpreinte(idPersonne, Utils.Utils.cleApi);
		
	}
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
	
public void menuPrincipal() {
		
		int idPersonne;
		String mdp;
		
		// Main du gestionnaire d'empreinte

		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		while(!str.equals("0"))
		{
			
			System.out.println("Bienvenue sur le menu Gestionnaire de Comptes (Accueil). Veuillez vous authentifier pour gérer votre empreinte. (0 pour quitter)");
			
			System.out.println("1. Créer compte temporaire\n2. Supprimer une empreinte\n");
			
			str = sc.nextLine();
			
			/*switch (str){
			case "1":
				System.out.println("Entrez votre identifiant");
				str=sc.nextLine();
				idPersonne = Integer.parseInt(str);
				
				System.out.println("Entrez votre mot de passe");
				str=sc.nextLine();
				mdp = str;
				System.out.println("\n");
				try {
					authentifierCompte(idPersonne, mdp);
					menuGestionnaireEmpreinte(idPersonne);
				} catch (ErreurAuthentification erreurAuthentification) {
					System.out.println(erreurAuthentification.message);
					str = "1";
				} catch (CleInconnue cleInconnue) {
					System.out.println(cleInconnue.message);
					str = "0";
				}				
				break;
				
			default:
				System.out.println(str);
				break;
			}
		*/	
		}
		System.out.println("\nA bientôt");
	}
}
