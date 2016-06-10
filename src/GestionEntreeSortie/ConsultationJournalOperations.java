package GestionEntreeSortie;

/**
 * Interface definition : ConsultationJournal
 * 
 * @author OpenORB Compiler
 */
public interface ConsultationJournalOperations
{
    /**
     * Operation consulterJournal
     */
    public GestionEntreeSortie.EntreeJournal[] consulterJournal(String cleAPI)
        throws GestionEntreeSortie.CleInconnue;

}
