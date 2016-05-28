package Porte;

import java.util.Hashtable;

import GestionEntreeSortie.AutorisationInconnue;
import GestionEntreeSortie.AutorisationPermanente;
import GestionEntreeSortie.AutorisationTemporaire;
import GestionEntreeSortie.CleInconnue;

public class GestionAutorisationsImpl extends GestionEntreeSortie.GestionAutorisationPOA{

	
	
	@Override
	public void ajouterAutorisationPermanente(AutorisationPermanente ap, String cleAPI)
			throws AutorisationInconnue, CleInconnue {
		// TODO Auto-generated method stub
		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}
		
		
		Hashtable annuaireAutorisations = Helpers.GestionFichiers.lireFichier("src/Porte/BD_Autorisations.txt");
		
		
				
			
		annuaireAutorisations.put(ap.heureDebut + "_" + ap.heureFin, ap);
		
		
		
		System.out.println("Test : ajouterAutorisationPermanente");
	}

	@Override
	public void modifierAutorisationPermanente(AutorisationPermanente ap, AutorisationPermanente np, String cleAPI)
			throws AutorisationInconnue, CleInconnue {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerAutorisationPermanente(AutorisationPermanente ap, String cleAPI)
			throws AutorisationInconnue, CleInconnue {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterAutorisationTemporaire(AutorisationTemporaire at, String cleAPI)
			throws AutorisationInconnue, CleInconnue {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierAutorisationTemporaire(AutorisationTemporaire at, AutorisationTemporaire nt, String cleAPI)
			throws AutorisationInconnue, CleInconnue {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerAutorisationTemporaire(AutorisationTemporaire at, String cleAPI)
			throws AutorisationInconnue, CleInconnue {
		// TODO Auto-generated method stub
		
	}

}
