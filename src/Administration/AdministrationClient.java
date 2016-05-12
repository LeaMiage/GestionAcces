package Administration;

import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.PersonneInconnue;

public class AdministrationClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Nom de l'objet CORBA
	        String idObj = "ConsultationJournal";

	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantConsultationJournal = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantConsultationJournal));
	        
	        // Casting des objets CORBA
	        GestionEntreeSortie.ConsultationJournal consultationJournal = GestionEntreeSortie.ConsultationJournalHelper.narrow(distantConsultationJournal);
	        
	        consultationJournal.consulterJournal("cleAPI");
	        
	        //*****************************************************//
	        
	        //MODIFIER pour SERVANT gestionAutorisation
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
	        
	        IdentiteCollaborateur ic = gestionSalaries.rechercherSalarie(3, "cleAPI");
	        System.out.println(ic.idPersonne + " " + ic.nomP + " " + ic.prenomP); 
	        
		}catch (CleInconnue cleInconnue){
			System.out.println(cleInconnue.message);
		}catch (PersonneInconnue personneInconnue){
			System.out.println(personneInconnue.message);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
