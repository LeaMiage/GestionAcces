package AnnuaireEmpreinte;

import java.lang.ref.PhantomReference;
import java.util.Hashtable;

import GestionEntreeSortie.ChampVide;
import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.EmpreinteInconnue;
import GestionEntreeSortie.PersonneInconnue;

public class VerificationEmpreinteImpl extends GestionEntreeSortie.VerificationEmpreintePOA{

	@Override
	public void verifierEmpreinte(int idPersonne, String empreinte, String cleAPI)
			throws EmpreinteInconnue, CleInconnue, ChampVide {
		// TODO Auto-generated method stub
		
		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}
		
		if (empreinte.isEmpty()) {
			throw new ChampVide("Erreur : un champ requis est vide.");
		}
		
		Hashtable annuaire = Helpers.GestionFichiers.lireFichier("src/AnnuaireEmpreinte/BD_Empreintes.txt");
		
		if (!annuaire.containsKey(idPersonne)) {
			throw new EmpreinteInconnue("Erreur : aucune empreinte n'est enregistrée pour cet employé.");
		}
		
		if(!annuaire.get(idPersonne).equals(empreinte)) {
			throw new EmpreinteInconnue("Erreur : l'empreinte ne correspnd pas à l'employé.");
		}
		
		System.out.println("Test : verifierEmpreinte");
		
	}

}
