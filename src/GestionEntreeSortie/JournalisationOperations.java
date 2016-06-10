package GestionEntreeSortie;

/**
 * Interface definition : Journalisation
 * 
 * @author OpenORB Compiler
 */
public interface JournalisationOperations
{
    /**
     * Operation journaliser
     */
    public void journaliser(int idZone, int idPorte, String photoP, String statut, String typeAcces, String cleAPI)
        throws GestionEntreeSortie.JournalisationImpossible, GestionEntreeSortie.CleInconnue;

}
