package EquipementPorte;

import java.text.ParseException;
import java.util.Scanner;

import GestionEntreeSortie.Authentification;
import GestionEntreeSortie.ChampVide;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.EmpreinteInconnue;
import GestionEntreeSortie.EnvoiDonneesCapteurs;
import GestionEntreeSortie.ErreurAuthentification;
import GestionEntreeSortie.ErreurEnvoi;
import GestionEntreeSortie.NonAutorise;

public class EquipementPorteClient {

	private int idZone;
	private int idPorte;
	
	public EquipementPorteClient(int idZone, int idPorte)
	{
		this.idZone=idZone;
		this.idPorte=idPorte;
	}
	
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
	       // System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	       // System.out.println(orb.object_to_string(distantEnvoiDonneesCapteurs));
	        
	        // Casting des objets CORBA
	        GestionEntreeSortie.EnvoiDonneesCapteurs envoiDonneesCapteurs = GestionEntreeSortie.EnvoiDonneesCapteursHelper.narrow(distantEnvoiDonneesCapteurs);
	       
	        return envoiDonneesCapteurs;
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//type = 1 pour entrer et type = 2 pour sortir
	public void entreeSortieZone(int type){
		
		String photo;
		String empreinte;
		String [] args = {};
		String msg;
		
		EnvoiDonneesCapteurs envoiDonnees = getServiceEnvoiDonneesCapteurs(args, idZone,idPorte);
		
		
		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		System.out.println("Positionnez-vous devant la caméra pour que l'équipement vous prenne en photo.");
		photo = sc.nextLine();
		
		System.out.println("Veuillez maintenant positionner votre doigt sur le capteur.");
		empreinte = sc.nextLine();
		
		
		try{
			
			//Accéder zone si type = 1 sinon sortir Zone
			if (type == 1) {
				msg = envoiDonnees.accederZone(empreinte, photo, Utils.Utils.cleApi);
				System.out.println("Accès autorisé : " + msg);
			} else {
				msg = envoiDonnees.sortirZone(empreinte, photo, Utils.Utils.cleApi);
				System.out.println("Sortie autorisée : " + msg);
			}
			
			
		} catch (CleInconnue e) {
			System.out.println("Erreur : clé inconnue");
		} catch (ErreurEnvoi e) {
			System.out.println("Erreur lors de l'envoi des données");
		} catch (ErreurAuthentification e) {
			if (type == 1)
				System.out.println("Accès refusé : Photo non reconnue");
			else
				System.out.println("Sortie refusée : Photo non reconnue");
		} catch (EmpreinteInconnue e) {
			if (type == 1)
				System.out.println("Accès refusé : Empreinte non reconnue");
			else
				System.out.println("Sortie refusée : Empreinte non reconnue");
		} catch (ChampVide e) {
			System.out.println("Erreur : Champ vide détecté");
		} catch (NonAutorise e) {
			if (type == 1)
				System.out.println("Accès refusé : Vous n'avez pas l'autorisation d'accéder à cette zone");
			else
				System.out.println("Sortie refusée : Vous n'avez pas l'autorisation de sortir de cette zone");
		}
	}
	
	public void menuPorte(){
		

		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		while(!str.equals("0"))
		{

		System.out.println("Bienvenue sur le menu Porte "+ idPorte + " de la zone " + idZone + ". Veuillez choisir l'action à réaliser. (0 pour quitter)");
		
		System.out.println("1. Entrer dans la zone\n2. Sortir de la zone\n");
		

		str = sc.nextLine();
		
		switch (str){
		case "1":
			entreeSortieZone(1);
			
			
			break;
		case "2":
			entreeSortieZone(2);
			
			break;

			
		default:
			System.out.println(str);
			break;
		}
		
		
		}
		
		
	}
	
	
	
	public static void main(String[] args) {

		EquipementPorteClient ep = new EquipementPorteClient(Integer.parseInt(args[0]),Integer.parseInt(args[1]));

		ep.menuPorte();
		
	}
	
	
	
	
	
}
