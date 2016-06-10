package Porte;

import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;


public class PorteServer {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
	        // Intialisation de l'ORB
	        //************************
	        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Gestion du POA
	        //****************
	        // Recuperation du POA
	        POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

	        // Creation du servant
	        //*********************
	        EnvoiDonneesCapteursImpl servantEnvoiDonneesCapteurs = new EnvoiDonneesCapteursImpl(Integer.parseInt(args[0]),Integer.parseInt(args[1]));

	        GestionAutorisationsImpl servantGestionAutorisations = new GestionAutorisationsImpl(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
	       
	        // Activer le servant au sein du POA et recuperer son ID
	        byte[] servantEnvoiDonneesCapteursId = rootPOA.activate_object(servantEnvoiDonneesCapteurs);
	        byte[] servantCreationCompteId = rootPOA.activate_object(servantGestionAutorisations);
	        
	        // Activer le POA manager
	        rootPOA.the_POAManager().activate();

	        // Enregistrement dans le service de nommage
	        //*******************************************
	        // Recuperation du naming service
	        NamingContext nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

	        // Construction du nom a enregistrer
	        org.omg.CosNaming.NameComponent[] nameToRegister1 = new org.omg.CosNaming.NameComponent[1];
	        org.omg.CosNaming.NameComponent[] nameToRegister2 = new org.omg.CosNaming.NameComponent[1];
	        
	        String nomServant1 = "EnvoiDonneesCapteurs_ " + Integer.parseInt(args[0]) + "_" + Integer.parseInt(args[1]);
	        String nomServant2 = "GestionAutorisations_ " + Integer.parseInt(args[0]) + "_" + Integer.parseInt(args[1]);
	        
	        nameToRegister1[0] = new org.omg.CosNaming.NameComponent(nomServant1,"");
	        nameToRegister2[0] = new org.omg.CosNaming.NameComponent(nomServant2,"");

	        
	        //**************************************************************************************
	        // Enregistrement de l'objet CORBA dans le service de noms (GestionEmpreinte)
	        nameRoot.rebind(nameToRegister1,rootPOA.servant_to_reference(servantEnvoiDonneesCapteurs));

	        System.out.println("==> Nom '"+ nomServant1 + "' est enregistre dans le service de noms.");

	        String IORServant1 = orb.object_to_string(rootPOA.servant_to_reference(servantEnvoiDonneesCapteurs));
	        System.out.println("L'objet possede la reference suivante :");
	        System.out.println(IORServant1);

	        
	        //**************************************************************************************
	        // Enregistrement de l'objet CORBA dans le service de noms (VerificationEmpreinte)
	        nameRoot.rebind(nameToRegister2,rootPOA.servant_to_reference(servantGestionAutorisations));
	        
	        
	        System.out.println("==> Nom '"+ nomServant2 + "' est enregistre dans le service de noms.");

	        String IORServant2 = orb.object_to_string(rootPOA.servant_to_reference(servantGestionAutorisations));
	        System.out.println("L'objet possede la reference suivante :");
	        System.out.println(IORServant2);
	        
	        // Lancement de l'ORB et mise en attente de requete
	        //**************************************************
	        orb.run();

	    }
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
