package GestionEntreeSortie;

/**
 * Interface definition : GestionSalaries
 * 
 * @author OpenORB Compiler
 */
public interface GestionSalariesOperations
{
    /**
     * Operation rechercherSalarie
     */
    public GestionEntreeSortie.IdentiteCollaborateur rechercherSalarie(int idPersonne, String cleAPI)
        throws GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue;

    /**
     * Operation verifierPersonne
     */
    public int verifierPersonne(int idPersonne, String cleAPI)
        throws GestionEntreeSortie.PersonneInconnue, GestionEntreeSortie.CleInconnue;

}
