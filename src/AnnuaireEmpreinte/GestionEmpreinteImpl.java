package AnnuaireEmpreinte;

import java.util.Hashtable;

import GestionEntreeSortie.ChampVide;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.Collaborateur;
import GestionEntreeSortie.Empreinte;
import GestionEntreeSortie.IdentiteCollaborateur;
import GestionEntreeSortie.PersonneInconnue;

public class GestionEmpreinteImpl extends GestionEntreeSortie.GestionEmpreintePOA{

	@Override
	public void modifierEmpreinte(int idPersonne, String empreinte, String cleAPI)
			throws CleInconnue, ChampVide {
		// TODO Auto-generated method stub
		
		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}
		Hashtable annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireEmpreinte/BD_Empreintes.txt");
				
		if (empreinte.isEmpty()){
			throw new ChampVide("L'empreinte doit être renseignée.");
		}
		
		Empreinte empreintePersonne = new Empreinte(idPersonne, empreinte);
		annuaire.put(idPersonne, empreinte);
		
		Helpers.GestionFichiers.ecrireFichier("src/AnnuaireEmpreinte/BD_Empreintes.txt", annuaire);
		
		System.out.println("Test : modifierEmpreinte");
	}

	@Override
	public void supprimerEmpreinte(int idPersonne, String cleAPI) throws PersonneInconnue, CleInconnue {
		// TODO Auto-generated method stub
		
		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}
		
		Hashtable annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireEmpreinte/BD_Empreintes.txt");
		
		if (!annuaire.containsKey(idPersonne)) {
			throw new PersonneInconnue("L'employé ne possède aucune empreinte.");
		}
		
		annuaire.remove(idPersonne);
		
		Helpers.GestionFichiers.ecrireFichier("src/AnnuaireEmpreinte/BD_Empreintes.txt", annuaire);
		
		System.out.println("Test : supprimerEmpreinte");
	}

}
