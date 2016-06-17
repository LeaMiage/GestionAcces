package AnnuaireSalaries;

import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class AnnuaireSalariesServer {

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
	        AuthentificationImpl servantAuthentification = new AuthentificationImpl();

	        CreationCompteImpl servantCreationCompte = new CreationCompteImpl();
	        
	        GestionSalariesImpl servantGestionSalaries = new GestionSalariesImpl();
	       
	        // Activer le servant au sein du POA et recuperer son ID
	        byte[] servantAuthentificationId = rootPOA.activate_object(servantAuthentification);
	        byte[] servantCreationCompteId = rootPOA.activate_object(servantCreationCompte);
	        byte[] servantGestionSalariesId = rootPOA.activate_object(servantGestionSalaries);
	        
	        // Activer le POA manager
	        rootPOA.the_POAManager().activate();

	        // Enregistrement dans le service de nommage
	        //*******************************************
	        // Recuperation du naming service
	        NamingContext nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object(Utils.Utils.corbaloc));

	        // Construction du nom a enregistrer
	        org.omg.CosNaming.NameComponent[] nameToRegister1 = new org.omg.CosNaming.NameComponent[1];
	        org.omg.CosNaming.NameComponent[] nameToRegister2 = new org.omg.CosNaming.NameComponent[1];
	        org.omg.CosNaming.NameComponent[] nameToRegister3 = new org.omg.CosNaming.NameComponent[1];
	        
	        String nomServant1 = "Authentification";
	        String nomServant2 = "CreationCompte";
	        String nomServant3 = "GestionSalaries";
	        
	        nameToRegister1[0] = new org.omg.CosNaming.NameComponent(nomServant1,"");
	        nameToRegister2[0] = new org.omg.CosNaming.NameComponent(nomServant2,"");
	        nameToRegister3[0] = new org.omg.CosNaming.NameComponent(nomServant3,"");

	        
	        //**************************************************************************************
	        // Enregistrement de l'objet CORBA dans le service de noms (Authentification)
	        nameRoot.rebind(nameToRegister1,rootPOA.servant_to_reference(servantAuthentification));

	        System.out.println("==> Nom '"+ nomServant1 + "' est enregistre dans le service de noms.");

	        String IORServant1 = orb.object_to_string(rootPOA.servant_to_reference(servantAuthentification));
	        System.out.println("L'objet possede la reference suivante :");
	        System.out.println(IORServant1);

	        
	        //**************************************************************************************
	        // Enregistrement de l'objet CORBA dans le service de noms (CreationCompte)
	        nameRoot.rebind(nameToRegister2,rootPOA.servant_to_reference(servantCreationCompte));
	        
	        
	        System.out.println("==> Nom '"+ nomServant2 + "' est enregistre dans le service de noms.");

	        String IORServant2 = orb.object_to_string(rootPOA.servant_to_reference(servantCreationCompte));
	        System.out.println("L'objet possede la reference suivante :");
	        System.out.println(IORServant2);
	        
	        //**************************************************************************************
	        // Enregistrement de l'objet CORBA dans le service de noms (GestionSalaries)
	        nameRoot.rebind(nameToRegister3,rootPOA.servant_to_reference(servantGestionSalaries));
	        
	        
	        System.out.println("==> Nom '"+ nomServant3 + "' est enregistre dans le service de noms.");

	        String IORServant3 = orb.object_to_string(rootPOA.servant_to_reference(servantGestionSalaries));
	        System.out.println("L'objet possede la reference suivante :");
	        System.out.println(IORServant3);
	        
	        // Lancement de l'ORB et mise en attente de requete
	        //**************************************************
	        orb.run();

	    }
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
