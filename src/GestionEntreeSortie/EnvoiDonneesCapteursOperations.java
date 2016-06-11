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
    public String accederZone(String empreinte, String photoP, String cleAPI)
        throws GestionEntreeSortie.ErreurEnvoi, GestionEntreeSortie.CleInconnue;

    /**
     * Operation sortirZone
     */
    public String sortirZone(String empreinte, String photoP, String cleAPI)
        throws GestionEntreeSortie.ErreurEnvoi, GestionEntreeSortie.CleInconnue;

}
