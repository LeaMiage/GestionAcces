package AnnuaireEmpreinte;

import java.util.Hashtable;

import GestionEntreeSortie.ChampVide;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.Collaborateur;
import GestionEntreeSortie.Empreinte;
import GestionEntreeSortie.EmpreinteExistante;
import GestionEntreeSortie.GestionSalaries;
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.PersonneInconnue;

public class GestionEmpreinteImpl extends GestionEntreeSortie.GestionEmpreintePOA{

	@Override
	public void modifierEmpreinte(int idPersonne, String empreinte, String cleAPI)
			throws PersonneInconnue, CleInconnue, ChampVide {
		String [] args = {};
		// TODO Auto-generated method stub

		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}

		Hashtable annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireEmpreinte/BD_Empreintes.txt");

		if (!annuaire.containsKey(idPersonne)){
			throw new PersonneInconnue("Aucune empreinte n'est actuellement enregistrée pour vous. Veuillez en ajouter une pour la modifier.");
		}
		if (empreinte.isEmpty()){
			throw new ChampVide("L'empreinte doit être renseignée.");
		}

		Empreinte empreintePersonne = new Empreinte(idPersonne, empreinte);
		annuaire.put(idPersonne, empreinte);

		Helpers.GestionFichiers.ecrireFichier("src/AnnuaireEmpreinte/BD_Empreintes.txt", annuaire);


	}

	@Override
	public void supprimerEmpreinte(int idPersonne, String cleAPI) throws PersonneInconnue, CleInconnue {
		// TODO Auto-generated method stub
		String [] args = {};

		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}

		GestionSalaries gestionSalarie = GestionEmpreinteImpl.getGestionSalaries(args);

		Hashtable annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireEmpreinte/BD_Empreintes.txt");

		if (!annuaire.containsKey(idPersonne)) {
			throw new PersonneInconnue("L'employé ne possède aucune empreinte.");
		}

		annuaire.remove(idPersonne);

		Helpers.GestionFichiers.ecrireFichier("src/AnnuaireEmpreinte/BD_Empreintes.txt", annuaire);


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
					org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object(Utils.Utils.corbaloc));


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

	@Override
	public void ajouterEmpreinte(int idPersonne, String empreinte, String cleAPI)
			throws EmpreinteExistante, CleInconnue, ChampVide {
		// TODO Auto-generated method stub
		String [] args = {};

		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}

		Hashtable annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireEmpreinte/BD_Empreintes.txt");

		if (annuaire.containsKey(idPersonne)){
			throw new EmpreinteExistante("Une empreinte existe déjà pour l'employé numéro "+idPersonne+". Impossible de la modifier.");
		}
		if (empreinte.isEmpty()){
			throw new ChampVide("L'empreinte doit être renseignée.");
		}

		Empreinte empreintePersonne = new Empreinte(idPersonne, empreinte);
		annuaire.put(idPersonne, empreinte);

		Helpers.GestionFichiers.ecrireFichier("src/AnnuaireEmpreinte/BD_Empreintes.txt", annuaire);



	}

	public void initialisation(){
		Hashtable annuaire = new Hashtable<>();

		//Initialisation des fichiers à vide
		Helpers.GestionFichiers.ecrireFichier("src/AnnuaireEmpreinte/BD_Empreintes.txt", annuaire);

		// Ajout des empreintes par défaut
		try {
			ajouterEmpreinte(1, "empreinteTiti", Utils.Utils.cleApi);
			ajouterEmpreinte(2, "empreinteLea", Utils.Utils.cleApi);
			ajouterEmpreinte(3, "empreinteTheo", Utils.Utils.cleApi);
			ajouterEmpreinte(4, "empreinteBastien", Utils.Utils.cleApi);
		} catch (CleInconnue e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ChampVide e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmpreinteExistante e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
