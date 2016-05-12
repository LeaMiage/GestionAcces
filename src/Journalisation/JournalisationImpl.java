package Journalisation;

import java.util.Hashtable;

import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.Collaborateur;
import GestionEntreeSortie.EntreeJournal;
import GestionEntreeSortie.JournalisationImpossible;

public class JournalisationImpl extends GestionEntreeSortie.JournalisationPOA{

	@Override
	public void journaliser(int idZone, int idPorte, String photoP, String statut, String typeAcces, String cleAPI)
			throws JournalisationImpossible, CleInconnue {
		// TODO Auto-generated method stub
		if (!cleAPI.equals("cleAPI")){
			throw new CleInconnue("La clé API est invalide.");
		}
		
		if (idZone==-1 | idPorte == -1 | photoP.equals("") | statut.equals("") | typeAcces.equals("")) {
			throw new JournalisationImpossible("Journalisation impossible.");
		}
		Hashtable journal = Helpers.GestionFichiers.lireFichier("src/Journalisation/Journal.txt");
		
		EntreeJournal entreeJournal = new EntreeJournal(idZone, idPorte, photoP, statut, typeAcces);
		
		journal.put(journal.size(), entreeJournal);
		
		Helpers.GestionFichiers.ecrireFichier("src/Journalisation/Journal.txt", journal);
		
		System.out.println("Test : journaliser");
	}

}
