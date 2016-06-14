package Journalisation;

import java.util.Enumeration;
import java.util.Hashtable;

import GestionEntreeSortie.CleInconnue;
import GestionEntreeSortie.ConsultationJournalPOA;
import GestionEntreeSortie.EntreeJournal;

public class ConsultationJournalImpl extends ConsultationJournalPOA{

	@Override
	public EntreeJournal[] consulterJournal(String cleAPI) throws CleInconnue {
		// TODO Auto-generated method stub
		if (!cleAPI.equals(Utils.Utils.cleApi)){
			throw new CleInconnue("Erreur système, veuillez réessayer plus tard.");
		}
		int i = 0;
		
		Hashtable journal = Helpers.GestionFichiers.lireFichier("src/Journalisation/Journal.txt");
		
		EntreeJournal[] entreesJournal = new EntreeJournal[journal.size()];
		Enumeration e = journal.elements();
		
		while (e.hasMoreElements()){
			entreesJournal[i] = (EntreeJournal) e.nextElement();
			i++;
		}
		
		System.out.println("Test : consulterJournal");
		
		return entreesJournal;
	}

}
