package GestionEntreeSortie;

/**
 * Interface definition : EnvoiDonneesCapteurs
 * 
 * @author OpenORB Compiler
 */
public interface EnvoiDonneesCapteursOperations
{
    /**
     * Operation accederZone
     */
    public void accederZone(String empreinte, String photoP, String cleAPI)
        throws GestionEntreeSortie.ErreurEnvoi, GestionEntreeSortie.CleInconnue;

    /**
     * Operation sortirZone
     */
    public void sortirZone(String empreinte, String photoP, String cleAPI)
        throws GestionEntreeSortie.ErreurEnvoi, GestionEntreeSortie.CleInconnue;

}
