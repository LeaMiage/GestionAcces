package Journalisation;

import java.util.Hashtable;

import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.Collaborateur;
import GestionEntreeSortie.EntreeJournal;
import GestionEntreeSortie.JournalisationImpossible;

public class JournalisationImpl extends GestionEntreeSortie.JournalisationPOA{

	@Override
	public void journaliser(int idZone, int idPorte, String photoP, String statut, String typeAcces, double dateAcces, String cleAPI)
			throws JournalisationImpossible, CleInconnue {
		

		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}
		
		// Vérification au cas où l’exception n’a pas été levée plus tôt
		if (idZone==-1 || idPorte == -1 || photoP.equals("") || statut.equals("") || typeAcces.equals("")) {
			throw new JournalisationImpossible("Journalisation impossible.");
		}
		Hashtable journal = Helpers.GestionFichiers.lireFichier("src/Journalisation/Journal.txt");
		
		EntreeJournal entreeJournal = new EntreeJournal(idZone, idPorte, photoP, statut, typeAcces, dateAcces);
		
		journal.put(journal.size(), entreeJournal);
		
		Helpers.GestionFichiers.ecrireFichier("src/Journalisation/Journal.txt", journal);
		
		System.out.println("Journalisation effectuée");
	}

}
