package AnnuaireEmpreinte;

import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.PersonneInconnue;

public class GestionEmpreinteImpl extends GestionEntreeSortie.GestionEmpreintePOA{

	@Override
	public void modifierEmpreinte(int idPersonne, String empreinte, String cleAPI)
			throws PersonneInconnue, CleInconnue {
		// TODO Auto-generated method stub
		
		System.out.println("Test : modifierEmpreinte");
		
	}

	@Override
	public void supprimerEmpreinte(int idPersonne, String cleAPI) throws PersonneInconnue, CleInconnue {
		// TODO Auto-generated method stub
		
		System.out.println("Test : supprimerEmpreinte");
		
	}

}
