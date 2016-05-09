package Journalisation;

import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.JournalisationImpossible;

public class JournalisationImpl extends GestionEntreeSortie.JournalisationPOA{

	@Override
	public void journaliser(int idZone, int idPorte, String photoP, String statut, String typeAcces, String cleAPI)
			throws JournalisationImpossible, CleInconnue {
		// TODO Auto-generated method stub
		
		System.out.println("Test : journaliser");
	}

}
