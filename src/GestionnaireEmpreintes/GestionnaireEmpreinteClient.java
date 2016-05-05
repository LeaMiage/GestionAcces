package GestionnaireEmpreintes;

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
	        
	        authentification.authentifierCompte(0, "", "");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
