package AnnuaireEmpreinte;

import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.EmpreinteInconnue;

public class VerificationEmpreinteImpl extends GestionEntreeSortie.VerificationEmpreintePOA{

	@Override
	public void verifierEmpreinte(int idPersonne, String empreinte, String cleAPI)
			throws EmpreinteInconnue, CleInconnue {
		// TODO Auto-generated method stub
		
		System.out.println("Test : verifierEmpreinte");
		
	}

}
