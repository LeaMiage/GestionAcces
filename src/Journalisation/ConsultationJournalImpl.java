package Journalisation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.ConsultationJournalPOA;
import GestionEntreeSortie.EntreeJournal;

public class ConsultationJournalImpl extends ConsultationJournalPOA{

	@Override
	public EntreeJournal[] consulterJournal(String cleAPI) throws CleInconnue {
		

		if (! cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}
		
		// Lecture + tri du fichier de journalisation
		int i = 0;
		
		Hashtable journal = Helpers.GestionFichiers.lireFichier("src/Journalisation/Journal.txt");
		
		
		EntreeJournal[] entreesJournal = new EntreeJournal[journal.size()];
		List<Integer> listeTriee = new ArrayList<Integer>(journal.keySet());
	    Collections.sort(listeTriee);
	    
	    for (int key = listeTriee.size()-1; key>=0; key--) {
	    	entreesJournal[i] = (EntreeJournal) journal.get(key);
			i++;
		}
	    
		return entreesJournal;
	}

}
