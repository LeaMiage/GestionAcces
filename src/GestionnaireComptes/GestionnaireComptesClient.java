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
        
	        // Casting des objets CORBA
	        GestionEntreeSortie.GestionEmpreinte gestionEmpreinte = GestionEntreeSortie.GestionEmpreinteHelper.narrow(distantGestionEmpreinte);
	        
	        return gestionEmpreinte;
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int creerCP(String nomP, String prenomP, String mdp, String photoP) throws CleInconnue, PersonneExistante, ChampVide{
		int idP=-1;
		String [] args = {};
		CreationCompte creationCompte = GestionnaireComptesClient.getCreationCompte(args);
		idP = creationCompte.creerCP(nomP, prenomP, mdp, photoP, Utils.Utils.cleApi);
		
		return idP;
	}
	public int creerCT(String nomP, String prenomP, String mdp, String photoP) throws CleInconnue, PersonneExistante, ChampVide{
		int idP=-1;
		String [] args = {};
		CreationCompte creationCompte = GestionnaireComptesClient.getCreationCompte(args);
		idP = creationCompte.creerCT(nomP, prenomP, mdp, photoP, Utils.Utils.cleApi);
		return idP;
	}
	public IdentiteCollaborateur rechercherSalarie(int idPersonne) throws PersonneInconnue, CleInconnue{
		String [] args = {};
		GestionSalaries gestionSalarie = GestionnaireComptesClient.getGestionSalaries(args);
		IdentiteCollaborateur identite = gestionSalarie.rechercherSalarie(idPersonne, Utils.Utils.cleApi);
		return identite;
	}	
	//type = 1 pour temporaire
	public int verifierPersonne(int idPersonne) throws PersonneInconnue, CleInconnue{
		String [] args = {};
		int type = -1;
		GestionSalaries gestionSalarie = GestionnaireComptesClient.getGestionSalaries(args);
		type = gestionSalarie.verifierPersonne(idPersonne, Utils.Utils.cleApi);
		return type;
	}
	public void supprimerEmpreinte(int idPersonne) throws PersonneInconnue, CleInconnue{
		String [] args = {};
		GestionEmpreinte gestionEmpreinte = GestionnaireComptesClient.getServiceGestionEmpreinte(args);
		gestionEmpreinte.supprimerEmpreinte(idPersonne, Utils.Utils.cleApi);
		
	}
	
	
	public void menuPrincipal(String[] args) {
		
		IdentiteCollaborateur identite;
		String nomP, prenomP, mdp, photoP;
		int idPersonne;
		// Main du gestionnaire d'empreinte

		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		if (args[0].equals("Accueil")) {
			while(!str.equals("0"))
			{
				System.out.println("\n");
				System.out.println("Bienvenue sur le menu Gestionnaire de Comptes (Accueil). Veuillez choisir l'action à réaliser. (0 pour quitter)");
				
				System.out.println("1. Créer compte temporaire\n2. Supprimer une empreinte\n");
				
				str = sc.nextLine();
				
				switch (str){
				case "1":
					System.out.println("Nom du collaborateur");
					str=sc.nextLine();
					nomP = str;
					
					System.out.println("Prénom du collaborateur");
					str=sc.nextLine();
					prenomP = str;
					
					System.out.println("Mot de passe du collaborateur");
					str=sc.nextLine();
					mdp = str;
					
					System.out.println("Photo du collaborateur");
					str=sc.nextLine();
					photoP = str;
					System.out.println("\n");
					try {
						int id = creerCT(nomP, prenomP, mdp, photoP);
						System.out.println("Le collaborateur "+prenomP+" "+nomP+" a bien été créé, son identifiant est le "+id);
					} catch (CleInconnue cleInconnue) {
						System.out.println(cleInconnue.message);
						str="0";
					} catch (PersonneExistante personneExistante) {
						System.out.println(personneExistante.message);
						str="0";
					} catch (ChampVide champVide) {
						System.out.println(champVide.message);
						str="1";
					}
									
					break;
				case "2":
					
					try {
						System.out.println("Saisir l'identifiant du collaborateur pour lequel supprimer l'empreinte");
						str=sc.nextLine();
						idPersonne = Integer.parseInt(str);
						System.out.println("\n");
						
						int type = verifierPersonne(idPersonne);
						if (type == 1) {
							supprimerEmpreinte(idPersonne);
							System.out.println("L'empreinte a bien été supprimée.");	
							str="1";
						} else {
							System.out.println("Impossible de supprimer l'empreinte d'un collaborateur permanent.");
							str="2";
						}
					} catch (NumberFormatException e) {
						System.out.println("L'indentifiant du collaborateur doit être un nombre.");
						str="2";
					} catch (PersonneInconnue personneInconnue) {
						System.out.println(personneInconnue.message);
						str="2";
					} catch (CleInconnue cleInconnue) {
						System.out.println(cleInconnue.message);
						str="0";
					}
						
					break;
					
				default:
					
					break;
				}
			}
			System.out.println("\nA bientôt");
		}
		if (args[0].equals("RH")) {
			while(!str.equals("0"))
			{
				System.out.println("\n");
				System.out.println("Bienvenue sur le menu Gestionnaire de Comptes (Ressources Humaines). Veuillez choisir l'action à réaliser. (0 pour quitter)");
				
				System.out.println("1. Créer compte permanent\n2. Rechercher un collaborateur\n");
				
				str = sc.nextLine();
				
				switch (str){
				case "1":
					System.out.println("Nom du collaborateur");
					str=sc.nextLine();
					nomP = str;
					
					System.out.println("Prénom du collaborateur");
					str=sc.nextLine();
					prenomP = str;
					
					System.out.println("Mot de passe du collaborateur");
					str=sc.nextLine();
					mdp = str;
					
					System.out.println("Photo du collaborateur");
					str=sc.nextLine();
					photoP = str;
					System.out.println("\n");
					try {
						int id = creerCP(nomP, prenomP, mdp, photoP);
						System.out.println("Le collaborateur permanent "+prenomP+" "+nomP+" a bien été créé, son identifiant est le "+id);
					} catch (CleInconnue cleInconnue) {
						System.out.println(cleInconnue.message);
						str="0";
					} catch (PersonneExistante personneExistante) {
						System.out.println(personneExistante.message);
						str="0";
					} catch (ChampVide champVide) {
						System.out.println(champVide.message);
						str="1";
					}
									
					break;
				case "2":
					
					try {
						System.out.println("Saisir l'identifiant du collaborateur à rechercher");
						str=sc.nextLine();
						idPersonne = Integer.parseInt(str);
						System.out.println("\n");
						
						identite = rechercherSalarie(idPersonne);
						System.out.println("Information du collaborateur "+idPersonne+" :");
						System.out.println("Nom : "+identite.nomP);
						System.out.println("Prénom : "+identite.prenomP);
						System.out.println("Photo : "+identite.photoP);
						str="1";
					} catch (NumberFormatException e){
						System.out.println("L'indentifiant du collaborateur doit être un nombre.");
						str="2";
					} catch (PersonneInconnue personneInconnue) {
						System.out.println(personneInconnue.message);
						str="2";
					} catch (CleInconnue cleInconnue) {
						System.out.println(cleInconnue.message);
						str="0";
					}
						
					break;
					
				default:
					
					break;
				}
			}
			System.out.println("\nA bientôt");
		}
		
	}
	
	public static void main(String[] args) {
		GestionnaireComptesClient gestionnaireComptesClient = new GestionnaireComptesClient();
		gestionnaireComptesClient.menuPrincipal(args);
	}
	
	
}
