package GestionnaireEmpreintes;

import java.util.Scanner;

import GestionEntreeSortie.Authentification;
import GestionEntreeSortie.ChampVide;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.EmpreinteExistante;
import GestionEntreeSortie.ErreurAuthentification;
import GestionEntreeSortie.GestionAutorisation;
import GestionEntreeSortie.GestionEmpreinte;
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.PersonneExistante;
import GestionEntreeSortie.PersonneInconnue;

public class GestionnaireEmpreinteClient {
	
	public static Authentification getServiceAuthentification(String args[]){
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
	        	        
	        // Casting des objets CORBA
	        Authentification authentification = GestionEntreeSortie.AuthentificationHelper.narrow(distantAuthentification);
	        return authentification;
	        
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
	        String idObj2 = "GestionEmpreinte";
	        
	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
	        
	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind2 = new org.omg.CosNaming.NameComponent[1];
	        nameToFind2[0] = new org.omg.CosNaming.NameComponent(idObj2,"");
	        
	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantGestionEmpreinte = nameRoot.resolve(nameToFind2);
        
	        // Casting des objets CORBA
	        GestionEntreeSortie.GestionEmpreinte gestionEmpreinte = GestionEntreeSortie.GestionEmpreinteHelper.narrow(distantGestionEmpreinte);
	        
	        return gestionEmpreinte;
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void supprimerEmrpeinte(int idPersonne) throws PersonneInconnue, CleInconnue{
		String [] args = {};
		
		GestionEmpreinte gestionEmpreinte = GestionnaireEmpreinteClient.getServiceGestionEmpreinte(args);
		gestionEmpreinte.supprimerEmpreinte(idPersonne, Utils.Utils.cleApi);		 
	}
	
	public void modifierEmpreinte(int idPersonne, String empreinte) throws PersonneInconnue, CleInconnue, ChampVide{
		String [] args = {};
		
		GestionEmpreinte gestionEmpreinte = GestionnaireEmpreinteClient.getServiceGestionEmpreinte(args);
		gestionEmpreinte.modifierEmpreinte(idPersonne, empreinte, Utils.Utils.cleApi);
	}
	
	public void ajouterEmpreinte(int idPersonne, String empreinte) throws CleInconnue, ChampVide, EmpreinteExistante{
		String [] args = {};
		
		GestionEmpreinte gestionEmpreinte = GestionnaireEmpreinteClient.getServiceGestionEmpreinte(args);
		gestionEmpreinte.ajouterEmpreinte(idPersonne, empreinte, Utils.Utils.cleApi);
	}
	
	//retourne 1 pour temporaire
	public int authentifierCompte(int idPersonne, String mdp) throws ErreurAuthentification, CleInconnue{
		String [] args = {};
		int type = -1;
		Authentification authentification = GestionnaireEmpreinteClient.getServiceAuthentification(args);
		type = authentification.authentifierCompte(idPersonne, mdp, Utils.Utils.cleApi);
		
		return type;
	}
	
	public void menuPrincipal() {
		
		int idPersonne;
		String mdp;
		
		// Main du gestionnaire d'empreinte

		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		while(!str.equals("0"))
		{
			
			System.out.println("Bienvenue sur le menu Gestionnaire des Empreintes. Veuillez vous authentifier pour gérer votre empreinte. (0 pour quitter)");
			
			System.out.println("1. S'authentifier\n");
			
			str = sc.nextLine();
			
			switch (str){
			case "1":
				try {
					System.out.println("Entrez votre identifiant");
					str=sc.nextLine();
					idPersonne = Integer.parseInt(str);
					
					System.out.println("Entrez votre mot de passe");
					str=sc.nextLine();
					mdp = str;
					System.out.println("\n");
					
					int type = authentifierCompte(idPersonne, mdp);
					switch (type) {
					case 0:
						//permanent
						menuCollaborateurPermanent(idPersonne);
						break;
					case 1:
						//temporaire
						menuCollaborateurTemporaire(idPersonne);
						break;

					default:
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("Veuillez saisir un nombre entier.");
					str="1";
				} catch (ErreurAuthentification erreurAuthentification) {
					System.out.println(erreurAuthentification.message);
					str = "1";
				} catch (CleInconnue cleInconnue) {
					System.out.println(cleInconnue.message);
					str = "0";
				}				
				break;
				
			default:
				break;
			}
			
		}
		System.out.println("\nA bientôt");
	}

	public void menuCollaborateurPermanent(int idPersonne) {
		
		String empreinte;
		

		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		while(!str.equals("0"))
		{
			
			System.out.println("Bienvenue sur le menu Gestionnaire des Empreintes (Collaborateur Permanent). Veuillez choisir l'action à réaliser. (0 pour quitter)");
			
			System.out.println("1. Ajouter votre empreinte.\n2. Modifier votre empreinte.");
			
			str = sc.nextLine();
			
			switch (str){
			case "1":
				System.out.println("Ajout d'une nouvelle empreinte");
				System.out.println("Veuillez déposer votre empreinte");
				empreinte=sc.nextLine();
				System.out.println("\n");
				
				try {
					ajouterEmpreinte(idPersonne, empreinte);
					System.out.println("Votre emrpeinte a bien été ajoutée.");
				}  catch (CleInconnue cleInconnue){
					System.out.println(cleInconnue.message);
					str="0";
				} catch (ChampVide champVide) {
					System.out.println(champVide.message);
					str="1";
				} catch (EmpreinteExistante empreinteExistante) {
					System.out.println(empreinteExistante.message);
					str="1";
				}				
				break;
				
			case "2":
				System.out.println("Modification de l'empreinte");
				System.out.println("Veuillez déposer votre empreinte");
				empreinte=sc.nextLine();

				try {
					modifierEmpreinte(idPersonne, empreinte);
					System.out.println("Votre emrpeinte a bien été modifiée.");
				}  catch (PersonneInconnue personneInconnue){
					System.out.println(personneInconnue.message);
				} catch (CleInconnue cleInconnue){
					System.out.println(cleInconnue.message);
					str="0";
				} catch (ChampVide champVide) {
					System.out.println(champVide.message);
					str="1";
				}
				
				break;
			default:
				break;
			}
		}
	}
	
	public void menuCollaborateurTemporaire(int idPersonne) {
		
		String empreinte;
		

		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		while(!str.equals("0"))
		{
			
			System.out.println("Bienvenue sur le menu Gestionnaire des Empreintes (Collaborateur Temporaire). Veuillez choisir l'action à réaliser. (0 pour quitter)");
			
			System.out.println("1. Ajouter votre empreinte.");
			
			str = sc.nextLine();
			
			switch (str){
			case "1":
				System.out.println("Ajout d'une nouvelle empreinte");
				System.out.println("Veuillez déposer votre empreinte");
				empreinte=sc.nextLine();
				System.out.println("\n");
				
				try {
					ajouterEmpreinte(idPersonne, empreinte);
					System.out.println("Votre emrpeinte a bien été ajoutée.");
				}  catch (CleInconnue cleInconnue){
					System.out.println(cleInconnue.message);
					str="0";
				} catch (ChampVide champVide) {
					System.out.println(champVide.message);
					str="1";
				} catch (EmpreinteExistante empreinteExistante) {
					System.out.println(empreinteExistante.message);
					str="1";
				}				
				break;
				
			default:
				break;
			}
		}
	}

	public static void main(String[] args) {
		GestionnaireEmpreinteClient gestionnaireEmpreinte = new GestionnaireEmpreinteClient();
		gestionnaireEmpreinte.menuPrincipal();
	}

}
