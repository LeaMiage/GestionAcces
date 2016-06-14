package EquipementPorte;

import java.text.ParseException;
import java.util.Scanner;

import GestionEntreeSortie.Authentification;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.EnvoiDonneesCapteurs;
import GestionEntreeSortie.ErreurEnvoi;

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
	
	public void accederZone(){
		
		String photo;
		String empreinte;
		String [] args = {};
		String msg;
		
		EnvoiDonneesCapteurs envoiDonnees = getServiceEnvoiDonneesCapteurs(args, idZone,idPorte);
		
		
		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		System.out.println("Ok, met ta face devant la caméra. C'est bon? Non, sourit pas comme un débile, tu veux entrer ou tu veux pas entrer?");
		photo = sc.nextLine();
		
		System.out.println("Bon, t'a pas l'air très futé toi... Maintenant met ton putain de doigt sur le lecteur d'empreinte. \nL'index gauche. L'autre tu peux te le carrer ailleurs, rien à foutre.");
		empreinte = sc.nextLine();
		
		
		try{
			
			msg = envoiDonnees.accederZone(empreinte, photo, Utils.Utils.cleApi);
			
			System.out.println("Non, en fait tu passeras pas, va chier boloss.\n");
			
			Thread.sleep(5000);
			
			System.out.println("C'est bon je deeeeeeeeeeeec, entre, viens on est biens.");
			
		} catch (CleInconnue e) {
			System.out.println("Erreur : clé inconnue");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ErreurEnvoi e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void menuPorte(){
		

		Scanner sc = new Scanner(System.in);
		String str = "1";
		
		while(!str.equals("0"))
		{

		System.out.println("Bienvenue sur le menu Porte"+ idPorte + " de la zone " + idZone + ". Veuillez choisir l'action à réaliser. (0 pour quitter)");
		
		System.out.println("1. Entrer dans la zone\n2. Sortir de la zone\n");
		

		str = sc.nextLine();
		
		switch (str){
		case "1":
			accederZone();
			
			
			break;
		case "2":
			
			
			break;

			
		default:
			System.out.println(str);
			break;
		}
		
		
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		String msg;
		
		System.out.println("Test d'accès aux zones");
		
		EquipementPorteClient ep = new EquipementPorteClient(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		
		
		System.out.println("EnvoiDonneesCapteurs récupéré");
		
		ep.menuPorte();
		
		
		
		
		
		
	}
	
	
	
	
	
}
